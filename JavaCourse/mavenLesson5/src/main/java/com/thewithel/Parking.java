package com.thewithel;

public class Parking  {
    Car parkedCar;

    public void park(Car car){
        if(parkedCar != null){
            throw new IllegalStateException("Parking is busy");
        }

        parkedCar = car;
    }

    public boolean isBusy() { return parkedCar != null; }

    public Car unpark() {
        Car car = parkedCar;
        parkedCar =null;
        return car;
    }
}
