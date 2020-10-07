package com.matthew;

public class EnhancedPlayer {

    private String name;
    //zaznaczyć nazwę zmiennej, Rclick -> Refactor -> rename a potem humbla bumbla
    private int hitPoints = 100;
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon){
        this.name = name;
        if (health > 0 && health <=100)
            this.hitPoints = health;
        this.weapon = weapon;
    }

    public EnhancedPlayer(){
        this("Default", 100, "nothing");
    }

    public void loseHealth(int damage){
        this.hitPoints = this.hitPoints - damage;
        if(this.hitPoints <= 0) {
            System.out.println("Player knocked out");
            //reduce remaining lives
        }
    }

    public void showPlayer(){
        System.out.println("Player name is: "+this.name);
        System.out.println("Actual hitPoints = "+this.hitPoints);
        System.out.println("Player's weapon is: "+weapon);
    }

    public int getHealth() {
        return hitPoints;
    }
}
