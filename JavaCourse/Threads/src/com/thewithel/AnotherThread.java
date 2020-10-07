package com.thewithel;

import static com.thewithel.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {

    //metode run trzeba nadpisac
    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());
        try{
          Thread.sleep(5000);
        }  catch (InterruptedException e){
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            return;
        }

        System.out.println(ANSI_BLUE + "Three seconds have poaseed and I'm awake");
    }
}
