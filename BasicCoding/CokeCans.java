
public class CokeCans {

    public static void main(String[] args) {
        int Twox = 5; // 2 cans for $5
        int Fourx = 10; // 4 cans for $10

        int x = 148; //  Total money Tony has

        int totalCans = 0;//  To return money left and total cans got.

        totalCans += (x / Fourx) * 4;
        totalCans += (x % Fourx) / Twox * 2;

        x = x - ((x / Fourx) * Fourx + (x % Fourx) / Twox * Twox);

        System.out.println("Total cans Tony got: " + totalCans);
        System.out.println("Money left: " + x);
    }
}
