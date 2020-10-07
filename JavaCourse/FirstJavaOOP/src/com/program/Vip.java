package com.program;

public class Vip {
    private String name;
    private double limit;
    private String email;

    //PAMIĘTAĆ ŻE INTELLIJ CHCE CI POMÓC W TWORZENIU CONSTRUKTORÓW, SETTERSÓW, GETTERSÓW I PEWNIE MILIONIE INNYCH GÓWNIEN  TEŻ

    public String getName() {
        return name;
    }

    public double getLimit() {
        return limit;
    }

    public String getEmail() {
        return email;
    }



    public Vip(String name, double limit, String email){
        this.name = name;
        this.limit = limit;
        this.email = email;
    }

    public Vip(){
        this("default name", 123456, "default email");
    }

    public Vip(String name, double limit){
        this(name, limit, "default@email");
    }

    public void showCustomer(){
        System.out.println("The Customer is:" + name);
        System.out.println("Limit is:" + limit);
        System.out.println("His Email is: "+email);
    }
}
