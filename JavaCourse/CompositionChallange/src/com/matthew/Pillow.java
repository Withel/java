package com.matthew;

public class Pillow {

    private String material;
    private int lenght;
    private int width;

    public Pillow(String material, int lenght, int width) {
        this.material = material;
        this.lenght = lenght;
        this.width = width;
    }

    public void turnOver(){
        System.out.println("Pillow is turning over.");
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
