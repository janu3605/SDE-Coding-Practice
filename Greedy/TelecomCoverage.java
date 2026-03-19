/*
     MODEL: Greedy
     PROBLEM: Telecom Tower Coverage
     A telecom company wants to place towers to cover a set of cities along a straight line.
     Each tower has a fixed coverage radius. Determine the minimum number of towers needed to
     cover all cities ,towers to sit directly on top of an existing house.

     INPUT:
     - cityPositions (array of integers, sorted or unsorted)
     - towerRadius (integer)

         n = 5, k = 2, houses = [1, 2, 5, 8, 10]


     OUTPUT:
     - Return an int representing the minimum number of towers required.
         2

 */

import java.util.*;

public class TelecomCoverage {

    public static void TowerPlaced(int[] houses, int coverage) {
        int i = 0;
        ArrayList<Integer> towerLoc = new ArrayList<>();

        while (i < houses.length) {
            int startHouse = houses[i];

            while (i < houses.length && houses[i] <= startHouse + coverage) {
                i++;
            }
            int towerloc = houses[i - 1];
            towerLoc.add(towerloc);

            while (i < houses.length && houses[i] <= towerloc + coverage) {
                i++;
            }
        }
        System.out.println(towerLoc);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] houses = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(houses);

        int coverage = sc.nextInt();

        TowerPlaced(houses, coverage);

    }

}
