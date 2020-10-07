package com.matthew;

public class Main {

    public static void main(String[] args) {
	    String var4 ="this is private to main()";

	    ScopeCheck scopeInstance = new ScopeCheck();
	    scopeInstance.useInner();

	    ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        System.out.println("var3 is not accesable here " + innerClass.var3);
//        System.out.println("scoupeInstance var1 is "+ scopeInstance.getVar1());
//        System.out.println(var4);
//
//
//        scopeInstance.timestTwo();
//        System.out.println("==================================================");
//        ScopeCheck.InnerClass innerClass =scopeInstance.new InnerClass();
//        innerClass.timestTwo();
    }
}
