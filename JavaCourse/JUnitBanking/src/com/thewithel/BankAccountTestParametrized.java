package com.thewithel;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.*;
import org.junit.jupiter.params.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankAccountTestParametrized {

    private BankAccount account;

    @BeforeEach
    public void setup(){
        account = new BankAccount("user", "asd", 1000.0, BankAccount.CHECKING);
        System.out.println("Running a test");
    }

    @ParameterizedTest
    @MethodSource("createWordsWithLength")
    void withMethodSource(double amount, boolean isChecking, double expected) {
        System.out.println("withMethodSource");
        account.deposit(amount, isChecking);
        assertEquals(expected, account.getBalance(), .01);
    }

    public static Stream<Arguments> createWordsWithLength() {
        return Stream.of(Arguments.of(100.00, true, 1100.00), Arguments.of(200.00, true, 1200.00),
                Arguments.of(143.14, true, 1143.14), Arguments.of(1000.00, true, 2000.00));
    }
}
