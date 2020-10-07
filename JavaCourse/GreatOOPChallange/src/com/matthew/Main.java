package com.matthew;

public class Main {

    public static void main(String[] args) {
	Burger normal = new Burger("white", "bloody");
	normal.showBurger();
	normal.addCheese();
	normal.addExtraSauce();
	normal.showBurger();
	System.out.println("\n\n");

	HealthyBurger health = new HealthyBurger("hard");
	health.addSalad();
	health.addArugula();
	health.showBurger();

	DeluxeBurger deluxe = new DeluxeBurger("white", "something", 1, 3);
	deluxe.showBurger();

	//THIS IS MY SOLUTION, EVERYTHING BELOW, AND EVERY CLASS WITH "TIM" IS FROM COURSE.
    TimBurger timhamburger = new TimBurger("basice", "sausage", 3.56, "white");
    double price = timhamburger.itemizeHamburger();
    timhamburger.addHamburgerAddition1("Tomato", 0.27);
    timhamburger.addHamburgerAddition2("Lettuce", 0.75);
    timhamburger.addHamburgerAddition3("cheese", 1.12);
    System.out.println("total burger price is "+ timhamburger.itemizeHamburger());

	TimHealthyBurger timhealth = new TimHealthyBurger("Bacon", 5.67);
	timhealth.addHamburgerAddition1("Egg",5.43);
	timhealth.addHealthAddirtion1("Lentils", 3.41);
	System.out.println("total healthy burger price is" + timhealth.itemizeHamburger());

		System.out.println("\n\n");

    TimDeluxeBurger db = new TimDeluxeBurger();
    db.itemizeHamburger();
    db.addHamburgerAddition3("Should not do this", 50.54);
    db.itemizeHamburger();
    }
}
