package com.program;

public class Car {
    //zmienne w klasie w jave nazywane sa "fields" (pola chyba)
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;


    //Jeżeli odnosisz sie do field w klasie to używasz słowa kluczowego "this", a potem kropka
    public void setModel(String model){
        String validModel = model.toLowerCase();
        if (validModel.equals("carrera") || validModel.equals("commodore")){
            this.model = model;
        }
        else this.model = "unknown";
    }

    //IntelliJ w popodwiedziach m-method, f-field, kłódeczka otwarta/zamknięta = public/private
    public String getModel(){
        return this.model;
    }
}
