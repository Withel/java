package com.thewithel;


import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {

        try{
            int result = divide();
            System.out.println(result);
//          were using there exclusive or | instead of standard or ||
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
//            e.printStackTrace();
            System.out.println("Unable to perform division, aoutpilot shutting down");
        }


        try{
            throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("catched");
        }
    }

    //try is cosidered as standard block in java -> scope
    private static int divide(){
        int x, y;
        try{
            x = getInt();
            y = getInt();
            System.out.println("x is " +x + " y is "+y);
            return x/y;
        } catch (NoSuchElementException e){
            throw new NoSuchElementException("no suitable input");
        } catch (ArithmeticException e){
            throw new ArithmeticException("attempt to divide by 0");
        }

    }

    //dont use it as a example xdd
    private static int getInt(){
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer ");
        while(true){
            try{
                return s.nextInt();
            }catch(InputMismatchException e){
                //go round again. read past the end of line in the input first
                s.nextLine();
                System.out.println("Please enter a number using onlu digits 0 to 9");
            }
        }
    }
}
