package com.matthew;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
		System.out.println("How many intigers you wanna sort?\t");
		int size = scanner.nextInt();
		int[] arrayNotSorted = getArray(size);

		//ALTERNATYWNA METODA KOPIOWANIA TABLIC
		int[] example = Arrays.copyOf(arrayNotSorted, arrayNotSorted.length);

		int[] arraySorted = copyArr(arrayNotSorted);
		toSort(arraySorted);
		System.out.println("Array before sorting:");
		printArr(arrayNotSorted);
		System.out.println("Array after sorting");
		printArr(arraySorted);
    }

    public static int[] copyArr(int[] copy){
    	int[] temp = new int[copy.length];
    	for (int i=0;i<copy.length;i++){
    		temp[i] = copy[i];
		}
		return temp;
	}

    public static void printArr (int[] toPrint){
    	for (int i=0;i<toPrint.length;i++){
			System.out.println("Element " + i + " = " + toPrint[i]);
		}
	}

    public static int[] getArray(int size){
    	int[] tempArr = new int [size];
    	for (int i=0; i<tempArr.length; i++){
			System.out.println("Enter "+ i+" number.\t");
    		tempArr[i] = scanner.nextInt();
		}
		return tempArr;
	}

	public static void toSort(int[] toSort){
		for (int i=0; i<toSort.length;i++){
			for (int j =0;j<toSort.length;j++){
				if (toSort[i]>toSort[j]){
					int temp = toSort[i];
					toSort[i] = toSort[j];
					toSort[j] = temp;
				}
			}
		}
	}

	public static void toSort2(int[] sortedArray){
    	boolean flag = true;
    	int temp;
    	while(flag){
    		for (int i =0;i<sortedArray.length;i++){
    			if(sortedArray[i] < sortedArray[i+1]){
    				temp = sortedArray[i];
    				sortedArray[i] = sortedArray[i+1];
    				sortedArray[i+1] = temp;
    				flag = true;
				}
			}
		}
	}
}
