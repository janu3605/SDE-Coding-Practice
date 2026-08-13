
public class FibonacciRecursive {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(RecFib(n));
    }

    public static int RecFib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return RecFib(n - 1) + RecFib(n - 2);
    }
}
