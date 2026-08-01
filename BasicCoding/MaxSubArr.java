package BasicCoding;

class MaxSubArr {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = idxkadane(arr);
        System.out.println(maxSum);
    }
// 1. Kadanes ALgo

    public static int kadane(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    //  kadanes with indices
    public static int idxkadane(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];

        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum += arr[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
        System.out.println("Start index: " + start + ", End index: " + end);
        return maxSum;
    }
}
