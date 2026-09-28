package AssessmentCodes;

public class EditDistance {
    public static void main(String[] args) {
        String inpt = "horse";
        String output = "ros";
        System.out.println(RecursiveSolve(inpt, output, inpt.length(), output.length()));
    }

    public static int RecursiveSolve(String word1, String word2, int m, int n) {

        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
           return RecursiveSolve(word1, word2, m - 1, n - 1);
        }
        int insertCost = RecursiveSolve(word1, word2, m, n - 1);
        int deleteCost = RecursiveSolve(word1, word2, m - 1, n);
        int replaceCost = RecursiveSolve(word1, word2, m - 1, n - 1);

        return 1 + Math.min(replaceCost, Math.min(insertCost, deleteCost));
    }

}
