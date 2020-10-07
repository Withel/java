package com.matthew;

//JEŻELI CHCESZ ŻEBY JAKAŚ KLASA COŚ DZIEDZICZYŁA (INHERIT) TO TRZEBA PO NAZWIE KLASY JEBNĄĆ SŁOWO KLUCZOWE "EXTENDS"

public class Dog extends Animal{

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    //WYRZUCAM BRAIN I BODY Z CONSTURUCTORA I PRZYPISUJĘ WARTOŚĆ "DEFAULT",  POŹNIEJ DODAJĘ EKSTRA PARAMETRY Z KLASY DOG
    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        super(name, 1, 1, size, weight);
        //SŁOWO KLUCZOWE "SUPER" WYWOŁUJE KONSTRUKTOR, KTÓRY JEST W KLASIE Z KTÓREJ ROZSZERZAMY/DZIEDZICZYMY
        //INICJALIZUJE TYLKO PARAMETRY KTÓRE SĄ W KLASIE ANIMALS WIĘC MUSIMY JESZCZE ZAINICJALIZOWAĆ TE KTÓRE SĄ W KLASIE DOG
        this.eyes =eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

    private void chew(){
        System.out.println("Dog.chew(); has been called.");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() has been called.");
        chew();
        super.eat();
    }

    private void moveLegs(){
        System.out.println("Dog.moveLegs() has been called.");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move(); has been called.");
        moveLegs();
        super.move(speed);
    }

    public void walk(){
        System.out.println("Dog.walk() has been called");
        move(5);
    };

    public void run(){
        System.out.println("Dog.run(); has been called");
        move(10);
    }

    public String getCoat() {
        return this.coat;
    }

}
