package com.thewithel;

import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void startEngine() {
        Car car = new Car();
        car.startEngine();

        assertTrue(car.isStarted());
    }

    @Test
    public void shouldStopEngine() {
        Car car = new Car();

        car.startEngine();
        car.stopEngine();

        assertFalse(car.isStarted());
    }
}