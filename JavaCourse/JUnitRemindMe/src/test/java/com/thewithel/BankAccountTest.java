package com.thewithel;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count = 0;

    //before all must be static
    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("Running before all tests.");
    }

    @BeforeEach
    public void init(){
        account = new BankAccount("FirstName", "SecondName", 100, BankAccount.CHECKING);
        count++;
    }

//    @Test
//    void alwaysFails(){
//        fail();
//    }

    @Test
    @Tag("TestMe")
    void checkIfDepositWorks(){
        double balance = account.deposit(100, true);
        assertEquals(200, balance);
    }
    @Tag("TestMe")
    @Test

    void checkIfWithrawWorks(){
        double balance = account.withdraw(50, true);
        assertEquals(50, balance);
    }

    @Test
    void checkIfGetBalanceWorks(){
        assertEquals(100, account.getBalance());
    }

    @Test
    void isCheckingTrue(){
        //In assertions we can add message that will be displayed when assertion fails
        assertTrue(account.isChecking(), "The account is Not a checking account");
    }

    @Test
    void doesItThrows(){
        //from JUnit 5 throws are using lambdas, basically something like this
        assertThrows(NullPointerException.class, () -> account.exceptionThrower());
    }

    @Test
    @Tag("DontTest")
    public void shouldFailBecauseTimeout() throws InterruptedException {
        //checking duration
        Assertions.assertTimeout(Duration.ofMillis(10), () -> Thread.sleep(10));
    }

    @Test
    @Tag("development")
    void checkAnnotationWorking(){
        System.out.println("development annotation");
        assertTrue(true);
    }

    @Test
    @Tag("production")
    void checkAnnotationWorkingV2(){
        System.out.println("production annotation");
        assertTrue(true);
    }

    @ParameterizedTest
    @MethodSource("resourceProvider")
    void withMethodSource(double amount, boolean isChecking, double expected){
        System.out.println("Method with resources");
        account.deposit(amount, isChecking);
        //last argument is delta which defines how much values can be different
        assertEquals(expected, account.getBalance(), 0.1);
    }

    public static Stream<Arguments> resourceProvider(){
        return Stream.of(Arguments.of(100.00, true, 200.00), Arguments.of(200.00, true, 300.00),
                Arguments.of(143.14, true, 243.14), Arguments.of(1000.00, true, 1100.00));
    }


    @AfterEach
    void afterEveryTest(){
        count++;
    }

    @AfterAll
    static void afterAllTest(){
        System.out.println("Count = " + count);
    }

}
