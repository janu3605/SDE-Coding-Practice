package BasicCoding;

public class SubStringCheck {

    public static void main(String[] args) {
        String str1 = "Hello, welcome to the world of Java programming!";
        String str2 = "Java";

        // System.out.println(str1.compareTo(str2)); helps to check lexicographic order
        //  1. Using Inbuilt Contrians
        if (str1.contains(str2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        // 2. Using IndexOf method
        if (str1.indexOf(str2) != -1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        // 3. Using Regular Expressions
        if (str1.matches(".*" + str2 + ".*")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        // 4. Manual Method
        int n = str1.length();
        int m = str2.length();
        for (int i = 0; i < n - m + 1; i++) {
            int j = 0;
            while (j < m && str1.charAt(i + j) == str2.charAt(j)) {
                j++;
            }
            if (j == m) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}
