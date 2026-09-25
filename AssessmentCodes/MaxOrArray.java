package AssessmentCodes;

public class MaxOrArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int n = arr.length;

        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = arr[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] | arr[i];
        }

        suff[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] | arr[i];
        }

        int totalOr = pref[n - 1];
        int maxOr = 0;

        int R = 0;

        for (int l = 0; l < n; l++) {
            while (R < n) {
                int leftOr = (l == 0) ? 0 : pref[l - 1];
                int rightOr = (R + 1 == n) ? 0 : suff[R + 1];
                if ((leftOr | rightOr) == totalOr) {
                    R++;
                } else {
                    break;
                }
            }
            if (R - 1 >= l) {
                maxOr = Math.max(maxOr, R - l);
            }
        }
        System.out.println(maxOr);
    }
}
