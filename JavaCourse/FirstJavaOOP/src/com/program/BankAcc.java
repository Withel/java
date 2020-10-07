package com.program;

public class BankAcc {
    private int accountNumber;
    private double balance = 0;
    private String customerName;
    private String email;
    private int phoneNumber;

    public BankAcc(){
        //specjalne uzycie "this", teraz wywołuje inny konstruktor w definicji konsturktora
        //musi to byc pierwsza linijka która jest wykonywana w tym konstruktorze
        this(12345, 12345, "default name", "default string", 12345);
        System.out.println("Empty constructor");
    }


    public BankAcc(int accountNumber, double balance, String customerName, String email,
                   int phoneNumber){
        System.out.println("Account Constructor with parameters called! Yay <3.");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    /* MOZNA TEZ TAK
    public BankAcc(int accountNumber, double balance, String customerName, String email,
                   int phoneNumber){
        System.out.println("Account Constructor with parameters called! Yay <3.");
        setNumber(number); ETC...
    }*/

    //INTELLIJ AUTOMATYCZNIE MOŻE TWORZYĆ KONSTURKTORY CODE->GENERATE->CONSTRUCTORS

    public BankAcc(String customerName, String email, int phoneNumber) {
        this(999999, 3, customerName, email, phoneNumber);
    }


    //MOŻNA TWORZYĆ GETTERS AND SETTERS AUTOMATYCZNIE
    //CODE -> GENERATE -> SETTERS/GETTERS/BOTH

    //setters
    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    //getters
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public double getBalance() {
        return this.balance;
    }
    public String getCustomerName(){
        return this.customerName;
    }
    public String getEmail(){
        return this.email;
    }
    public int getPhoneNumber(){
        return this.phoneNumber;
    }


    public void showCustomer(){
        System.out.println("The Customer is:" + customerName);
        System.out.println("Balance is:" +balance);
        System.out.println("His account number is: "+accountNumber);
        System.out.println("His Email is: "+email);
        System.out.println("His Phone number is: "+phoneNumber);
    }

    public void incrementBalance(double money){
        System.out.println("Your balance before increasing is:" + balance);
        balance += money;
        System.out.println("Your balance after increasing is:" + balance);
    }

    public void decrementBalance(double money){
        if (money > this.balance){
            System.out.println("You don't have enought money on the accout. Your Balance is:" + balance);
            return;
        }
        else {
            System.out.println("Your balance before decreasig is:" + balance);
            this.balance -= money;
            System.out.println("Your balance after decreasig is:" + balance);
        }
    }
}
