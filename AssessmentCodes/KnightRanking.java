package AssessmentCodes;

public class KnightRanking {
    public static void main(String[] args) {
        int[] ranks = { 4, 3, 5, 2, 1 };
        int n = ranks.length;
        int spclCount = 0;

        for (int i = 0; i < n; i++) {
            int lGreater = 0;
            int rGreater = 0;

            for (int j = 0; j < i; j++) {
                if (ranks[j] > ranks[i]) {
                    lGreater++;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (ranks[j] > ranks[i]) {
                    rGreater++;
                }
            }
            if (lGreater == rGreater) {
                spclCount++;
            }
        }
        System.out.println(spclCount);
    }
}
