package AssessmentCodes;

import java.util.*;

public class Messaging {
    public static void main(String[] args) {
        int[] platformTime = { 9, 6, 8, 6, 4, 4 };
        int[] supportTime = { 4, 3, 7, 7, 9, 8 };

        int n = platformTime.length;

        ArrayList<List<Integer>> messages = new ArrayList<>();
        int totalPlatformSum = 0;

        for (int i = 0; i < n; i++) {
            messages.add(Arrays.asList(platformTime[i], supportTime[i]));
            totalPlatformSum += platformTime[i];
        }
        Collections.sort(messages, (a, b) -> a.get(1).compareTo(b.get(1)));

        int minOverallTime = totalPlatformSum;
        int currentPlatformSum = totalPlatformSum;

        for (int i = 0; i < n; i++) {
            currentPlatformSum -= messages.get(i).get(0);
            int currentSupportMax = messages.get(i).get(1);

            int currMaxTime = Math.max(currentSupportMax, currentPlatformSum);
            minOverallTime = Math.min(minOverallTime, currMaxTime);
        }
        System.out.println(minOverallTime);
    }
}
