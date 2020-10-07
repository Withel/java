package com.matthew;

public class Quilt {

    private String material;
    private int lenght;
    private int width;

    public Quilt(String material, int lenght, int width) {
        this.material = material;
        this.lenght = lenght;
        this.width = width;
    }

    public void place(){
        System.out.println("Quilt i placing in.");
    }

    public String getMaterial() {
        return material;
    }

    public int getLenght() {
        return lenght;
    }

    public int getWidth() {
        return width;
    }
}
