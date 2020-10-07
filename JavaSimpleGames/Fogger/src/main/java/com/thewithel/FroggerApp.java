package com.thewithel;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


//@TODO separate this code in different classes
public class FroggerApp extends Application {

    private AnimationTimer timer;
    private Timeline timeline;
    //@TODO add static variables
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int FROG_SIZE = 38;
    public static final int CAR_SIZE = 40;

    public static final int SPEED = 15;
    public static final double FREQUENCY = 0.2;

    private Pane root;

    private List<Node> cars = new ArrayList<>();
    private Node frog;

    private Parent createContent() {
        root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);

        frog = initFrog();

        root.getChildren().add(frog);

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> onUpdate()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setRate(60);
        timeline.play();

//        timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                onUpdate();
//            }
//        };
//        timer.start();
        return root;
    }

    private Node initFrog() {
        Rectangle rect = new Rectangle(FROG_SIZE, FROG_SIZE, Color.GREEN);
        rect.setTranslateY(HEIGHT - (FROG_SIZE+1));
        rect.setTranslateX(WIDTH/2 - FROG_SIZE);

        return rect;
    }

    private Node spawnCar() {
        Rectangle rect = new Rectangle(CAR_SIZE, CAR_SIZE, Color.RED);
        rect.setTranslateY((int)(Math.random() * 14) * CAR_SIZE);

        root.getChildren().add(rect);
        return rect;
    }

    public void onUpdate() {
        for (Node car : cars) {
            car.setTranslateX(car.getTranslateX() + SPEED);
        }
        if (Math.random() < FREQUENCY) {
            cars.add(spawnCar());
        }

        checkState();
    }

    //@TODO add game losing and game winning sequences
    private void checkState() {
        for (Node car : cars) {
            if (car.getBoundsInParent().intersects(frog.getBoundsInParent())) {
                frog.setTranslateY(HEIGHT - (FROG_SIZE+1));
                frog.setTranslateX(WIDTH/2 - FROG_SIZE);
                return;
            }
        }
        if (frog.getTranslateY() <= 0) {
            String win = "YOU WIN";

            HBox hBox = new HBox();
            hBox.setTranslateX(300);
            hBox.setTranslateY(250);
            root.getChildren().add(hBox);

            for (int i = 0; i < win.toCharArray().length; i++) {
//                timer.stop();
                timeline.stop();
                char letter = win.charAt(i);

                Text text = new Text(String.valueOf(letter));
                text.setFont(Font.font(48));
                text.setOpacity(0);

                hBox.getChildren().add(text);

                FadeTransition ft = new FadeTransition(Duration.seconds(0.66), text);
                ft.setToValue(1);
                ft.setDelay(Duration.seconds(i * 0.15));
                ft.play();
            }
        }
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));

        stage.getScene().setOnKeyPressed(event -> handleKeys(event));
        stage.show();
    }

    public void handleKeys(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                if((frog.getTranslateY() - CAR_SIZE) > HEIGHT){
                    break;
                }
                frog.setTranslateY(frog.getTranslateY() - CAR_SIZE);
                break;
            case S:
                if((frog.getTranslateY() + CAR_SIZE) > HEIGHT){
                    break;
                }
                frog.setTranslateY(frog.getTranslateY() + CAR_SIZE);
                break;
            case A:
                if((frog.getTranslateX() - CAR_SIZE) > 0){
                    break;
                }
                frog.setTranslateX(frog.getTranslateX() - CAR_SIZE);
                break;
            case D:
                if((frog.getTranslateX() + CAR_SIZE) > WIDTH){
                    break;
                }
                frog.setTranslateX(frog.getTranslateX() + CAR_SIZE);
                break;
            case ESCAPE:
                System.exit(0);
                //@TODO maybe add some default switch for pressing another button
            default:
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
