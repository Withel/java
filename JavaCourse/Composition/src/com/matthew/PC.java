package com.matthew;

public class PC {
    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUP(){
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo(){
        //fancy graphics
        monitor.drawPixel(1200, 500, "red");
    }

    //MOZNA WYJEBAĆ BO I TAK SĄ PRIVATE

//    private Case getTheCase() {
//        return theCase;
//    }
//
//    private Monitor getMonitor() {
//        return monitor;
//    }
//
//    private Motherboard getMotherboard() {
//        return motherboard;
    }
}
