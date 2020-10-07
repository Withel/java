package com.matthew;

public class RacingCar extends Car {

    private String brand;
    int maxSpeed;

    public RacingCar(String name, int size, int weight, int speed, String engineName, int wheels, int seats, int doors,
                     int gears, String brand, int maxSpeed){
        super(name, size, weight, speed, engineName, wheels, seats, doors, gears);
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public void fastBreaking(int speed){
        super.changingSpeed(speed, 0);
    }

    public void drifting(){
        System.out.println("RacingCar.drifting() called.");
    }
}
