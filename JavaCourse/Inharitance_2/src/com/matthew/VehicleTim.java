package com.matthew;

public class VehicleTim {

    private String name;
    private String size;

    int currentVelocity;
    int currentDirection;

    public VehicleTim(String name, String size){
        this.name = name;
        this.size = size;

        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void steer(int direction){
        this.currentDirection += direction;
        System.out.println("Vehicle.steer(). Vehicle Steering at "+direction);
    }

    public void move(int velocity, int direction){
        currentVelocity = velocity;
        currentDirection = direction;
        System.out.println("Vehince.move(). Moving at "+ currentVelocity+" in direction "+currentDirection);
    }

    public void showVehicle(){
        System.out.println("Name is "+this.name);
        System.out.println("Size is "+this.size);
        System.out.println("Current Velocity is "+ currentVelocity);
        System.out.println("Current Direction is" + currentDirection);
    }

    public void stop(){
        this.currentVelocity=0;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }
}
