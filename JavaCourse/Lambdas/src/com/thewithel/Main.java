package com.thewithel;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        //one way of creating runnable
//	    new Thread(new CodeToRun()).start();
//
//	    //annonymous class
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from the Runnable annonymous");
//            }
//        }).start();

        //with lambdas
        new Thread(() -> {
            System.out.println("Printing from the Runnable Lambdas");
            System.out.println("Line 2");
            System.out.format("This is line %d\n", 3);
        }).start();

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        //negative if value is less than second value
        //positive if first value is greater than second value
        //0 when values are equal

        //equal method always has default implementation
//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        Collections.sort(employees, (Employee employee1, Employee employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        employees.sort((Employee employee1, Employee employee2) -> employee1.getName().compareTo(employee2.getName()));

        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }

        //calling function with new annonymous inteface
        //look at the arguments below for "doStringStuff"
        //first argument is annonymous interface and the second and third are
        //two strings that will be changed
        String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + " " + s2.toUpperCase();
            }
        }, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

        UpperConcat uc = ((s1, s2) -> (s1.toUpperCase() + " " + s2.toUpperCase()));
        String sillyString2 = doStringStuff(uc, employees.get(2).getName(), employees.get(3).getName());
        System.out.println(sillyString2);

        //return with more than two statements
        UpperConcat uc2 = (s1, s2) -> {
            String result = s1.toUpperCase() + " " + s2.toUpperCase();
            return result;
        };
        sillyString2 = doStringStuff(uc2, employees.get(2).getName(), employees.get(3).getName());
        System.out.println(sillyString2);


        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);

        s = anotherClass.doSomethingLambdas();
        System.out.println(s);

        s = anotherClass.doSomethingExample();
        System.out.println(s);

        System.out.println("\n\n\n");

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        //employee is final for each iteration
//        for(Employee employee: employees){
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        }

//        System.out.println("SEPARATOR BETWEEN LOOPS");
//
//        for(int i=0; i<employees.size(); i++){
//            Employee employee = employees.get(i);
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }


    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}

class AnotherClass {

    public String doSomething() {
        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The annonymous class's name is: " + getClass().getSimpleName());
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String1 ", "String2");
    }

    public String doSomethingLambdas() {
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The Lambda expression's class is " + getClass().getSimpleName());
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1 ", "String2");
    }

    public String doSomethingExample() {
        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The Lambda expression's class is " + getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

//        s1 = "hello";

//        UpperConcat uc = new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("i within anonymous class = " + i);
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        };
        System.out.println("The AnotherClass class's name is " + getClass().getSimpleName());

//            i++;
//        System.out.println("i= " + i);
        return Main.doStringStuff(uc, "String1 ", "String2");

    }

    public void pritnValue() {
        int number = 25;
        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("The value is +" + number);
        };

        new Thread(r).start();
    }
}

//class CodeToRun implements Runnable {
//
//    @Override
//    public void run() {
//        System.out.println("Printing from the Runnable implements");
//    }
//}
