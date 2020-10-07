package com.matthew;


import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("print");

    public static void main(String[] args) {
	    Gearbox mcLaren = new Gearbox(6);
	    //Gearbox.Gear first = mcLaren.new Gear(1, 12.3);  <=wydupione, bo Gear jest private
        //Gearbox.Gear second = new Gearbox.Gear(2, 15.4); <== niepoprawne
        //Gearbox.Gear new mcLaren.Gear(3, 17.8);          <== niepoprawne
        //System.out.println(first.driveSpeed(1000));      <=wydupione, bo Gear jest private

        //BO DODANA FUNKCJA addGear DO KONSTRUKTORA
        //mcLaren.addGear(1, 5.3);
        //mcLaren.addGear(2, 10.6);
       // mcLaren.addGear(3, 15.9);
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000));


//        class ClickListener implements  Button.OnClickListener{
//            public ClickListener(){
//                System.out.println("I've been attached");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + "was clicked");
//            }
//        }
//
//        btnPrint.setOnClickListener(new ClickListener());
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
        listem();
    }

    private static void listem(){
        boolean quit = false;
        while(!quit){
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }
    }
}
