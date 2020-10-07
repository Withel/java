package com.thewithel;

public class Main {

    public static void main(String[] args) {
        final BankAccount account = new BankAccount("12345-678", 1000);

        Thread thThread1 = new Thread(){
            @Override
            public void run(){
                account.deopsit(300.00);
                account.withdraw(50);
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deopsit(203.75);
                account.withdraw(100);
            }
        }).start();

        new Thread(() -> System.out.println("dupa")).start();

        thThread1.start();

        System.out.println("Balance is = " + account.getBalance());
    }


}
