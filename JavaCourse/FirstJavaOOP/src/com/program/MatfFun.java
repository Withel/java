package com.program;

public class MatfFun {

    private double paramA;
    private double paramB;
    private double paramC;
    private double result;

    public void getParam(double A, double B, double C){
        this.paramA = A;
        this.paramB = B;
        this.paramC = C;
        System.out.println("Your parameters are:\nA = "+this.paramA+"\nB = "+this.paramB+"\nC = "+this.paramC);
    }

    public void showOptions(){
        System.out.println("What do you want to do\n1.Sum your parameters.\n2.Multiply your parameters\n3. Calculate square function");
    }
    public void action(char chose){
        switch (chose) {
            case '1': {
                result=paramA+paramB+paramC;
                System.out.println("Your result = "+result);
                break; }
            case '2': {
                result = paramA*paramB*paramC;
                System.out.println("Your result = "+result);
                break;}
            default:
                System.out.println("There is no option as: "+chose);
                break;
            }
        }
    }


