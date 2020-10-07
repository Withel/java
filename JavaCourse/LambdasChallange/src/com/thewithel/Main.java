package com.thewithel;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        //1. Convert annonymous class into lambda
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String s : parts) {
                    System.out.println(s);
                }
            }
        };

        //lambda Expression
        Runnable runnable2 = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String s : parts) {
                System.out.println(s);
            }
        };

        //2
        Function<String, String> lambdaFunction = (String s) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };

        //3. Write the code that will execute the fuyncktion with the argument of "1234567890"
        System.out.println(lambdaFunction.apply("1234567890"));

        //5. Using the bonus version, call the method with the lamdaFunction we created earlier
        // and the string "1234567890". Print the result returned from the method
        System.out.println(everySecondCharFun(lambdaFunction, "1234567890"));

        //6. Write a lambda expressiuon that maps to the java.util.Supplier interface.
        //This lambda should return the string "I love Java!" Assign it to a var called iLoveJava
        Supplier<String> iLoveJavaSupplier = () -> "I love Java!";

        //7. Use that supplier
        String supplierResult = iLoveJavaSupplier.get();
        System.out.println(supplierResult);

        //Q1. Given a specific interface, how can we tell wheter we can map a mabda expression
        //to it? What's the criteria that has to be met?
        //The interface has to be functrional interface. It can have only a single method that must be implemented.

        //Q2. Can we use a lambda expression to represent an instane of the java.util.concurrent.Callable interface.
        //YES, because it has only one method that we have to implement

        //Q3. Is the java.util.Comparator interface a functional interface?
        //Yes, despite having over 10 methods, only one method has to be implemented and its Compare

        //9 Write code to print the items in the list in sorted orderm and  with the first letter
        //in each name upper-cased.
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "Oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach((String name) ->
                firstUpperCaseList.add(name.substring(0, 1).toUpperCase() + name.substring(1)));

        firstUpperCaseList.sort((String s1, String s2) -> s1.compareTo(s2));
        firstUpperCaseList.forEach((String s) -> System.out.println(s));

        System.out.println("================================");
        //10. Change the code so that it uses method references. Remember that method reference looks like Class::MethodName

        List<String> firstUpperCaseList2 = new ArrayList<>();
        topNames2015.forEach((String name) ->
                firstUpperCaseList2.add(name.substring(0, 1).toUpperCase() + name.substring(1)));

        firstUpperCaseList2.sort(String::compareTo);
        firstUpperCaseList2.forEach(System.out::println);

        System.out.println("================================");
        //11. Do the same thing but using a stream and a chain of stream operations.

        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        //12. Instead of printing out the sorted name, print out how namy names begin with the latter A instead.

        long namesBeginningWithA = topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();

        System.out.println("Names beggining with A = " + namesBeginningWithA);

        //13. Use peek() to print out the names after the map() method has executed.
        //What will the following code print to the console?

        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo);

        //nothing will be printed because chain doesnt contain terminal operation
        //remamber that stream chains are evaluated lazily. Nothing happens until
        //a terminal operation is added to the chain. At that point, the chain is executed.


        //14. Add a terminal operation to this chain so that the peek call will execute

        System.out.println(topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .count());

        //we dont have to use the result of terminal operation (you can delete that sout) to see the results
        //.collect() is also an option here

    }

    //2.Write the following method as a lambda expression
    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    }

    //4. Write a method called everySecondCharacter that accepts the funcion as a parameter
    // and executes it with the argument "1234567890

    public static String everySecondCharFun(Function<String, String> fun, String argument) {
        return fun.apply(argument);
    }
}
