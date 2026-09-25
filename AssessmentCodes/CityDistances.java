package AssessmentCodes;

import java.util.*;
public class CityDistances {
    public static void main(String[] args) {
        int n = 3;
        int x = 1;
        int y = 3;

        int[] result = new int[n];

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {

                int directDist = j - i;

                int distXY = Math.abs(i - x) + 1 + Math.abs(j - y);

                int distYX = Math.abs(i - y) + 1 + Math.abs(j - x);

                int minDist = Math.min(directDist, Math.min(distXY, distYX));

                if (minDist >= 1 && minDist <= n) {
                    result[minDist - 1]++;
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }
}