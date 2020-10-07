package com.matthew;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Tim", 55.96);
        Customer anotherCustomer;
        anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getName() +" is "
        + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for(int i=0; i<intList.size(); i++){
            System.out.println(i + ": "+intList.get(i));
        }

        ArrayList<String> mrString = new ArrayList<String>();

        mrString.add("papaja");
        mrString.add(0, "przedpapaja");

        for(int i=0;i<mrString.size(); i++)
            System.out.println(mrString.get(i));

        //dodawanie .add jest przeciążone i mozna podać również najpierw index
        //a potem wartośc którą tam chcemy wsadzić TO JEST JAKBY POMIĘDZY
        //trzeba pilnować gdzie się dodaje te indexy
        intList.add(1, 2);

        for(int i=0; i<intList.size(); i++){
            System.out.println(i + ": "+intList.get(i));
        }


    }
}
