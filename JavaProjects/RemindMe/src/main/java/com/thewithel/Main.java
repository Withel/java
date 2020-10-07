package com.thewithel;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dobry");

        SomeClass mareczek = new SomeClass(1,2, "Mareczek");

        System.out.println(mareczek.toString());

        AbstractClass something = new Inherit("asd", 1);

        AbstractClass something2 = new AbstractClass("asd") {};

        AnotherClass something3 = new AnotherClass() {
            @Override
            public void count() {
                System.out.println("Counting faster");
            }
        };

        Newer newer = new Newer() {
            @Override
            public void method1() {
                System.out.println("I do something");
            }
        };

        Newer newer2 = () -> System.out.println("I do more");




        something3.count();
    }
}
