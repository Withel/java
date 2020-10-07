package something;

public class Main {

    public static void main(String[] args) {
    int myInt = 4;
    byte myByte = 1;
    short myShort = 2;
    long myLong = 8L;
    //nie ma long long
    float myFloat = 5f / 3f;
    double myDouble = 5d / 3d;

    // W LICZBACH MOŻNA UŻYWAĆ _ KTÓRĄ IGNORUJE KOMPILATRO NP int i = 3_000_000;

    double given = 10;
    double result = given*0.4539237;

    System.out.println("The result equals:"+result);

    //char działa jak w C++
    //uzywa unicode ktory chyba pokrywa sie z ASCII \u - to chodzi że to unicode xd

    char myChar = 65;
    char myCharV2 = '\u00a9';

    System.out.println(myCharV2);
    System.out.println(myChar);

    //boolean to bool z C++

    boolean myBoolean = true;
    boolean chujek = false;

    String myString = "This is a string";
    System.out.println(myString + " dziwnie to dziala");
    myString += " lets make it longer";
    System.out.println(myString);

    //OPERATORY SĄ TAKIE SAME JAK W C++
    }
}
//PRIMITIVES JAVA TYPES - are defined by Java Language
//byte
//short
//int
//long
//float
//double
//char
//boolean

//Class
//String
