package com.matthew._static;

public class ExtendedPassword extends Password {
    private int decryptedPassword;

    public ExtendedPassword(int one){
        super(one);
        this.decryptedPassword = one;
    }

//    @Override
//    public void storePassword(){
//        System.out.println("Saving password as " + decryptedPassword);
//    }
}
