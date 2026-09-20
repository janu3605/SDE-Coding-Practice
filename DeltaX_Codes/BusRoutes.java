package DeltaX_Codes;

import java.util.*;

public class BusRoutes {
    public static void main(String[] args) {
        int[][] routes = { { 1, 2, 7 }, { 3, 6, 7 } };
        int source = 1;
        int target = 6;
        int result = numBusesToDestination(routes, source, target);
        System.out.println(result);
    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int routeId = 0; routeId < routes.length; routeId++) {
            for (int stop : routes[routeId]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(routeId);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visitedRoutes = new HashSet<>();

        for (int routeId = 0; routeId < routes.length; routeId++) {
            for (int stop : routes[routeId]) {
                if (stop == source) {
                    visitedRoutes.add(routeId);
                    queue.offer(routeId);
                    break;
                }
            }
        }

        int buses = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int routeId = queue.poll();

                for (int stop : routes[routeId]) {
                    if (stop == target) {
                        return buses + 1;
                    }
                }

                for (int stop : routes[routeId]) {
                    for (int nextRoute : stopToRoutes.getOrDefault(stop, Collections.emptyList())) {
                        if (!visitedRoutes.contains(nextRoute)) {
                            visitedRoutes.add(nextRoute);
                            queue.offer(nextRoute);
                        }
                    }
                }
            }
            buses++;
        }

        return -1;
    }
}