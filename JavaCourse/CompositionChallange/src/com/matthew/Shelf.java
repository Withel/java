package com.matthew;

public class Shelf {

    private int cdcount;
    private Dimensions dimensions;

    public Shelf(int cdcount, Dimensions dimensions) {
        this.cdcount = cdcount;
        this.dimensions = dimensions;
    }

    public void takeOffCd(int count){
        cdcount += count;
        System.out.println("You've taken cds. Actual number is "+cdcount);
    }

    public int getCdcount() {
        return cdcount;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
}
