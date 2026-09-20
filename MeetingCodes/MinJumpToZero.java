package MeetingCodes;

import java.util.*;

public class MinJumpToZero {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 0, 3, 4 };
        int start = 3;

        int n = arr.length;
        boolean[] visited = new boolean[arr.length];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] { start, 0 });
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int index = current[0];
            int jumps = current[1];

            int[] nextIdx = { index + arr[index], index - arr[index] };

            for (int next : nextIdx) {
                if (next >= 0 && next < n && !visited[next]) {
                    if (arr[next] == 0) {
                        System.out.println(jumps + 1);
                        return;
                    }
                    queue.add(new int[] { next, jumps + 1 });
                    visited[next] = true;
                }
            }
        }
        System.out.println(-1);
    }
}
