package com.matthew;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrList();
                case 7:
                    quit = true;
                    break;
                default: continue;
            }
        }
    }

    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t0 - To print choice options.");
        System.out.println("\t1 - To print the list of grocery items");
        System.out.println("\t2 - To add an item to the list.");
        System.out.println("\t3 - To modify an item to the list.");
        System.out.println("\t4 - To remove an item from the list.");
        System.out.println("\t5 - To search for an item in the list.");
        System.out.println("\t6 - To quit the application.");
    }

    public static void addItem(){
        System.out.print("Please enter the grocery iten: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem(){
        System.out.print("Current item name: ");
        String itemNo = scanner.nextLine();
        //CZYŚCI BUFOR!!!
        //scanner.nextLine();
        System.out.print("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem);
    }

    public static void removeItem(){
        System.out.print("Enter item name: ");
        String itemNo = scanner.nextLine();
        //CZYŚCI BUFOR!!!
        //scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    public static void searchForItem(){
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)){
            System.out.println("Found "+searchItem+" in our grocery list");
        }else{
            System.out.println(searchItem +" is not in the shopping list");
        }
    }

    public static void processArrList(){
        ArrayList<String>newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}










    /*
    private static int[] baseData = new int[10];
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enster 10 numbers");
        getInput();
        printArray(baseData);
        resizeArray();
        baseData[10] = 666;
        baseData[11] = 321;
        printArray(baseData);
    }

    private static void getInput(){
        for (int i=0; i < baseData.length; i++){
            baseData[i] = s.nextInt();
        }
    }

    private static void printArray(int[] arr){
        for(int i=0; i<arr.length;i++)
            System.out.println(arr[i] + " ");
        System.out.println();
    }

    private static void resizeArray(){
        int[] original = baseData;

        baseData = new int [12];
        for (int i =0;i <original.length;i++)
            baseData[i] = original[i];
    }
*/
