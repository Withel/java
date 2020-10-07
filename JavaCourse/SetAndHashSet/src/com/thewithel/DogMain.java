package com.thewithel;

public class DogMain {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        //if we have equals method in both class the output will be true then false, because
        //Labrador is an instance of Dog, not oposite. Solution, remove override method from labrador
        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));
    }
}
