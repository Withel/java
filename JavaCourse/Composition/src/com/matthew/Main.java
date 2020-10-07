package com.matthew;

//W SKRÓCIE TO TAKIE TROCHĘ STRUKTURY Z DODANYMI METODAMI W ŚRODKU

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 5);
	    Case theCase = new Case("220B", "ASUS", "240", dimensions);

        //STWORZENIE KLASY BEZ TWORZENIA ZMIENNEJ
	    Monitor theMonitor = new Monitor("27HP", "ASUS", 27,new Resolution(2540, 1440));

	    Motherboard theMotherboard = new Motherboard("AsusT100", "ASUS", 4, 4, "bios v2.0");

        PC thePC = new PC(theCase, theMonitor, theMotherboard);

        PC test = new PC(new Case("lolo", "bolo", "ciulo", new Dimensions(20, 20, 5)), new Monitor("HP", "HP", 27, new Resolution(2540, 1440)), new Motherboard("nazwa", "nazwa2", 24, 24, "bios"));

        //JAK DOSTAĆ SIĘ DO METOD ZAWARTYCH NP W MONITOR POPRZEZ PC (COŚ JAK STRUKTURY W C/C++
//        thePC.getMonitor().drawPixel(1500, 1200, "green");
        //OBIEKT thePC ODWIOŁUJE SIĘ DO METODY getMonitor z, której składa się monitor która wchodzi w skład PC, to samo z drawPixel
//        thePC.getMotherboard().loadProgramo("Windows 10");
//        thePC.getTheCase().pressPowerButton();

        thePC.powerUP();
    }
}
