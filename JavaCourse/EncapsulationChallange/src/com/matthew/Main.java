package com.matthew;

public class Main {

    public static void main(String[] args) {
	Printer thePrinter = new Printer(50, true);

	int printedPages = thePrinter.printPages(4);
        System.out.println(printedPages);
        printedPages = thePrinter.printPages(4);
        System.out.println(printedPages);

    }
}
