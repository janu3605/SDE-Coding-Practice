package PowerCoding;

public class LeftDominantDivisors {
    public static void main(String[] args) {
        int[] input = { 6, 2, 4, 12, 3 };
        int n = input.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (leftDiv(input, i) > rightDiv(input, i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static int leftDiv(int[] inpt, int idx) {
        int tcount = 0;
        for (int i = 0; i < idx; i++) {
            if (inpt[i] % inpt[idx] == 0) {
                tcount++;
            }
        }
        return tcount;
    }

    public static int rightDiv(int[] inpt, int idx) {
        int tcount = 0;
        for (int i = idx + 1; i < inpt.length; i++) {
            if (inpt[i] % inpt[idx] == 0) {
                tcount++;
            }
        }
        return tcount;
    }
}
