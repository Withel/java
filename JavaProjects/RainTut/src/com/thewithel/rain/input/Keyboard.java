package com.thewithel.rain.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private boolean[] keys = new boolean[120];                              //array of every key, key might be pressed or realeased
    public boolean up, down, left, right;                                   //probably I could make this private and access it by getter but.. who knows xd

    public void update(){
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];

        for (int i = 0; i<keys.length; i++){
            if(keys[i]){
                System.out.println("KEY: " + i );
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {                    //e.getKeyCode returns code of a key, and its an index of an array
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
