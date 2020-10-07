package com.matthew;

public class Animal {
    //NAJBARDZIEJ BAZOWA KLASA ZWIERZĘCIA, MA WSZYSTKIE FIELDSY TAKIE JAKIE MA KAŻDE ZWIERZE
    private String name;
    private int brain;
    private int body;
    private int size;
    private int weight;

    public Animal(String name, int brain, int body, int size, int weight) {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
    }

    public void eat(){
        System.out.println("Animal.eat() has been called.");
    }

    public void move(int speed){
        System.out.println("Animal.move() has been called. Animal is moving at "+speed);
        //TU TEŻ COŚ MOŻE BĘDZIE
    }

    public String getName() {
        return name;
    }

    public int getBrain() {
        return brain;
    }

    public int getBody() {
        return body;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }
}
