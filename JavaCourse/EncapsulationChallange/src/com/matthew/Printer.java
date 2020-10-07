package com.matthew;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if (tonerLevel >=-1 && tonerLevel <=100){
            this.tonerLevel = tonerLevel;
        }else{
            this.tonerLevel = -1;
        }
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount){
        if(tonerLevel > 0 && tonerLevel <=100){
            if (this.tonerLevel + tonerAmount > 100) return -1;
            this.tonerLevel +=tonerAmount;
            return this.tonerLevel;
        }else{
            return -1;
        }
    }

    public int printPages(int pages){
        int pagesToPrint = pages;
        if (this.duplex == true){
            pagesToPrint /= 2;
            System.out.println("Printing in duplex mode");
        }
        this.pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}

















/*
    private boolean duplex;
    private int tonerLevel;
    private int pagesPrinted;

    public Printer(boolean duplex) {
        this.duplex = duplex;
        this.tonerLevel = 100;
        this.pagesPrinted = 0;
    }

    public void printPage(int toPrint){
        for (int i =0; i<toPrint;i++){
            if (tonerLevel <= 0){
                System.out.println("You don't have enough toner. Please fill it");
                System.out.println("You've printed " + this.pagesPrinted);
                return;
            }
            else {
                System.out.println("Printing page no. " + i+1);
                tonerLevel -= 5;
                pagesPrinted ++;
            }
        }
    }

    public void fillFull(){
        this.tonerLevel = 100;
    }*/
