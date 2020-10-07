package com.matthew;

public class CarTim extends VehicleTim{

    private int wheels;
    private int doors;
    private int gears;
    private boolean isManual;

    private int currentGear;


    public CarTim(String name, String size, int wheels, int doors, int gears, boolean isManual) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("setCurrentGear(); Current gear changed to: "+this.currentGear);
    }

    public void changeVelocity(int speed, int direction){
        System.out.println("Car.changeVelocity(); Velocity is: "+speed+" direction is: "+direction);
        move(speed, direction);
    }

    public void showCar(){
        super.showVehicle();
        System.out.println("Number of wheels "+this.wheels);
        System.out.println("Number of doors "+this.doors);
        System.out.println("Number of gears is "+ this.gears);
        System.out.println("Gearbox is manual " + this.isManual);
        System.out.println("Current gear is: "+currentGear);
    }


}
