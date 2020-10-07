package com.matthew;

public class Main {

    public static void main(String[] args) {
        //ITelephone timsPhone = new Telephone(123456); to jest niepoprawne
        //mozna rowniez zapisac DeskPhone timPhone = new DeskPhone(123456);
        ITelephone timsPhone;
        timsPhone = new DeskPhone(123456);
        timsPhone.powerOn();
        timsPhone.callPhone(123456);
        timsPhone.answer();

        timsPhone = new MobilePhone(24565);
        timsPhone.powerOn();
        timsPhone.callPhone(24565);
        timsPhone.answer();
    }
}
