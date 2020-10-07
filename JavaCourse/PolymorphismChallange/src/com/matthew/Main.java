package com.matthew;

class CarTim{
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public CarTim(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine(){
        return "Car -> start engine";
    }

    public String accelerate(){
        return "Car -> accelerate";
    }

    public String brake(){
        return "Car -> brake";
    }
}
//MOŻNA KOPIOWAĆ KLASY NACISKAJĄC PRAWYM NA NAZWĘ KLASY POTEM REFACTOR -> COPY

class Mitsubishi extends CarTim{
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Mitsubishi -> start engine";
    }

    @Override
    public String accelerate() {
        return "Mitsubishi -> accelerate";
    }

    @Override
    public String brake() {
        return "Mitsubishi -> break";
    }
}

class Honda extends CarTim{
    public Honda(int cylinders, String name) {
        super(cylinders, name);
    }

    // INNA METODA ZWRACANIA CZEGOŚ TAKIEGO

    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " -> start engine";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName() + " -> break";
    }
}

class Ford extends CarTim{
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "Ford -> start engine";
    }

    @Override
    public String accelerate() {
        return "Ford -> accelerate";
    }

    @Override
    public String brake() {
        return "Ford -> break";
    }
}

//PRZENOSZENIE KLAS PRAWYM NA KLASE PREFACTOR -> MOVE I WYBIERASZ SOBIE POTEM DESTINATION
public class Main {

    public static void main(String[] args) {

        CarTim carring = new CarTim(4, "default");
        System.out.println(carring.accelerate());
        System.out.println(carring.brake());
        System.out.println(carring.startEngine());

        Mitsubishi mitsu = new Mitsubishi(4, "Outlander");
        System.out.println(mitsu.accelerate());
        System.out.println(mitsu.brake());
        System.out.println(mitsu.startEngine());

        Ford fordu = new Ford(4, "fiesta");
        System.out.println(fordu.accelerate());
        System.out.println(fordu.brake());
        System.out.println(fordu.startEngine());

        Honda hondu = new Honda(4, "fiesta");
        System.out.println(hondu.accelerate());
        System.out.println(hondu.brake());
        System.out.println(hondu.startEngine());

        System.out.println("\n\n");

        for (int i=0; i<4;i++){
            int random = generate();
            Car something = maker(random);
            System.out.println("car #"+random + " " + something.introduce());
            }
        }
    static int generate(){
        return (int)(Math.random()*4+1);
    }

    static Car maker(int chosen){
        switch (chosen){
            case 1: return new Lexus();
            case 2: return new Mazda();
            case 3: return new Porshe();
            case 4: return new Car("default", 4);
        }
        return null;
    }


}
