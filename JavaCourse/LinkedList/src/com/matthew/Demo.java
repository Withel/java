package com.matthew;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrded(placesToVisit, "Sydney");
        addInOrded(placesToVisit, "Melbourne");
        addInOrded(placesToVisit, "Brisbane");
        addInOrded(placesToVisit, "Perth");
        addInOrded(placesToVisit, "Camberra");
        addInOrded(placesToVisit, "Adelaide");
        addInOrded(placesToVisit, "Darwin");

        printList(placesToVisit);

        addInOrded(placesToVisit, "Alice Springs");
        addInOrded(placesToVisit, "Darwin");
        printList(placesToVisit);

        //LinkedList<Customer> custofucker;
        visit(placesToVisit);

//        placesToVisit.add("Sydney");
//        placesToVisit.add("Melbourne");
//        placesToVisit.add("Brisbane");
//        placesToVisit.add("Perth");
//        placesToVisit.add("Canberra");
//        placesToVisit.add("Adelaide");
//        placesToVisit.add("Darwin");
//
//        printList(placesToVisit);
//
//        placesToVisit.add(1, "Alice Springs");
//        printList(placesToVisit);
//
//        placesToVisit.remove(4);
//        printList(placesToVisit);

    }

    //.hasNext() czy jest następny record
    //.next() przejdz do nastepnego recordu
    //i.next() najpierw pokaże i a potem przejdzie do następnego tak jak i++

    private static void printList(LinkedList<String> linkedList){
        Iterator<String> i = linkedList.iterator();
        System.out.println(i);
        while(i.hasNext()){
            System.out.println("Now visiting " +i.next());
        }
        System.out.println("======================");
    }

    private static void printListV2(LinkedList<String> linkedList){
        for(int i = 0; i<linkedList.size();i++){
            System.out.println(linkedList.get(i));
        }
        System.out.println("======================");
    }

    private static boolean addInOrded(LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();

        //compareTo(costam) zwraca inta jeżeli:
        //jest równy 0 to znaczy że argument jest taki sam jak to z czym porównujemy
        //jest większy od zera to znaczy że powinien się pojawić PRZED
        //jest mniejszy od zera to znaczy że powinien się pojawić PO
        while(stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0){
                //equal, do not add
                System.out.println(newCity + " is already included as a destination");
                return false;
            }else if(comparison > 0){
                //newCity should appear before this one
                //Brsbane -> Adelaide
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }else if (comparison <0 ){
                //move on next city
            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()){
            System.out.println("No cities in");
            return;
        }else{
            System.out.println("Now visiting "+listIterator.next());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()) listIterator.next();
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) System.out.println("Now visiting " + listIterator.next());
                    else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward){
                        if(listIterator.hasPrevious())
                            listIterator.previous();
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious())
                        System.out.println("Now visiting " + listIterator.previous());
                    else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }

        }
    }

    private static void printMenu(){
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                        "1 - go to next city\n" +
                        "2 - go to previous city\n" +
                        "3 - reprint menu");
    }
}
