/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 11: Handling Exception
Topic:  Describe Exception Handling and types of exceptions
Sub-Topic:  Review
*/

import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;

public class ThrowableExamples {

    static class MyException extends Throwable{

    }

    public static void main(String[] args) {
        ThrowableExamples te = new ThrowableExamples();
        String filename = "This_File_Does_Not_Exist.out";

        te.throwAnError();

//        throw new Throwable();

//        throw new IOError(new Exception("asd"));

//        throw new RuntimeException("asd");

        // Try to open file with filename defined above
        try {
            te.throwAnError();
            FileInputStream f =
                    new FileInputStream(filename);

        }  // This statement catches anything thrown at you.
        catch (Throwable error) {
            // Check to see if it's an IOException and print something
            if (error instanceof IOException) {
                System.out.println("Something went wrong with the" +
                        " processing of " + filename);
            }

            printErrorStructure(error);
        }


    }

    // This method will just print the hierarchy of the exception
    public static void printErrorStructure(Object o) {
        Class parent = o.getClass();
        String prefix = "";
        System.out.println("Error caught was: ");
        do {
            System.out.println(prefix + " " + parent.getName());
            prefix += "--";
            parent = parent.getSuperclass();
            if (parent == null) break;

        }
        while (parent.getSuperclass() != null);
    }

    // Mocking an IOError ...
    private void throwAnError() throws IOError {
        throw new IOError(new Throwable("Testing"));
    }
}