package com.thewitleh;

public class FizzBuzz {

    public String returnResults(int number){
        StringBuilder sb = new StringBuilder();

        if((number%3) == 0){
            sb.append("Fizz");
        }
        if ((number%5) == 0){
            sb.append("Buzz");
        }
        if (((number%5) != 0) && ((number%3) != 0)){
            sb.append(number);
        }

        System.out.println(sb.toString());

        return sb.toString();
    }
}
