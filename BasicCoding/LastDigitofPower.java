package BasicCoding;

public class LastDigitofPower {

    public static void main(String[] args) {
        int base = 7;
        int exponent = 3;
// 1. Direct Approach
        int lastDigit = (int) Math.pow(base, exponent) % 10;

        System.out.println(lastDigit);
        lastDigit(7, 3);
    }
// 2. Cycle Rule 4 last digits only possible

    public static void lastDigit(int base, int exp) {
        int lastDigit = base % 10; 

        int rem = exp % 4;
        int power = (rem == 0) ? 4 : rem;
        System.out.println(Math.pow(lastDigit, power) % 10); 
    }
}
