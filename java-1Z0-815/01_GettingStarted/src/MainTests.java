public class MainTests {
    // Executable main method
    public static void main(String[] args) {
        main("");
        main();
    }

    // Incorrect Signature, not an executable main
    public static void main(String arg) {
        System.out.println("main(String arg): Not an executable main method");
    }

    // Incorrect Signature, not an executable main
    public static void main() {
        System.out.println("main(): Not an executable main method");
    }
}