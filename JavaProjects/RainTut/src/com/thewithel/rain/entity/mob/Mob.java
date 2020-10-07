package com.thewithel.rain.entity.mob;

import com.thewithel.rain.entity.Entity;
import com.thewithel.rain.graphics.Sprite;

// were using mob as a template for all our mobs that were gona creat
public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int dir = 2;
    protected boolean moving = false;

    public void move(int xa, int ya){
        //ok I admitt enums might be usefull
        if(xa>0) dir =1;        //right
        if(xa <0) dir =3;       //left
        if(ya>0) dir = 2;       //down
        if(ya<0) dir = 0;       //up

        if(!collision()){
            x += xa;
            y += ya;
        }
    }

    public void update(){

    }

    private boolean collision(){
        return false;
    }

    public void render(){

    }
}
