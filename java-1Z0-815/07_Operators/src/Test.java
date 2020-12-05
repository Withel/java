public class Test {
    public static void main(String[] args) {
        int i = 0;
        int j = 5;
        int k = 10;

        int loopIterations = 0;

        while ((i++ < j) || (j < --k)) {

            loopIterations++;
        }
        System.out.println(loopIterations);

    }
    //Correct Answer. There were 9 loop interations in total. The conditional expression in the while loop is using
    // a conditional-or operator || operator which evaluates its right-hand operand only if the value of its left-hand
    // operand is false. The code evaluates the left hand expression of the conditional or first (i++ < j) . As long as
    // this evaluates to true, the right hand part of the conditional statement is not evaluated and the decrement to k
    // does not occur.
}