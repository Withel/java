package com.thewithel.rain.entity.mob;

import com.thewithel.rain.graphics.Screen;
import com.thewithel.rain.graphics.Sprite;
import com.thewithel.rain.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;
    private long animate = 0;
    private boolean walking = false;

    public Player(Keyboard input){
        this.input = input;
        sprite = Sprite.playerDown;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
    }

    public void update(){
        //two variables below exists for only one purpose, they note down the direction in which player is moving
        //the only possible values of ya and xa are -1, 0, 1
        int xa=0, ya=0;
        if(input.up) ya--;
        if(input.down) ya++;
        if(input.left) xa--;
        if(input.right) xa++;

        if(xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
            if(animate< 1000000000) animate++;
            else animate = 0;
        } else {
            walking = false;
        }
    }

    //here we could flip the sprites to not use both left right

    //everytime we render the screen animate value is growing and once per every 10 renders
    //(line (animate % 20 > 10) it will draw another sprite
    public void render(Screen screen){
        sprite = Sprite.playerRight;

        if(dir == 1) {
            sprite = Sprite.playerRight;
            if(walking){
                sprite = Sprite.playerRight1;
                if(animate % 40 > 10 && animate % 40 <=20){
                    sprite = Sprite.playerRight;
                } if (animate % 40 > 30 && animate % 40 <=40) {
                    sprite = Sprite.playerRight2;
                }

            }
        }
        if(dir == 3) {
            sprite = Sprite.playerLeft;
            if(walking){
                sprite = Sprite.playerLeft1;
                if(animate % 40 > 10 && animate % 40 <=20){
                    sprite = Sprite.playerLeft;
                } if (animate % 40 > 30 && animate % 40 <=40) {
                    sprite = Sprite.playerLeft2;
                }
            }
        }
        if(dir == 0) {
            sprite = Sprite.playerUp;
            if(walking){
                sprite = Sprite.playerUp1;
                if(animate % 40 > 10 && animate % 40 <=20){
                    sprite = Sprite.playerUp;
                } if (animate % 40 > 30 && animate % 40 <=40) {
                    sprite = Sprite.playerUp2;
                }
            }
        }
        if(dir == 2) {
            sprite = Sprite.playerDown;
            if(walking){
                sprite = Sprite.playerDown1;
                if(animate % 40 > 10 && animate % 40 <20){
                    sprite = Sprite.playerDown;
                } if (animate % 40 > 30 && animate % 40 <=40) {
                    sprite = Sprite.playerDown2;
                }
            }
        }
        screen.renderPlayer(x-16, y-16, sprite);
    }
}
