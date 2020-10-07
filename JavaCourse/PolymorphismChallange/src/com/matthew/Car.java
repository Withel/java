package com.matthew;

public class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;
    private boolean status;
    private int speed;

    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        this.engine = true;
        this.wheels = 4;
        this.status = false;
        this.speed = 0;
    }

    public String getName(){
        return this.name;
    }

    public int getCylinders(){
        return this.cylinders;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void changeStatus(){
        System.out.println("Car.changeStatus() called.");
        if (this.status == false) this.status = true;
        if (this.status == true) this.status = false;
    }

    public void accelerate(int acc){
        System.out.println("Car.accelerate() called.");
        this.speed += acc;
    }

    public void stop(){
        System.out.println("Car.stop() called.");
        this.speed = 0;
    }

    public String introduce(){
        return "No specific car here.";
    }

}

class Lexus extends Car{

    private String type;

    public Lexus() {
        super("Lexus", 4);
        this.type = "LS";
    }

    @Override
    public void changeStatus(){
        System.out.println("Lexus.changeStatus() called.");
    }

    @Override
    public String introduce(){
        return "I'm Lexus" + type;
    }
}

class Mazda extends Car{

    private String type;

    public Mazda(){
        super("Mazda", 4);
        this.type = "6";
    }

    @Override
    public void changeStatus(){
        System.out.println("Mazda.changeStatus() called.");
    }

    @Override
    public String introduce(){
        return "I'm Mazda" + type;
    }
}

class Porshe extends Car{

    private String type;
    public Porshe(){
        super("Porshe", 8);
        this.type = "Panamera";
    }

    @Override
    public void changeStatus() {
        System.out.println("porshe.changestatus() called.");
        super.changeStatus();
    }

    @Override
    public String introduce() {
        return "I'm Porshe." + type;
    }
}