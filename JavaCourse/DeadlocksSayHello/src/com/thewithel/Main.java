package com.thewithel;


public class Main {

    public static void main(String[] args) {
        final PolitePerston jane = new PolitePerston("Jane");
        final PolitePerston john = new PolitePerston("John");

        new Thread(new Runnable() {
            @Override
            public void run() {
                jane.sayHello(john);
            }
        }).start();


        new Thread(() -> john.sayHello(jane)).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                john.sayHello(jane);
//            }
//        }).start();

    }

    static class PolitePerston {
        private final String name;

        public PolitePerston(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerston person) {
            //works like print from C
            System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerston person) {
            System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
        }
    }
}
