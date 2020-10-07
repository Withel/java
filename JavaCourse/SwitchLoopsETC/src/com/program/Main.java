package com.program;

public class Main {

    public static void main(String[] args) {
        // while, for i ify dzialają tak samo
        int count =0;
        //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
        //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
        while(count != 5)
        {
            System.out.println(count);
            count++;
        }
        System.out.println("\n");

        int number = 5;
        int finishNumber = 20;
        int numberOfEvenNumbers=0;
        while (number <= finishNumber) {
            if(!isEvenNumber(number)) {
                number++;
                continue;
            }
            numberOfEvenNumbers++;
            System.out.println("Even number is"+number);
            if (numberOfEvenNumbers == 5) break;
            number++;
        }
        System.out.println("Number of even numbers equals: "+numberOfEvenNumbers);

    }
    public static boolean isEvenNumber(int number)
    {
        int result = number % 2;
        if (result == 1)
            return false;
        else return true;
    }
}

