import java.util.*;

public class AllTwoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15, 5, 4 };
        int target = 9;
        List<int[]> result = twoSum(nums, target);
        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }
    }

    public static List<int[]> twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                list.add(new int[] { map.get(complement), nums[i] });
            }

            map.put(nums[i], map.get(complement) != null ? map.get(complement) : nums[i]);
        }
        return list;

    }
}