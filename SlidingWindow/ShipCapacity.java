/**
 * MODEL: Binary Search (On Answer Space)
 * * PROBLEM: The Cargo Ship Capacity
 * You are the logistics manager for a busy seaport. You have a massive backlog of 
 * shipping containers that need to be transported across the ocean. The weights of 
 * these containers are given in an array, and they MUST be loaded onto the ship in 
 * the exact order they are listed.
 * * You have exactly `D` days to ship all the containers. You need to rent a cargo ship 
 * to do this. The rental cost is based on the ship's maximum daily weight capacity. 
 * To save the company money, you need to find the absolute MINIMUM weight capacity 
 * the ship can have while still finishing the job within `D` days.
 * * * INPUT: 
 * - weights (an array of integers representing container weights)
 * - days (an integer representing the deadline)
 * * OUTPUT: 
 * - An integer representing the minimum daily weight capacity required.
 * * EXAMPLE 1:
 * Input: weights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], days = 5
 * Output: 15
 * Explanation: A ship capacity of 15 ships everything in 5 days:
 * Day 1: 1, 2, 3, 4, 5 (total 15)
 * Day 2: 6, 7 (total 13)
 * Day 3: 8 (total 8)
 * Day 4: 9 (total 9)
 * Day 5: 10 (total 10)
 * * EXAMPLE 2:
 * Input: weights = [3, 2, 2, 4, 1, 4], days = 3
 * Output: 6
 * Explanation: A ship capacity of 6 ships everything in 3 days:
 * Day 1: 3, 2 (total 5)
 * Day 2: 2, 4 (total 6)
 * Day 3: 1, 4 (total 5)
 */

// Time Complexity: O(N log M) where N is the number of weights and M is the sum of weights (the maximum possible capacity).

import java.util.*;
public class ShipCapacity {
    
    public static int shipWithinDays(int[] weights, int days) {
        
        int low = 0;
        int high= 0;

        for(int wt : weights){
            low = Math.max(low, wt);
            high += wt;
        }

        int res = high;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int daysCount=1;
            int currLoad=0;

            for(int wt : weights){
                if(currLoad + wt > mid){
                    currLoad = wt;
                    daysCount++;
                }
                else currLoad += wt;
            }
            if(daysCount <= days){
                res = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inpt = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int days = sc.nextInt();
        System.out.println(shipWithinDays(inpt, days));
    }
}