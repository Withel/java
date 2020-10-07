package com.matthew;

public class Main {

    public static void main(String[] args) {
	    Account timsAccount = new Account("Tim");
	    timsAccount.deposit(1000);
	    timsAccount.withraw(500);
	    timsAccount.withraw(-200);
	    timsAccount.deposit(-20);
	    timsAccount.calculateBalance();

	    //timsAccount.balance = 5000;

        System.out.println("balance on accout is " + timsAccount.getBalance());

        //timsAccount.transaction.add(4500);
        timsAccount.calculateBalance();
    }
}
