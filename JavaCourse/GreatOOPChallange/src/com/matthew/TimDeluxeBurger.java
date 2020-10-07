package com.matthew;

public class TimDeluxeBurger extends TimBurger {
    public TimDeluxeBurger() {
        super("deluxe", "Sausage adn Bacon", 14.54, "white");
        super.addHamburgerAddition1("Chips", 2.75);
        super.addHamburgerAddition2("Drinks", 2.50);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Canno't add additional items to deluxe burger");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Canno't add additional items to deluxe burger");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Canno't add additional items to deluxe burger");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Canno't add additional items to deluxe burger");
    }
}
