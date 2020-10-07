package com.thewithel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
//I DONT KNOW WHY I WAS TRYING MAKING LIBS HERE... BUT LETS LEAVE IT
import com.thewithel.ExampleLib;

import static com.thewithel.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        System.out.println(ExampleLib.return2());

        //ArrayBlockingQueue is thread safe, but we might still need a synchronisation
//        List<String> buffer = new ArrayList<String>();
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);
        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_BLUE);

        //it runs similar to .start() methods but application doesnt stop
        //we need to shut down service
        //using executorService for this app is overkill but it might be good
        //for apps that use multiple threads
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        //Callable doesnt run while producer is sleeping
        //we passed '3' to the executorService so only three threads can work at the time
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_WHITE + "I'm being printed for the Callable class");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();

//        new Thread(producer).start();
//        new Thread(consumer1).start();
//        new Thread(consumer2).start();
    }
}

//synchronisation can be done with "synchronised keyword"
//you need to synchronise adding to buffer by buffer variable
//and in consumer you need to synchronise whole while loop

//updated with try finally blocks -> it ensures that method
//.lock() will be executed everytime
class MyProducer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    //    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public MyProducer(ArrayBlockingQueue<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);
//                bufferLock.lock();
//                try {
//                    buffer.add(num);
//                } finally {
//                    bufferLock.unlock();
//                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
//        bufferLock.lock();
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {

        }
//        } finally {
//            bufferLock.unlock();
//        }
    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {

//        int counter = 0;
        while (true) {
            synchronized (buffer) {


                //there is no advantage here to use the tryLock() method
                //but for demonstration its there
//            if(bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
//                    bufferLock.unlock();
                        continue;
                    }
//                    System.out.println(color + "The counter = " + counter);
//                    counter = 0;
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
//                    bufferLock.unlock();
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
//                finally {
//                    bufferLock.unlock();
//                }
//            } else {
//                counter++;
//            }
            }
        }
    }
}































