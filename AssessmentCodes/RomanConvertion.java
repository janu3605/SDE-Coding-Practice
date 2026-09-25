package AssessmentCodes;

import java.util.*;

public class RomanConvertion {
    public static void main(String[] args) {

        int[] nums = { 3, 58, 1994 };

        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        List<String> romanList = new ArrayList<>();

        
        for (int num : nums) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < values.length && num > 0; i++) {
                while (num >= values[i]) {
                    num -= values[i];
                    sb.append((symbols[i]));
                }
            }
            romanList.add(sb.toString());
        }
        System.out.println(romanList.toString());
    }
}
