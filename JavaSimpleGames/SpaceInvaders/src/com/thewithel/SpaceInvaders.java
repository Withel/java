package com.thewithel;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;

//THE CORE OF THE GAME IS MADE BY Almas Baimagambetov
//We'll update it soon :D starting from smoother movement

public class SpaceInvaders extends Application {

    private Pane root = new Pane();

    private double t = 0;

    private Sprite player = new Sprite(300, 750, 40, 40, "player", Color.BLUE);

    boolean moveLeft=false, moveRight=false, spacePressed = false;

    //setting up a root
    private Parent createContent(){
        root.setPrefSize(600, 800);
        root.getChildren().add(player);
        //animation timer is something like game loop?
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };

        timer.start();

        nextLevel();

        return root;
    }

    //it generates enemies
    private void nextLevel(){
        for(int i=0; i<5;i++){
            Sprite s = new Sprite(90+i*100, 150, 30, 30, "enemy", Color.RED);

            root.getChildren().add(s);
        }
    }

    //converts all the sprites into one list
    private List<Sprite> sprites(){
        return root.getChildren().stream().map(n -> (Sprite)n).collect(Collectors.toList());
    }

    //this function is main logic of the game
    private void update(){
        //how frequently is update running
        t+= 0.016;

//        if(moveLeft) {
//            player.moveLeft();
//            moveLeft = false;
//        }
//        if(moveRight) {
//            player.moveRight();
//            moveRight = false;
//        }
//        if(spacePressed) shoot(player);

        sprites().forEach(s->{
            switch(s.type){
                case "enemybullet":
                   s.moveDown();
                   //IF YOU PUT A SEMICOLON AFTER player.getBoundsInparent())) to sie wypierdoli
                   if(s.getBoundsInParent().intersects(player.getBoundsInParent())){
                       player.dead = true;
                       s.dead = true;
                    }
                    break;
                case "playerbullet":
                    s.moveUp();

                    sprites().stream().filter(e->e.type.equals("enemy")).forEach(enemy -> {
                        if(s.getBoundsInParent().intersects(enemy.getBoundsInParent())){
                            enemy.dead = true;
                            s.dead = true;
                        }
                    });
                    break;

                case "enemy":

                    if(t > 2){
                        if(Math.random() < 0.3){
                            shoot(s);
                        }
                    }
                    break;
            }
        });

        root.getChildren().removeIf(n-> {
            Sprite s =(Sprite) n;
            return s.dead;
        });

        if(t>2) {
            t = 0;
        }

    }

    private void shoot(Sprite who){
        Sprite s = new Sprite((int)who.getTranslateX() + 20, (int)who.getTranslateY(), 5, 20,who.type + "bullet", Color.BLACK);

        root.getChildren().add(s);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Scene scene = new Scene(createContent());

        //some werid shit is going on right here
        scene.setOnKeyPressed(e-> {
            switch(e.getCode()){
                case A:
                    player.moveLeft();
                    break;
                case D:
                    player.moveRight();
                    break;
                case SPACE:
                   shoot(player);
                    break;
            }

//            switch(e.getCode()){
//                case A:
//                    moveLeft = true;
//                    break;
//                case D:
//                    moveRight = true;
//                    break;
//                case SPACE:
//                    spacePressed = true;
//                    break;
//            }

        });

        System.out.println("manamana");
        stage.setScene(scene);
        stage.show();
    }

    private static class Sprite extends Rectangle {
        final String type;
        boolean dead = false;

        Sprite(int x, int y, int w, int h, String type, Color color){
            super(w, h, color);

            this.type = type;
            //"translate means move"
            setTranslateX(x);
            setTranslateY(y);
        }

        void moveLeft(){
            setTranslateX(getTranslateX() -5);
        }

        void moveRight(){
            setTranslateX(getTranslateX() +5);
        }

        void moveUp(){
            setTranslateY(getTranslateY() - 5);
        }

        void moveDown(){
            setTranslateY(getTranslateY() + 5);
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}
