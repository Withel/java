package com.thewithel;

public class Main {

    public enum Test{

    }

    public enum Planet {
        MERCURY(3.303e+23, 2.4397e6),
        VENUS(4.869e+24, 6.0518e6),
        EARTH(5.976e+24, 6.37814e6),
        MARS(6.421e+23, 3.3972e6),
        JUPITER(1.9e+27, 7.1492e7),
        SATURN(5.688e+26, 6.0268e7),
        URANUS(8.686e+25, 2.5559e7),
        NEPTUNE(1.024e+26, 2.4746e7);

        private final double mass;   // in kilograms
        private final double radius; // in meters

        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
        }
    }

    public enum Numbers {
        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5);

        private final int value;

        Numbers(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        System.out.println(Planet.MARS.mass);
        System.out.println(Planet.MARS);
        System.out.println(Numbers.ONE);
    }
}
