package com.thewithel;

public class Main {

    public static void main(String[] args) {

        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(alphanumeric);
        //matches every character
        System.out.println(alphanumeric.replaceAll(".", "Y"));

        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        String secondString ="abcDeeeF12GhhabcDeeeiiiijkl99z";
        System.out.println(secondString);
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));


        //whole string has to match to return true
        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("^abcDeeeF12Ghhiiiijkl99z"));

        //end of the string
        System.out.println(alphanumeric.replaceAll("jkl99z$", "THE END"));

        //its looking for a each individual letter in []
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));

        //were onyl going to do the replacement if any of letter a,e,i is followed by F or j
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        System.out.println("Harry".replaceAll("[Hh]arry", "Harry"));
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));

        //we can turn off case sensitivity
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));

        //replacing any digit in string
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
        //replacing all non-digit
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));
        System.out.println("====================================");

        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);
        //removing all whitespaces and also new lines and tabs
        System.out.println(hasWhitespace.replaceAll("\\s", ""));
        System.out.println(hasWhitespace.replaceAll("\t", "X"));
        System.out.println(hasWhitespace.replaceAll("\\S", ""));

        System.out.println("====================================");
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        System.out.println(hasWhitespace.replaceAll("\\w", "X"));
        System.out.println(hasWhitespace.replaceAll("\\b", "X"));

        //QUANTIFIERS AND THE PATTERN AND MATCHER CLASSES
        String thirdAlphanumeric = "abcDF12Ghhiiiijkl99z";
        System.out.println("====================================");
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe{3}", "YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe+", "YYY"));
        //just test
        System.out.println("++++++++".replaceAll("\\+", "-"));
        //difference between + and * with thirdalphanumeric removed the "eee" after "abcD"
        System.out.println(thirdAlphanumeric.replaceAll("^abcDe+", "YYY"));
        System.out.println(thirdAlphanumeric.replaceAll("abcDe*", "YYY"));

        String thirdAlphanumericV2 = "abcDeF12Ghhiiiijkl99z";
        //doesnt work because after "abcD" is only one e
        System.out.println(thirdAlphanumericV2.replaceAll("^abcDe{2,5}", "YYY"));

        thirdAlphanumericV2= "abcDeeeF12Ghhiiiijkl99z";
        //replacing all occurances of "h" followed by any numbers of "i" followed by at least one "j"
        //and were gonna replace all that with "Y"
        System.out.println(thirdAlphanumericV2.replaceAll("h+i*j", "Y"));







    }
}
