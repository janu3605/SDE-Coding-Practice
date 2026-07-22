
public class ShortestHops {

    public static void main(String[] args) {
        int[] input = new int[]{2, 5, 4, 7, 6};
        int shortestHops = findShortestHops(input);
        System.out.println("The shortest hops is: " + shortestHops);
    }

    public static int findShortestHops(int[] input) {
        int index = 0;
        int hop = 1;
        while (hop < input.length) {
            if (index + hop > input.length) {
                return hop;
            }
            if (input[index + hop] % 2 != 0) {
                index = 0;
                hop++;
            } else {
                index = index + hop;
            }
        }
        return -1;
    }
}
