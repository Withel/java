package com.thewithel;

//ArrayList inherits AbstractList class and implements List interface.
//ArrayList is initialized by a size, however the size can increase if collection grows or shrunk if objects are removed from the collection.
//Java ArrayList allows us to randomly access the list.
//ArrayList can not be used for primitive types, like int, char, etc. We need a wrapper class for such cases (see this for details).
//ArrayList in Java can be seen as similar to vector in C++.

//Constructors in Java ArrayList:
//ArrayList(): This constructor is used to build an empty array list
//ArrayList(Collection c): This constructor is used to build an array list initialized with the elements from collection c
//ArrayList(int capacity): This constructor is used to build an array list with initial capacity being specified

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class ArrayListMain {

    public static void main(String[] args) {
        ArrayList<Integer> intsArray = new ArrayList<>();

        //you can remove by object, or by index, you cant remove first or last
        intsArray.add(0);
        intsArray.add(1);
        intsArray.add(2);
        intsArray.add(0, 10);

        for(Integer i : intsArray){
            System.out.println(i);
        }

        intsArray.remove(new Integer(2));
        System.out.println("==================");
        for(Integer i : intsArray){
            System.out.println(i);
        }

        //getting from array is done by .get(Index) position
        System.out.println("==================");
        for(int i=0; i<intsArray.size(); i++){
            System.out.println(intsArray.get(i));
        }

        intsArray.remove(1);
        System.out.println("==================");
        for(Integer i : intsArray){
            System.out.println(i);
        }

        //with iterator
        ListIterator<Integer> iterator = intsArray.listIterator();
        System.out.println("==================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        ArrayList<Integer> anotherList = new ArrayList<>();
        anotherList.add(new Integer(22));
        anotherList.add(new Integer(33));
        intsArray.addAll(anotherList);
        //reseting iterator is just making a new one kappa
        iterator = intsArray.listIterator();
        System.out.println("==================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //as list
        Integer[] ints = {55, 66, 77, 88, 99};
        intsArray.addAll(Arrays.asList(ints));
        iterator = intsArray.listIterator();
        System.out.println("==================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
