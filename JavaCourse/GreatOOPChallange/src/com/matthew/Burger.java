package com.matthew;

public class Burger {
    private String breadType;
    private String rollMeat;
    private double price;
    private boolean tomatos;
    private boolean onion;
    private boolean extraSauce;
    private boolean cheese;

    public Burger(String breadType, String rollMeat){
        this.breadType = breadType;
        this.rollMeat = rollMeat;
        setPrice(5.0d);
        this.tomatos = false;
        this.onion = false;
        this.extraSauce = false;
        this.cheese = false;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addPrice(double price){
        this.price += price;
    }

    public void addTomatos(){
        System.out.println("Burger.addTomatos() called.");
        if (this.tomatos == true){
            System.out.println("You've already added tomatos");
            return;
        }else{
         this.tomatos = true;
         this.price += 0.50d;
        }
    }

    public void addOnion(){
        System.out.println("Burger.addOnions() called.");
        if (this.onion == true){
            System.out.println("You've already added onion");
            return;
        }else{
            this.onion = true;
            this.price += 0.50d;
        }
    }

    public void addExtraSauce(){
        System.out.println("Burger.addSauce() called.");
        if (this.extraSauce == true){
            System.out.println("You've already added extraSauce");
            return;
        }else{
            this.extraSauce = true;
            this.price += 0.50d;
        }
    }

    public void addCheese(){
        System.out.println("Burger.addCheese() called.");
        if (this.cheese == true){
            System.out.println("You've already added cheese");
            return;
        }else{
            this.cheese = true;
            this.price += 0.50d;
        }
    }

    public String getBreadType() {
        return breadType;
    }

    public String getRollMeat() {
        return rollMeat;
    }

    public double getPrice() {
        return price;
    }

    public void showBurger(){
        System.out.println("Burger.showBureger() Called");
        System.out.println("Your: " + getClass().getSimpleName() +" has:");
        System.out.println("Bread type: " + this.breadType);
        System.out.println("Roll meat" + this.rollMeat);
        if (this.tomatos == true) System.out.println("Tomatos");
        if (this.onion == true) System.out.println("onions");
        if (this.extraSauce == true) System.out.println("extra sauce");
        if (this.cheese == true) System.out.println("cheese");
        System.out.println("Price for the Burger is: "+price);
    }
}
