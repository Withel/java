package com.matthew;

import java.util.Scanner;


//ZIELONE W KONSOLI OZNACZA WPISANE
public class Main {

    //SCANNER JEST OBIEKTEM KLASY SCANNER
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int[] myIntegers = getIntegers(5);
        for (int i=0; i<myIntegers.length; i++){
            System.out.println("Element "+ i +" typed value was "+ myIntegers[i]);
        }

        System.out.println("The average is " + getAvarage(myIntegers));

    }

    //FUNKCJA KTÓRA ZWRACA TABLICE INTÓW (O WIELKOŚCI NUMBER) CHYBA
    public static int[] getIntegers(int number){
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        //.nextInt() jest metodą klasy scanner pozwalającą pobrac z konsoli int
        for (int i=0; i<values.length; i++){
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static double getAvarage(int[] array){
        int sum=0;
        for (int i=0;i<array.length; i++) sum+= array[i];
        return (double)sum/(double)array.length;
    }



//        //TWORZENIE TABLIC W JAVIE WG TEGO WZORU
//
//
//        double[] myDoubleArray = new double[10];
//	    int[] myIntArray = {1,2,3,4,5,6,7,8,9,10};
//
//        int[] secondIntArray = new int[25];
//
//        //arrayname.lengt to w field w klasie tablicy które przechowuje długośc tablicy
//
//
//        for(int i = 0; i<secondIntArray.length;i++) secondIntArray[i] = (int)(Math.random()*10+1);
//
//	    myIntArray[5] = 60;
//	    //NIE MA WSKAŹNIKÓW XDDDDDDDDDD
//
//        printArray(secondIntArray);

//    public static void printArray(int[] array){
//        for (int i=0; i<array.length; i++){
//            System.out.println("random value of element "
//                    + i +" = " +array[i]);
//        }
//    }
}
