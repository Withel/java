package com.thewithel;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * @author Srinjoy Santra
 */
public class TreeMapMain {
    // May be replaced by an external class
    static class TreeCompare
            implements Comparator<String>
    {
        /* Compares keys based on the
           last word's natural ordering */
        public int compare(String a, String b)
        {
            int i,j,k;

            //Sorting by surnames
            i = a.lastIndexOf(' ');
            j = b.lastIndexOf(' ');
            k = a.substring(i).compareToIgnoreCase
                    (b.substring(j));
            if(k==0)
                return a.compareToIgnoreCase(b);
            else return k;
        }

    }
    public static void main(String[] args) {

        TreeMap<String, Double> tm = new
                TreeMap<>(new TreeCompare());

        tm.put("Head First Java", 807.34);
        tm.put("Java: A Beginners Guide 6th "+
                "Edition", 593.05);
        tm.put("Java: The Complete Reference"+
                " 9th Edition", 531.31);
        tm.put("Core Java Volume I_Fundamentals"+
                " 9th Edition", 544.34);
        tm.put("Effective Java 2nd Edition", 373.70);

        // Values can be null
        tm.put("Java 8 in action", null);

        // Last entry with the same key
        // reflected in output
        tm.put("Java 8 in action", 539.65);

        Set<Map.Entry<String, Double>> set =
                tm.entrySet();
        for(Map.Entry<String,Double> me : set)
            System.out.println(me.getKey()+": Rs."
                    +me.getValue());

        tm.remove("Core Java Volume I_Fundamentals"+
                " 9th Edition");
        System.out.println("...After removal of "+
                "Core Java...");
        for(Map.Entry<String,Double> me : set)
            System.out.println(me.getKey()+": Rs."
                    +me.getValue());

    }
}
