
import java.util.Scanner;

public class CoinShop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int t = sc.nextInt();

        t = t - a;

        int y = t / b;

        int x = ((t - (y * b)) / a) + 1;

        if (t - (x * a) - (y * b) == 0) {
            System.out.println(x + " " + y);
        } else {
            System.out.println(-1);
            System.out.println(x + " " + y);
        }

    }
}
