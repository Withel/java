package com.matthew;


//WSZYSTKIE METODY Z INTERFACE MUSZĄ BYĆ ZAWARTE W KLASIE KTÓRA IMPLEMENTUJE Z
//TEGO INTERFACE'U
public interface ITelephone {
    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();
}
