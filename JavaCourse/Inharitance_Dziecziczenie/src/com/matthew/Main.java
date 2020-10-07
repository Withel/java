package com.matthew;

public class Main {

    public static void main(String[] args) {
	    Animal animal = new Animal("Animal", 1, 1, 5, 5);

	    Animal parons = new Dog("parons", 10, 10, 2, 2, 10, 10, "gowno");

		System.out.println(parons.getBody());
		System.out.println(parons.getName());
		//JAK ZROBIŁEM KLASĘ I PRZYPISAŁEM JEJ KLASĘ DZIEDZICZNĄ TO ŻBYE DOSTAĆ SIĘ DO JAKIEJŚ METODY DZIEDZICZNEJ MUSZĘ RZUTOWAĆ KLASĘ NADRZĘDNĄ
		//NA KLASE DZIEDZICZNA
		System.out.println(((Dog) parons).getCoat());

	    Dog dog = new Dog("Yorkie", 8, 20, 2, 4, 1, 20, "long silky");
//	    dog.eat();  //POMIMO, ŻE W KLASIE DOG NIE MA DEFINICJI DLA "EAT"
		dog.walk();
//		dog.run();	//odpala się dog.run(); potem Dog.move(), które wywołuje Dog.moveLegs() i dziedziczną metodę Animal.move()
    }
}
