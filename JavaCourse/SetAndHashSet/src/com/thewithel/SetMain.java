package com.thewithel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.lang.Math;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<Integer>();
        Set<Integer> cubes = new HashSet<Integer>();

        for(int i=1;i <=100;i++){
            squares.add(i*i);
            cubes.add((int)Math.pow(i, 3));
        }


        System.out.println("There are " + squares.size()+" squares and "+ cubes.size() +" cubes.");

        Set<Integer> union = new HashSet<Integer>(squares);
        union.addAll(cubes);

        System.out.println("Union contains "+ union.size() + " elements");

        Set<Integer> intersection = new HashSet<Integer>(squares);
        //retainAll removes all elements that arent the same from the second set
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size()+" elements");
        for(int i: intersection){
            System.out.println(i+ "this is square of " + Math.sqrt(i)+" and the cube of "+Math.cbrt(i));
        }

        Set<String> words = new HashSet<String>();
        String sentence = "One day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        for(String s: words){
            System.out.println(s);
        }

        Set<String> nature = new HashSet<String>();
        Set<String> divine = new HashSet<String>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("Nature - divine");
        Set<String> diff1 = new HashSet<String>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature");
        Set<String> diff2 = new HashSet<String>(divine);
        diff2.removeAll(nature);
        printSet(diff2);



        Set<String> unionTest = new HashSet<String>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<String>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        System.out.println("Asymetric differnce");
        printSet(intersectionTest);

        if(nature.containsAll(divine)){
            System.out.println("divine is a subset of nature");
        }

        if(nature.containsAll(intersectionTest)){
            System.out.println("intersection is subset of nature");
        }

        if(divine.containsAll(intersectionTest)){
            System.out.println("Intersection is a subset of divine");
        }


    }

    private static void printSet(Set<String> set){
        System.out.print("\t");
        for(String s: set){
            System.out.print(s+ " ");
        }
        System.out.println();
    }
}
