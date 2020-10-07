package com.matthew;

public class Drinks {

    int size;
    double price;

    public Drinks(int size){
        this.size = size;
        if (this.size == 1) this.price = 2d;
        if (this.size == 2) this.price = 3d;
        if (this.size == 3) this.price = 4d;
    }

    public double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }
}
