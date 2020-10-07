package com.matthew.mylibrary;

public class Series {

    public static long nSum(int n){
        return (n*(n+1)/2);
    }

    public static long factorial(int n){
        if(n<2) return 1;
        else return n*factorial(n-1);
    }

    public static long fibonacci(int n){
        if (n<3) return 1;
        else return fibonacci(n-2)+fibonacci(n-1);
    }

}
