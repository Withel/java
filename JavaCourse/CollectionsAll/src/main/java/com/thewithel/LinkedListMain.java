package com.thewithel;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListMain {

    /*
    *Linked List are linear data structures where the elements are not stored in contiguous
    * locations and every element is a separate object with a data part and address part.
    * The elements are linked using pointers and addresses. Each element is known as a node.
    * Due to the dynamicity and ease of insertions and deletions, they are preferred over the arrays.
    * It also has few disadvantages like the nodes cannot be accessed directly instead we need to start
    * from the head and follow through the link to reach to a node we wish to access.
    To store the elements in a linked list we use a doubly linked list which provides a linear data structure
    and also used to inherit an abstract class and implement list and deque interfaces.

    In Java, LinkedList class implements the list interface. The LinkedList class also consists of
    various constructors and methods like other java collections.

    Constructors for Java LinkedList:

    LinkedList(): Used to create an empty linked list.
    LinkedList(Collection C): Used to create a ordered list which contains all the elements of a specified collection,
    as returned by the collection’s iterator.
    */

    public static void main(String[] args) {
        // Creating object of class linked list
        LinkedList<String> object = new LinkedList<String>();

        // Adding elements to the linked list
        object.add("A");
        object.add("B");
        object.addLast("C");
        object.addFirst("D");
        object.add(2, "E");
        object.add("F");
        object.add("G");
        System.out.println("Linked list : " + object);

        // Removing elements from the linked list
        //you can remove by object, or by index or remove first or last
        object.remove("B");
        object.remove(3);
        object.removeFirst();
        object.removeLast();
        System.out.println("Linked list after deletion: " + object);

        // Finding elements in the linked list
        System.out.println(object);
        boolean status = object.contains("E");

        if(status)
            System.out.println("List contains the element 'E' ");
        else
            System.out.println("List doesn't contain the element 'E'");

        // Number of elements in the linked list
        int size = object.size();
        System.out.println("Size of linked list = " + size);

        // Get and set elements from linked list
        Object element = object.get(2);
        System.out.println("Element returned by get() : " + element);
        object.set(2, "Y");
        System.out.println("Linked list after change : " + object);

        //iterating with iterator
        System.out.println("================");
        ListIterator<String> iter = object.listIterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        //when youre converthing normal array to LinkedList you also use Arrays class asList()
        String splitted[] = "I am splitted string".split(" ");
        LinkedList<String> newList = new LinkedList<>(Arrays.asList(splitted));
        object.addAll(newList);
        System.out.println("================");
        iter = object.listIterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
