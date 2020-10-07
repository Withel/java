package com.thewithel;

import static com.thewithel.ThreadColor.*;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from MyRunnable's Thread.");
    }
}
