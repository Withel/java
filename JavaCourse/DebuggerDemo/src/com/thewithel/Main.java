package com.thewithel;

//NOTES
//DEBUGGER IS PAUISNG RIGHT BEFORE BREAKPOINT
//UNDER 'Frames' MAMY TAKĄ FAJNĄ ZAKLADKE MAMY WĄTKI
//BARDZIEJ PONIZEJ JEST STACK TRACE
//ZMIENNE SIE AKTUALIZUJA PRZY PRZEGLADANIU FUNKCJI
//SHOW EXECUTION POINT - PRZYWRACA NAS DO MIEJSCA GDZIE APKA SIĘ ZNAJDUJE
//STEP OVER - NAJWAŻNIEJSZE GÓWNO, WYKONUJE LINIJKĘ
//STEP INTO - PODOBNIE JAK STEP OVER Z TYM, ŻE JEŻELI LINIJKA TO JAKAŚ FUNKCJA DO WYKONANIA TO WLEZIE DO ŚRODKA
//NIE WCHODZI TO METOD KTÓRE POCHODZĄ OD JDK
//FORCE STEP INTO - WYMUSZA WEJSCIE DO TEJ WYKONYWANEJ FUNCKJI
//STEP OUT - WYKONANIE CAŁEJ METODY I POWRÓT DO WYWOŁANIA, ALE SIĘ WYKONUJE
//DROP FRAME - COS JAK POWROT W CZASIE, TAKI REWIND, NIE WSZYSTKO SIE DA
//RUN TO CURSOR - WYKONUJE SIE DO MOMENTU W KTÓRYM JEST KURSOR
//WATCHPOINTY DLA ZMIENNYCH - ZA KAZDYM RAZEM KIEDY DANA ZMIENNA ZOSTANIE ZMIENIONA PROGRAM SIE ZATRZYMA
//SMART STEP INTO - WYBIEASZ SOBIE METODE W KTOREJ MA SIE ZTARZYMAC
//LIBRARIES THAT WERE USED IN THE COURSE ARE IN THE PROJECT FOLDER

//SHORTCUTS DEBILU WSZYSTKO JEST W ZAKŁADCE RUN...
//CTRL + F8 - SETUP BREAKPOINT
//SHIFT + F9 - RUN WITH DEBUGGER
//ALT + F10 - SHOW EXECUTION POINT
//F8 - STEP OVER
//F7 - STEP INTO
//SHIFT + F8 - STEP OUT
//ALT + SHIFT + F7 - FORCE STEP INTO
//ALT + F9 - RUN TO CURSOR
//CTRL + F2 - STOP MAIN
//RESUME PROGRAM F9
//CTRL + SHIFT + F8 - VIEW BREAKPOINTS
//CTRL + F5 - RERUN
//ALT + LCLICK NA TE RUBRYCZKE PO PRAWEJ - USTAWIA WATCH POINT
//SHIFT + F7 - SMART STEP INTO

public class Main {

    public static void main(String[] args) {
        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while(sb.length() < 10){
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);

        String str = "abcdefg";
        String result = utils.upperAndPrefix(utils.addSuffix(str));
    }
}
