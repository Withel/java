public class TestStringClass {

    public static void main(String[] args) {

        System.out.println(new s1().s1 == new s2().s2);

        String s = "";

        System.out.println(s);
    }

    static class s1{
        String s1 = "hello";
    }

    static class s2{
        String s2 = "hello";
    }
}
