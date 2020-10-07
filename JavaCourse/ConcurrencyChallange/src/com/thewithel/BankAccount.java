package com.thewithel;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private String accounteNumber;

    Lock lock;

    public BankAccount(String accounteNumber, double balance) {
        this.balance = balance;
        this.accounteNumber = accounteNumber;
        lock = new ReentrantLock();
    }

//    two ways of synchronising that method, and theyre equivalent for this code
//    public synchronized void deopsit(double amount){
//        balance += amount;
//    }
//
//    public void withdraw(double amount) {
//        synchronized (this) {
//            balance -= amount;
//        }
//    }

//    with lock object
//    public void deopsit(double amount) {
//        lock.lock();
//        try {
//            balance += amount;
//        } finally {
//            lock.unlock();
//        }
//    }
//    public void withdraw(double amount) {
//        lock.lock();
//        try {
//            balance -= amount;
//        } finally {
//            lock.unlock();
//        }
//    }

    //    using tryLock()
    public void deopsit(double amount) {

        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
        }

        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount) {

        boolean status = false;
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Couldnt get the lock");
            }
        } catch (InterruptedException e) {
        }

        System.out.println("Transaction status = " + status);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccounteNumber() {
        return accounteNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + accounteNumber);
    }
}
