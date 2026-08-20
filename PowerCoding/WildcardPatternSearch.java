package PowerCoding;

public class WildcardPatternSearch {
    public static void main(String[] args) {
        String txt = "catbatmat";
        String pat = "?at";

        int n = txt.length();
        int m = pat.length();

        int found = 0;

        for (int i = 0; i <= n - m; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j) && pat.charAt(j) != '?') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                found++;
            }
        }
        System.out.println("Found: " + found);
    }
}