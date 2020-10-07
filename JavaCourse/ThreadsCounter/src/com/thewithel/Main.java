package com.thewithel;

public class Main {

    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        Countdown countdown1 = new Countdown();
        Countdown countdown2 = new Countdown();

        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        t1.start();
        t2.start();

    }
}

class Countdown {

    private int i;

    public void doCountdown() {
        String color;

        switch(Thread.currentThread().getName()){
            case "Thread 1":
                color = ThreadColor.ANSI_GREEN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_BLUE;
                break;
            default:
                color = ThreadColor.ANSI_CYAN;
        }

        synchronized (this){
            for(i=10;i >0; i--){
                System.out.println(color + Thread.currentThread().getName() + ": i =" + i);
                try{
                    Thread.currentThread().sleep(10);
                } catch(InterruptedException e){
                    e.getMessage();
                    e.printStackTrace();
                }
            }
        }
    }
}

class CountdownThread extends Thread{
    private Countdown threadContdown;

    public CountdownThread(Countdown countdown){
        threadContdown = countdown;
    }

    public void run(){
        threadContdown.doCountdown();

    }
}
