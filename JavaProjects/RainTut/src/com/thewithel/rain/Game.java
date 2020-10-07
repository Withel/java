package com.thewithel.rain;

import com.thewithel.rain.entity.mob.Player;
import com.thewithel.rain.graphics.Screen;
import com.thewithel.rain.input.Keyboard;
import com.thewithel.rain.level.Level;
import com.thewithel.rain.level.RandomLevel;
import com.thewithel.rain.level.SpawnLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


public class Game extends Canvas implements Runnable{

    public static int width = 300;
    public static int height = width * 9 / 16; //its 168.5
    public static int scale = 3;
    public static String title = "Rain";

    private Thread thread;
    private JFrame frame;
    private Keyboard key;
    private Level level;
    private Player player;
    private boolean running = false;

    private Screen screen;

    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);         // were converting image obj into arrays of ints
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();                // its gonna contact image, get array of pixels
                                                                                                        // make up the image, and its gonna get data buffer that handles
                                                                                                        // the raster



    public Game(){                                                                                      //in game method youre creatin every important veriable
        Dimension size = new Dimension(width*scale, height*scale);
        setPreferredSize(size);
        System.out.println();
        screen = new Screen(width, height);
        frame = new JFrame();
        key = new Keyboard();
        level = new SpawnLevel("/textures/levels/level.png");
        player = new Player(8*16,8*16,key);

        addKeyListener(key);                    //it makes our keyboard "working" -> gets input form keyboard
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop(){
        try{                                    //trying line of code below, if it fails the catch is executed
        thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }





    @Override   //from runnable interface
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;              //60 fps
        double delta = 0;                                   //generally these all variables are for handling math stuff
        //long now;                                           //for fps counter and update counter
        int frames = 0;
        int updates = 0;
        requestFocus();                         //component that allows us to, when game starts, were in that window -> its focused
 //       int check = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now-lastTime) / ns;
            lastTime = now;

            while(delta >= 1){
                update();
                updates++;
                delta--;

//                check++;
//                if(check == 59) check =0;
//                System.out.println(check);
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){              //analize times!!! pokurwione lekko xD
                timer += 1000;                                          //this will happen once per second
                System.out.println(updates+" ups, "+frames+" fps");
                frame.setTitle(title + "  |  " +updates+" ups, "+frames+" fps");
                updates = 0;
                frames = 0;
            }
        }
    }


    // variables that are made for controlling the screen movement


    public void update(){
        key.update();
        player.update();

    }



    public void render(){
        BufferStrategy bs = getBufferStrategy();                        //creates buffer, that were using to store rendered image
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        screen.clear();                                                 //It clears screen and then render what we want
        //we moved the map not the player so player is in the middle
        int xScroll = (player.x - screen.width/2);
        int yScroll = (player.y - screen.height/2);
        level.render(xScroll, yScroll, screen);
        player.render(screen);

        for(int i = 0; i<pixels.length; i++){                           //copying
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
//        g.setColor(Color.BLACK);                                        // new Color(RGB values in constructor);
//        g.fillRect(0, 0, getWidth(), getHeight());                      //getWidth() i getHeight() is metod from Component class 0, 0 is top left
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        g.dispose();
        bs.show();                                                      //it will show the buffer
    }






    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);                                 //cannot change resolution, also makes unmaximisable
//        game.frame.setTitle("Rain");                                    //name of the window
        game.frame.add(game);                                           //adding instance of "game" to frame object
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //closing the program by clickin on X (right top corner)
        game.frame.setLocationRelativeTo(null);                         //window is starting in the center of the screen
        game.frame.setVisible(true);                                    //showing window

        game.start();

    }

}






















