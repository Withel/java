package com.matthew;

public class Car extends Vehicle {

    private String engineName;
    private int wheels;
    private int seats;
    private int doors;
    private int gears;

    public Car(String name, int size, int weight, int speed, String engineName, int wheels, int seats, int doors, int gears) {
        super(name, size, weight, speed);
        this.engineName = engineName;
        this.wheels = wheels;
        this.seats = seats;
        this.doors = doors;
        this.gears = gears;
    }

    public void turning(boolean direction){
        System.out.println("Car.turning called. Im turning"+direction);
    }

    public void changingSpeed(int speed, int gear){
        changeGears(gear);
        super.move(speed);
    }

    public void changeGears(int gear){
        this.gears += gear;
        System.out.println("Car.changeGears called");
    }
}
