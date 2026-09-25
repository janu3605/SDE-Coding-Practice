package AssessmentCodes;

public class CupCakeContest {
    public static void main(String[] args) {
        int n = 4;
        int[] cupcakes = { 1, 2, 3, 4 };
        int ways = 0;
        for (int i = 0; i < n; i++) {
            if (cupcakes[i] % 2 == 0) {
                ways += Math.pow(2, i);
            }
        }
        System.out.println(ways);
    }
}
