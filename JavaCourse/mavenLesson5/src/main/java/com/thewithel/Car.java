package com.thewithel;

public class Car {

    boolean started = true;

    public void startEngine() { started = true; }
    public void stopEngine() { started = false; }

    public boolean isStarted(){ return started; }
}
