package AssessmentCodes;

import java.util.*;

public class SpclStrValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1;
        int k = 50;

        int[][] counts = new int[n][26];
        int[] baseSum = new int[n];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            int sum = 0;
            for (int j = 0; j < s.length(); j++) {
                int val = s.charAt(j) - 'a';
                counts[i][val]++;
                sum += val;
            }
            baseSum[i] = sum;
        }
        int minTotalSpcl = 0;
        for (int i = 0; i < n; i++) {
            minTotalSpcl += baseSum[i] % k;
        }
        for (int c1 = 0; c1 < 26; c1++) {
            for (int c2 = c1 + 1; c2 < 26; c2++) {
                int currentTotal = 0;

                for (int i = 0; i < n; i++) {
                    long diff = (long) (counts[i][c1] - counts[i][c2]) * (c2 - c1);
                    long newSum = baseSum[i] + diff;

                    long mod = newSum % k;
                    if (mod < 0) {
                        mod += k;
                    }
                    currentTotal += mod;
                }

                if (currentTotal < minTotalSpcl) {
                    minTotalSpcl = currentTotal;
                }
            }
        }
        System.out.println(minTotalSpcl);
    }
}
