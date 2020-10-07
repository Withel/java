package com.program;

public class Main {
    public static void main(String[] args) {
        /*
	    Car porshe = new Car();
	    Car holden = new Car();
	    porshe.setModel("911");
        System.out.println("Model is "+porshe.getModel());
        */
        /*
        MatfFun first = new MatfFun();
        first.getParam(5, 3,6);
        first.showOptions();
        first.action( '2');
        */
        BankAcc robert = new BankAcc();
        robert.setAccountNumber(1293528920);
        robert.setCustomerName("Robercik");
        robert.setBalance(1000);
        robert.setEmail("robercik@gmail.com");
        robert.setPhoneNumber(911);

        //robert.showCustomer();
        //robert.incrementBalance(100);
        //robert.decrementBalance(1200);
        //robert.decrementBalance(1000);

        //ZAMIAST POJEDYŃCZEGO PRZYPISYWANIA DANYCH POPRZEZ SETTERSY MOŻNA UŻYĆ KONSTRUKTORÓW
        BankAcc dareczek = new BankAcc(123456, 1000, "Dareczkowski",
                "dareczkowski@darek.com", 987654);
        dareczek.showCustomer();
        BankAcc pusty = new BankAcc();
        pusty.showCustomer();

        BankAcc ziomal = new BankAcc("ziomal", "ziomal@email.com", 124456);
        ziomal.showCustomer();

        Vip vajpierD = new Vip();
        Vip vajpierTold = new Vip("powiedz", 69696969, "powiedz czemu");
        Vip vajpierWithTwo = new Vip("Dali tylko dwa", 111111111);

        System.out.println("\n\n\n\n");

        // CTRL + SLASH zakomentowuje zaznaczony tekst

        vajpierD.showCustomer();
        vajpierTold.showCustomer();
        vajpierWithTwo.showCustomer();
    }

}
