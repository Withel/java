package com.matthew;

public class Chips {

    int size;
    double price;

    public Chips(int size){
        this.size = size;
        if (this.size == 1) this.price = 1d;
        if (this.size == 2) this.price = 2d;
        if (this.size == 3) this.price = 3d;
    }

    public double getrice() {
        return price;
    }

    public int getSize() {
        return size;
    }
}
