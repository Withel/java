package com.thewithel;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


//Asercja (ang. assertion) – predykat (forma zdaniowa w danym języku, która zwraca prawdę lub fałsz),
//umieszczony w pewnym miejscu w kodzie. Asercja wskazuje, że programista zakłada,
//że predykat ów jest w danym miejscu prawdziwy.

class BankAccountTest {

    private BankAccount account;
    private static int count = 0;

    //before all is run once before every tests
    @BeforeAll
    public static void beforClass(){
        System.out.println("This executes before any test cases. Count = " + ++count);
    }

    //annotation BeforeEach runs before every test is run, thats why we commencted
    //line that creates new instance of bank account in every test
    @BeforeEach
    public void setup(){
        account = new BankAccount("Tim", "Buchalka", 1000.0, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @org.junit.jupiter.api.Test
    void deposit() throws Exception {
        //w skrocie to wykonujemy jakas funkcje, a potem w assertach sprawdzamy
        //czy wartosc jaka otrzymalismy jest wartoscia spodziewana (1200 i balance)
//        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.0, BankAccount.CHECKING);
        double balance = account.deposit(200, true);
        //trzeci parametr to delta, jezeli roznica pomiedzy 1200, a balance bedzie mniejsza,
        //tzn ze test jest zaliczony
        assertEquals(1200.0, balance, 0);
        System.out.println("deposit() TEST");
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() throws Exception {
//        fail("This test has yet to be implemented");
        double balance = account.withdraw(600, true);
        assertEquals(400.00, balance, 0);
    }

    //in junit 5 assertThrows is added so you can make it like in Tim's episode
    @org.junit.jupiter.api.Test
    void withdraw_notBranch(){
//        double balance = account.withdraw(600, false);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(600, false);
        });
        //assertEquals(400.00, balance, 0);
    }

    //dobrze zeby testy nie powtarzaly sie, wczesniej linijka assertEquals(1200.0, account.getBalance(), 0);
    //byla w tescie deposit co nie jest najlepsza praktyka
    @org.junit.jupiter.api.Test
    void getBalance_withdraw() throws Exception {
//        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.0, BankAccount.CHECKING);
        account.withdraw(200, true);
        assertEquals(800.0, account.getBalance(), 0);
        System.out.println("getBalance_withdraw() TEST");
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() throws Exception {
//        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.0, BankAccount.CHECKING);
        account.deposit(200, true);
        assertEquals(1200.0, account.getBalance(), 0);
        System.out.println("getBalance_deposit() TEST");
    }

    @org.junit.jupiter.api.Test
    void isChecking_true(){
//        BankAccount account = new BankAccount("Tim", "Buchalka", 1000.0, BankAccount.CHECKING);
//        assertEquals(true, account.isChecking());
        //we ca add parameter which will be the message if assert fails
        assertTrue(account.isChecking(), "The account is NOT a checking account");
    }

    @AfterEach
    void afterEveryTest(){
        System.out.println("This executes after every test. Count = " + ++count);
    }

    //this annotation makes the method run after every tests
    @AfterAll
    public static void afterClass(){
        System.out.println("After any test cases. Count = " + ++count);
    }



//    @org.junit.jupiter.api.Test
//    public void dummyTest() {
//        assertEquals(20, 21);
//
//    }
}