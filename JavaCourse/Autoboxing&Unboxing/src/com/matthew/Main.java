package com.matthew;

import java.util.ArrayList;

class IntClass{
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}


//W SKRÓCIE "Integer.valueOf(i)" to Autoboxing czyli jakby zamienianie
//typu prymitywnego na klase
//Unboxing natomiast to sytuacja odwrotna "intArrayList.get(i).intValue()"
//kiedy z klasy np Integer zamieniamy na int

public class Main {

    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        int dupaDwa = 34;
        Integer dupa = new Integer(54);

        dupaDwa = dupa;
        System.out.println(dupaDwa);

        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Tim");

       // ArrayList<int> intArrayList = new ArrayList<int>();
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));


        //int i double mogą być klasami... xD
        Integer integer = new Integer(54);
        Double doubleValue = new Double(12.25);

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for(int i=0; i<10; i++)
            intArrayList.add(Integer.valueOf(i));

        for(int i=0; i<10; i++)
            System.out.println(i+ " --> " + intArrayList.get(i).intValue());

        Integer myIntValue = 56; //MOŻNA TAK ZAPISAĆ ALE KOMPILATOR
                                // WIDZI = Integer.valueOf(56);

        int myInt = myIntValue; // myIntValue.intValue();

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for(double dbl=0.0; dbl<=10.0; dbl += 0.5){
            myDoubleValues.add(dbl);
            //myDoubleValues.add(Double.valueOf(dbl));
        }

        for(int i=0; i<myDoubleValues.size(); i++){
            double value = myDoubleValues.get(i);
            //double value = myDoubleValues.get(i).doubleValue();
            System.out.println(i +" --> "+ value);
        }
    }
}
