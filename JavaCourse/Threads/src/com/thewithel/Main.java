package com.thewithel;


import static com.thewithel.ThreadColor.ANSI_GREEN;
import static com.thewithel.ThreadColor.ANSI_PURPLE;
import static com.thewithel.ThreadColor.ANSI_RED;

//if youre implementing runnable interface, you only need to create one method which is run

//An interrupt is an indication to a thread that it should stop what it is doing and do something else.
//It's up to the programmer to decide exactly how a thread responds to an interrupt,
//but it is very common for the thread to terminate

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        final Thread anotherThread = new AnotherThread();
        //it enables JVM to start the run() method
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        //a way to create annonymous class
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the annonymous class thread");
            }
        }.start();


        //were created new thread based on MyRunnable class (needs to implement run();
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();
        //interupting another thread when its sleeping
        //anotherThread.interrupt();

        //Runnable is more flexible by doing this
        //another way
        Thread myRunnable2 = new Thread(new MyRunnable()) {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the annonymous class's implementation of run()");
                try {
                    //if we pas
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "Another thread terminated, or timed out so Im running again.");
                } catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I couldnt wait after all. I was interrupted");
                }
            }
        };
        myRunnable2.start();

        //you cant start same instance of the thread more than one time
//        anotherThread.start();
        //by not specifing the color it will use last which was used
        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");
    }
}
