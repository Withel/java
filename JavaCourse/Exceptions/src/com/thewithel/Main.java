package com.thewithel;


import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//	    int x = 98;
//	    int y = 0;
//
//        System.out.println(divideBYL(x, y));
//        System.out.println(diviteEAFP(x, y));
//        System.out.println(divide(x, y));

        //just fast reminder of map's funcion names
        Map<Integer, String> justMap = new HashMap<Integer, String>();

        justMap.put(0, "zero");

        if(justMap.containsKey(0)){
            System.out.println(justMap.get(0));
        }

//        throw new NullPointerException();

        int x = getIntEAFP();
        System.out.println("x is: " + x);

    }

    private static int getInt(){
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private static int getIntBYL(){
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter the integer");
        String input = s.next();
        for(int i=0; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                isValid=false;
                break;
            }
        }
        if(isValid){
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the integer");
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                return getIntEAFP();
            }
        }

    private static int divideBYL(int x, int y){
        if(y != 0){
            return x / 0;
        } else {
            return 0;
        }
    }

    private static int diviteEAFP(int x, int y){
        try{
            return x / y;
        } catch (ArithmeticException e){
            return 0;
        }
    }

    private static int divide(int x, int y){
        return x /y ;
    }
}
