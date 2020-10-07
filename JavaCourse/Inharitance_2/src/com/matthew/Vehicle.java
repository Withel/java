package com.matthew;

public class Vehicle {
    private String name;
    private int size;
    private int weight;
    private int speed;

    public Vehicle(String name, int size, int weight, int speed) {
        this.name = name;
        this.size = size;
        this.weight = weight;
        this.speed = speed;
    }

    public void move(int speed){
        System.out.println("Vehicle.move() called. Moving at speed" + speed);
    }
}
