package com.thewithel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        //1. Write the string literal regular expression that will match the following String.
        //Use the Sting.matches() method to verify your anwser

        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));

        System.out.println("========================");
        //2. Write a regular expression that will match "I want a bike." and
        //"I want a ball.". Verify your answer using the matches() method.

        String challenge2_1 = "I want a bike.";
        String challenge2_2 = "I want a ball.";

        System.out.println(challenge2_1.matches("^I want a .*"));
        System.out.println(challenge2_2.matches("^I want a .*"));

        //tim's
        String regExp = "I want a \\w+.";
        System.out.println(challenge2_1.matches(regExp));
        System.out.println(challenge2_2.matches(regExp));

        //with groups and logical operator OR
        String regExp2 = "I want a (bike|ball).";
        System.out.println(challenge2_1.matches(regExp2));
        System.out.println(challenge2_2.matches(regExp2));

        System.out.println("========================");
        //3. Use the Matcher.matches() method to check for matches, instead of String.matcher(),
        //for the regullar expression that uses \w+.

        String regExp3 = "I want a \\w+.";

        Pattern pattern1 = Pattern.compile(regExp3);
        Matcher matcherChal3_1 = pattern1.matcher(challenge2_1);
        Matcher matcherChal3_2 = pattern1.matcher(challenge2_2);

        System.out.println(matcherChal3_1.matches());
        System.out.println(matcherChal3_2.matches());

        System.out.println("========================");
        //4. Replace all occurances of blank with an underscore for the following string.
        //Print out the resulting string.

        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll(" ", "_"));
        System.out.println(challenge4.replaceAll("\\s", "_"));

        System.out.println("========================");
        //5. Write the reuglar expression that will match the followin string
        //in it's entirety. Use the String.matches() method to verify your answer.

        String challenge5 = "aaabccccccccdddefffg";
        String regExpCh5_1 = "[abcdefg]+";
        String regExpCh5_2 = "[a-g]+";
        System.out.println(challenge5.matches(regExpCh5_1));
        System.out.println(challenge5.matches(regExpCh5_2));
        System.out.println(challenge5.matches("a{3}bc{8}d{3}ef{3}g"));

        System.out.println("========================");
        //6. Write a regular expression that will only match the challenge 5 string
        //in its entirety.
        String challenge6 = "aaabccccccccdddefffg";

        System.out.println(challenge6.matches("^a{3}bc{8}d{3}ef{3}g$"));
        System.out.println(challenge6.replaceAll("^a{3}bc{8}d{3}ef{3}g$", "REPLACED"));

        System.out.println("========================");
        //7. Write a regular expression that will match a string that starts with a serioes of letters.
        //The letters must be followed by a period. After the period, there must be a series of digits.
        String challenge7 = "abcd.123";
        String challenge7_2 = "kjisl.22";

        String regExpCh7 = "\\D+.\\d+";
        System.out.println(challenge7.matches(regExpCh7));
        System.out.println(challenge7_2.matches(regExpCh7));

        System.out.println(challenge7.matches("^[A-z]+\\.\\d+$"));

        System.out.println("========================");

        //8. Modify the regular expression in challenge 7 to use a group,
        //so that we can print all the digits that occur in a string that contains multiple
        //occurances of the pattern. Write all the code required to accomplish this
        //(create a pattern and matcher, etc). Use the following string to test your code:

        String challenge8 = "abcd.135uvqz.7tzik.999";
        String digitPatternString = "(\\d+)";
        Pattern digitPattern = Pattern.compile(digitPatternString);
        Matcher matcherChal8 = digitPattern.matcher(challenge8);

        while (matcherChal8.find()) {
            System.out.println("Occurance = " + matcherChal8.group(1));
        }

        Pattern pattern8 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);
        while (matcher8.find()) {
            System.out.println("Occurance = " + matcher8.group(1));
        }

        System.out.println("========================");
        //9. Let's supose we're reading string that match the patterns we
        //used in challenges 7 and 8 from a file. Tabs are used to separate the matches,
        //with one exception. The last match is followed by a newline. Our revised
        //challange8 string would look like this:

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";

        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher9 = pattern9.matcher(challenge9);

        while (matcher9.find()) {
            System.out.println("Occurance = " + matcher9.group(1));
        }

        System.out.println("========================");
        //10. Instead of printing out the numbers themselves, print out their
        //start and end indices. Use the same string we used for challenge 9.
        //Make those indicaes inclusive. For example, the start index printed for 135
        //should be 5, and the end index should be 7.

        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";

        Pattern pattern10 = Pattern.compile("(\\d+)");
        Matcher matcher10 = pattern10.matcher(challenge10);

        while (matcher10.find()) {
            System.out.println("Occurance: from " + matcher10.start() + " to: " + (matcher10.end() - 1));
        }

        //Tim's
        String challenge10_2 = "abcd.135\tuvqz.7\ttzik.999\n";

        Pattern pattern10_2 = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        Matcher matcher10_2 = pattern10_2.matcher(challenge10_2);

        while (matcher10_2.find()) {
            System.out.println("Occurance = " + matcher10_2.start(1) + " end = " + (matcher10_2.end(1) - 1));
        }

        System.out.println("========================");
        //11. Supose we have the following string containing points on a graphw
        //within curly braces. Extract what's in the curly braces.

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}, {x, y}, {6, 44}, {11, 12}";

        //Not exactly regural expression :) but still there is one in split() method. Does it count? :D
        String[] splitted = challenge11.split("\\}, \\{");
        int counter = 0;
        for(String s : splitted){
            if(counter == 0){
                char[] temp1 = s.toCharArray();
                for(int i=1; i<temp1.length; i++){
                    System.out.print(temp1[i]);
                }
                System.out.println();
                counter++;
                continue;
            }
            if(counter == (splitted.length -1)){
                char[] temp2 = s.toCharArray();
                for(int i=0; i<temp2.length-1; i++){
                    System.out.print(temp2[i]);
                }
                System.out.println();
                counter++;
                continue;
            }

            counter++;
            System.out.println(s);
        }
        System.out.println("======================");

        Pattern pattern11 = Pattern.compile("\\{(.*?)\\}");
        Matcher matcher11 = pattern11.matcher(challenge11);

        while(matcher11.find()){
            System.out.println(matcher11.group(1));
        }

        Pattern pattern11_2 = Pattern.compile("\\{(\\d+, \\d+)\\}");
        Matcher matcher11_2 = pattern11_2.matcher(challenge11);

        while(matcher11_2.find()){
            System.out.println(matcher11_2.group(1));
        }

        //we need ? to sepcify that its lazy quantifier because if we wont use it
        //it will grab everything between first and the last {}
        //Tim's solution is exactly the same expect he's using + I'm using *

        System.out.println("========================");
        //12. Write a regular expression that will match a 5-digit US zip code.
        //Use "11111" as your test string

        String challenge12 = "11111";

        Pattern pattern12 = Pattern.compile("^\\d{5}$");
        Matcher matcher12 = pattern12.matcher(challenge12);

        System.out.println(matcher12.matches());

        System.out.println("========================");
        //13. US zip codes can be followed by a dash and another four numbers.
        //Write a regular expression that will match those zip code.
        //Use "11111-1111" as your test string.

        String challenge13 = "11111-1111";

        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));

        System.out.println("========================");
        //14. Write a regular expression that will match 5-digit USzip codes,
        //and zip codes that contain the optional 4 digits preceded by a dash.

        System.out.println(challenge12.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge13.matches("^\\d{5}(-\\d{4})?$"));

        //Tim's
        System.out.println(challenge12.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge13.matches("^\\d{5}(-\\d{4})?$"));







    }
}
