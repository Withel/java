package com.matthew;

public class DeluxeBurger extends Burger {

    Chips theChips;
    Drinks theDrinks;

    public DeluxeBurger(String breadType, String rollMeat, int chipsSize, int drinksSize){
        super(breadType, rollMeat);
        theChips = new Chips(chipsSize);
        theDrinks = new Drinks(drinksSize);
        setPrice(5.0d + theChips.getrice() +  theDrinks.getPrice());
    }

    @Override
    public void showBurger() {
        super.showBurger();
        System.out.println("DeluxeBurger.showBureger() Called");
        System.out.println("Has chips at size "+ theChips.getSize());
        System.out.println("Has drinks at size "+ theDrinks.getSize());
    }
}
