package com.thewithel;

import org.junit.Assert;
import org.junit.Test;

public class ParkingTest {

    @Test
    public void shouldBeBusy() {
        Parking parking = new Parking();
        parking.park(new Car());

        Assert.assertTrue(parking.isBusy());
    }

    @Test
    public void shouldBeNotBusy() {
        Parking parking = new Parking();

        Assert.assertFalse(parking.isBusy());
    }
}