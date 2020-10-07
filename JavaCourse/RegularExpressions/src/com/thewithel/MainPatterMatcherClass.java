package com.thewithel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPatterMatcherClass {

    public static void main(String[] args) {

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2pattern, Pattern.CASE_INSENSITIVE);
//        String h2pattern = ".*<h2>.*";
        //same as matches method it needs to match whole text so were adding to pattern
        // .*pattern.* where . means any character and * means that it can be followed by
        //any number of previous character (in this case ".")
        //it can be anything before or anything after
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        //how can we find occurences there are and where they actually occur
        //find(), start(), end() methods

        matcher.reset();
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurence " + count + " : " + matcher.start() + " to " + matcher.end());
        }
        System.out.println("==============================");

        //we define groups by surrounding them with ()
        // .* is greedy quantifier
        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurance: " + groupMatcher.group(1));
        }

        //three groups defined now
        String h2TextGroups = "(<h2>)(.+?)(</h>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find()) {
            System.out.println("Occurance: " + h2TextMatcher.group(2));
        }
        System.out.println("==============================");

        // "abc" = "a" and "b" and "c"
        // [Hh]arry
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        // [^abc] ^ means not
        //were using regular expression that tells us that we wanna find occurances
        //of "t" that isnt followed by "v" here were telling that "t" must be followed by sth
        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]";
        //below version that finds EVERY "t" that isnt followed by v
        //"?" is part of look ahead syntax and look ahead always starts with (?
        //when were using look ahead, this this characters that arent "t" are not
        //also part of the match
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurance " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }
        //if we want to find any "t" followed by "v" we do something like
        // t(?=v)  <- this is positive look ahead
        //validation of US Phone number
        //^([\(]{1}[0-9]{3}([\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        String phone1 = "1234567890"; // Shouldn't match
        String phone2 = "(123) 456-7890"; //Should match
        String phone3 = "123 456-7890"; //shouldnt match
        String phone4 = "(123)456-7890"; //also shouldnt match

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        //validation of visa number
        // ^4[0-9]{12}([0-9]{3})?$

        String visa1 = "4444444444444"; //match
        String visa2 = "5444444444444"; //no match
        String visa3 = "4444444444444444"; // match
        String visa4 = "4444"; // no match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));


    }

}
