package com.matthew._static;

public class Password {
    private static final int key = 7269429;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int password){
        return password ^ key;
    }

    public final void storePassword(){
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public boolean letMeIn(int password) {
        if(encryptDecrypt(password) ==  this.encryptedPassword){
            System.out.println("welcome");
            return true;
        } else {
            System.out.println("Nope, you cant come in");
            return false;
        }
    }
}
