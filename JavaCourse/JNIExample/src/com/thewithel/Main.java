package com.thewithel;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Starting JavaMain...");

        JniExample jniExample = new JniExample();
        jniExample.runExample1();
        jniExample.runExample2();
        jniExample.runExample3();
        //jniExample.runExample4();
    }

}