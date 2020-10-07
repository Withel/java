package com.matthew;

public class HealthyBurger extends Burger {

    private boolean salad;
    private boolean arugula;

    public HealthyBurger(String rollMeat) {
        super("brown bread", rollMeat);
        setPrice(6.0d);
        this.salad = false;
        this.arugula = false;
    }

    public void addArugula(){
        System.out.println("HealthyBurger.addArugula() called.");
        if (this.arugula == true){
            System.out.println("You've already added Arugula");
            return;
        }else{
            this.arugula = true;
            addPrice(0.75d);
        }
    }

    public void addSalad(){
        System.out.println("HealthyBurger.addSalad() called.");
        if (this.salad == true){
            System.out.println("You've already added Salad");
            return;
        }else{
            this.salad = true;
            addPrice(0.75d);
        }
    }

    @Override
    public void showBurger() {
        super.showBurger();
        System.out.println("HealthyBurger.showBureger() Called");
        if(salad == true) System.out.println("Salad.");
        if(arugula == true) System.out.println("Arugula");
    }
}
