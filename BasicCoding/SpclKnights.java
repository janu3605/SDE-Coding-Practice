
public class SpclKnights {

    public static void main(String[] args) {
        int[] strengths = {5,4,3,2,1};

        int spclcount = 0;

        for (int i = 0; i < strengths.length; i++) {
            int L = 0;
            int R = 0;

            for (int j = 0; j < i; j++) {
                if (strengths[j] < strengths[i]) {
                    L++;
                }
            }

            for (int j = i + 1; j < strengths.length; j++) {
                if (strengths[j] < strengths[i]) {
                    R++;
                }
            }

            if (L > R) {
                spclcount++;
            }
        }
        System.out.println(spclcount);
    }
}
