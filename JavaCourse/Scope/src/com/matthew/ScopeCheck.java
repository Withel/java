package com.matthew;


public class ScopeCheck {
    public int publicVar =0;
    private int var1 =1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar ="+publicVar+" var1 ="+ var1);
    }

    public int getVar1() {
        return var1;
    }

    public void timestTwo(){
        int var2 = 2;
        for(int i=0;i<10;i++){
            System.out.println(i +" times two is "+i * var2);
        }
    }

    public void useInner(){
        InnerClass innerClass = new InnerClass();
        System.out.println("var3 from outer class: " +innerClass.var3);
    }

    //=================================================
    //klasa wewnetrzna
    public class InnerClass {
        private int var3 =3;

        public InnerClass() {
            System.out.println("InnerClass created, var1 is" + var1 +" var3 is: "+ var3);
        }

        public void timestTwo(){
            //int var1 = 2;
            System.out.println("var1 is still available here "+var1);

            for(int i=0;i<10;i++){
                System.out.println(i +" times two is "+i * var3);
            }
        }
    }
}
