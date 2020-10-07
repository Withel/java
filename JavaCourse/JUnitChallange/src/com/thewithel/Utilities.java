package com.thewithel;

public class Utilities {

    //returns a char array containing every nth char.
    //When sourceArray.lenght < n returns sourceArray
    public char[] everyNthChar(char[] sourceArray, int n) {

        if(n<2){
            return sourceArray;
        }

        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }

        //divide by 0
        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];

        int index = 0;
        for (int i = n - 1; i < sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }

        return result;
    }

    // Removes pairs of the same character that are next to each other.
    // by removing on e occurened of the character.
    // "AABBCDEEF" -> "ABCDEF"
    public String removePairs(String source) {

        //if length is less than 2, there wont be any pais
        if (source == null || source.length() < 2) {
            return source;
        }

        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();

        for (int i = 0; i < (string.length) - 1; i++) {
            if (string[i] != string[i + 1]) {
                sb.append(string[i]);
            }
        }

        sb.append(string[string.length-1]);
        return sb.toString();
    }

    // perform a conversion based on some internal buisness rule
    public int converter(int a, int b) {
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddLenght(String source) {
        if (source.length() % 2 == 0) {
            return source;
        }

        return null;
    }


}
