package com.thewithel;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    Utilities utilities;

    @BeforeEach
    void initAll(){
        utilities = new Utilities();
    }

    @org.junit.jupiter.api.Test
    void everyNthChar() {
//        Utilities utilities = new Utilities();
        char[] output = utilities.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[] {'e', 'l'}, output);
        //wtf, why 0 but nvm
        assertArrayEquals("hello".toCharArray(), utilities.everyNthChar("hello".toCharArray(), 0));
        char[] output2 = utilities.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 300);
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
//        Utilities utilities = new Utilities();
        assertEquals("ABCDEF", utilities.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", utilities.removePairs("ABCCABDEEF"));
        assertNull(utilities.removePairs(null), "Did not get null reurned when passed null");
        assertEquals("A", utilities.removePairs("A"));
        assertEquals("", utilities.removePairs(""));
    }

    @ParameterizedTest
    @MethodSource("mySources")
    void withMethodSource(String expected, String given){
        assertEquals(expected, utilities.removePairs(given));
    }

    public static Stream<Arguments> mySources(){
        return Stream.of(Arguments.of("ABCDEF", "ABCDEFF"), Arguments.of("AB8EFG", "AB88EFFG"),
                Arguments.of("123456", "112233445566"), Arguments.of("ZYZQB", "ZYZQQB"), Arguments.of("A", "A"));
    }


    @org.junit.jupiter.api.Test
    void converter() {
//        Utilities utilities = new Utilities();
        assertEquals(300, utilities.converter(10, 5));
        Assertions.assertThrows(ArithmeticException.class, () -> {
            utilities.converter(10, 0);
        });
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLenght() {
//        Utilities utilities = new Utilities();
        assertNull(utilities.nullIfOddLenght("odd"));
        assertNotNull(utilities.nullIfOddLenght("even"));
    }
}