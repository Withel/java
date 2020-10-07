package com.matthew._static;

public class Main {

    public static void main(String[] args) {
//	    SomeClass one = new SomeClass("one");
//	    SomeClass two = new SomeClass("two");
//	    SomeClass three = new SomeClass("three");
//
//        System.out.println(one.getInstanceNumber());
//        System.out.println(two.getInstanceNumber());
//        System.out.println(three.getInstanceNumber());
//
//        //one.instanceNumber = 4;  ni można
//        System.out.println(Math.PI);
//
////        Math m = new Math();
//
//        int pw = 64323;
//
//        Password password = new ExtendedPassword(pw);
//        password.storePassword();
//
//        password.letMeIn(1);
//        password.letMeIn(53242);
//        password.letMeIn(23);
//        password.letMeIn(64323);

        System.out.println("Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);

        SIBTest test2 = new SIBTest();
    }
}
