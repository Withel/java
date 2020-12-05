public class Test {
    String name;
    int age;

    Test(String name) {
        this.name = name;
    }

    void Test(String name, int age) { // Line 1
        this.name = name;
        this.age = age;
    }

//    static public void main(String[] args) {
//        Test a = new Test(); // Line 2
//        Test b = new Test("Mary");  // Line 3
//        Test c = new Test("Mary", 25);  // Line 4
//        b.Test("Mary", 25);  // Line 5
//    }
}