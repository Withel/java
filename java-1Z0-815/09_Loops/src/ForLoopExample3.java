/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 4: Using Operators and Decision Constructs
Topic: Loops
Sub-Topic: For Loop
*/

public class ForLoopExample3 {

    // Create a method which may throw an exception and returns an int
    public static int interruptIt(int i) throws Exception {
        System.out.println("interruptIt: i = " + i);
        if (i < 10) throw new Exception("Break it up");
        return i;
    }

    public static int initLoop(int i){
        return i;
    }

    public static int returnTerminationInt(int i){
        return i;
    }

    public static int incrementInt(int i){
        return i;
    }

    public static void main(String[] args) {

        int i;

        for(i = ForLoopExample3.initLoop(0); i < ForLoopExample3.returnTerminationInt(10); ForLoopExample3.incrementInt(++i)){
            System.out.println(i);
        }


        // First, let's throw an exception in the initialization block...
        try {
            System.out.println("------- Executing For Loop A -------");
            // termination section of for loop declaration has prefix increment
            // increment section of for loop declaration uses postfix increment
            for (interruptIt(i); ++i < 10; i++) {
                System.out.println("A forloop: i = " + i);
            }
        } catch (Exception e) {
            System.out.println(e + ": i = " + i);
        }


        try {
            System.out.println("------- Executing For Loop A -------");
            for (i = 0; interruptIt(++i) < 10; i++) {
                System.out.println("A forloop: i = " + i);
            }
        } catch (Exception e) {
            System.out.println(e + ": i = " + i);
        }

        try {
            System.out.println("------- Executing For Loop A -------");
            for (i = 0; i<10 ; interruptIt(i++)) {
                System.out.println("A forloop: i = " + i);
            }
        } catch (Exception e) {
            System.out.println(e + ": i = " + i);
        }
    }
}