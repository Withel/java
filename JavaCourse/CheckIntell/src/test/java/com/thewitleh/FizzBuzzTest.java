package com.thewitleh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

    FizzBuzz fizzBuzz;

    @BeforeEach
    void init(){
        System.out.println("Init BeforeEach");
        fizzBuzz = new FizzBuzz();
    }

    //unit testow ie moze byc za malo ani za duzo


    //najpierw sprawdzasz czy jak przekazesz 1 to czy zwroci jeden - fail
    //piszesz funkcje ktora zawsze zwraca jeden - success
    //piszesz test ktory sprawdza czy jak podasz 2 to zwroci dwa - fail
    //przerabiasz funkcje zeby zwracala to co podasz - succ
    //piszesz test ktory sprawdza czy dla liczb podzielnych przez 3 wypisze fizz - fail
    //przerabiasz funkcje zeby dla liczb podzielnych przez 3 wypisywala fizz - succ
    //piszesz test ktory dla liczb podzielych przez 5 wypisze buzz - fail
    //przerabiasz funkcje ktora dla liczb podzielnych przez 5 wypisze buzz
    //piszesz test dla 15 - fail
    //przerabiasz funckje zeby dzialala dla liczb podzielnych przez 15

    @Test
    void checkIfReturnsFizz(){
        Assertions.assertTrue(fizzBuzz.returnResults(1).equals("1"));
        Assertions.assertTrue(fizzBuzz.returnResults(2).equals("2"));
        Assertions.assertTrue(fizzBuzz.returnResults(3).equals("Fizz"));
        Assertions.assertTrue(fizzBuzz.returnResults(4).equals("4"));
        Assertions.assertTrue(fizzBuzz.returnResults(5).equals("Buzz"));
        Assertions.assertTrue(fizzBuzz.returnResults(6).equals("Fizz"));
        Assertions.assertTrue(fizzBuzz.returnResults(9).equals("Fizz"));
        Assertions.assertTrue(fizzBuzz.returnResults(15).equals("FizzBuzz"));

        Assertions.assertTrue(fizzBuzz.returnResults(-3).equals("Fizz"));

        Assertions.assertTrue(fizzBuzz.returnResults(0).equals("FizzBuzz"));
//        Assertions.assertThrows()

//        Assertions.assert
    }
}
