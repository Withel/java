public class Test {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder(5);  //  Line 1
        builder.append("abcdefghijklmnopqrstuvwxyz");            //  Line 2
        char[] myCharArray;                                     //  Line 3
        if ("hello" == "hello") myCharArray = new char[5];
        builder.getChars(0, 5, new char[5], 0);  //  Line 4
        System.out.println(new String(myCharArray).trim() + "*"); // Line 4

//        String _;
//        String _helloWorld$;
//        String true;
//        String java.lang;
//        String Public;
//        String 1980_s;
//        String _Q2_;
    }
}