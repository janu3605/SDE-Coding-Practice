package BasicCoding;

import java.util.ArrayList;

public class FourDigitEvenPerfectSqr {

    public static void main(String[] args) {
        ArrayList<Integer> perfectSqr = new ArrayList<>();

        for (int n = 32; n < 99; n += 2) {
            int sqr = n * n;
            while (sqr != 0) {
                int digit = sqr % 10;
                if (digit % 2 != 0) {
                    break;
                }
                sqr /= 10;
            }
            if (sqr == 0) {
                perfectSqr.add(n);
            }
        }
        System.out.println(perfectSqr);
    }
}
