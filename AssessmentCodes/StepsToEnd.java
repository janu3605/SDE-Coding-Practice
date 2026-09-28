package AssessmentCodes;

public class StepsToEnd {
    public static void main(String[] args) {
        int[] steps = { 1, 1, 1, 1, 3, 6, 1, 1, 4 };

        int jumps = 0;
        int currJumpEnd = 0;
        int FarthestReach = 0;

        for (int i = 0; i < steps.length; i++) {
            FarthestReach = Math.max(FarthestReach, i + steps[i]);
            if (i == currJumpEnd) {
                jumps++;
                currJumpEnd = FarthestReach;
            }
        }
        System.out.println(jumps);
    }
}
