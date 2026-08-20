package PowerCoding;

public class BoundedHammingDist {
    public static void main(String[] args) {
        int[] tickets = { 1, 2, 3, 4 };
        int mask = 3;
        int k = 3;

        // for (int i = 0; i < tickets.length; i++) {
        // for (int j = i + 1; j < tickets.length; j++) {
        // int hammingDist = Integer.bitCount((tickets[i] ^ mask) + (tickets[j] ^
        // mask));
        // if (hammingDist <= k) {
        // System.out.println(
        // "Tickets " + tickets[i] + " and " + tickets[j] + " have Hamming distance " +
        // hammingDist);
        // }
        // }
        // }

        System.out.println(countValidPairs(tickets, mask, k));
    }

    public static long countValidPairs(int[] tickets, int mask, int K) {
        if (tickets == null || tickets.length < 2)
            return 0;

        // Step 1: Frequency array for bit distances (0 to 32 bits)
        // Use long for frequencies to avoid integer overflow during pair multiplication
        long[] freq = new long[33];

        // Step 2: Populate frequencies in a single O(N) pass
        for (int ticket : tickets) {
            int dist = Integer.bitCount(ticket ^ mask);
            freq[dist]++;
        }

        long totalPairs = 0;

        // Step 3: Count valid pairs in O(32^2) = O(1) constant time
        for (int d1 = 0; d1 <= 32; d1++) {
            if (freq[d1] == 0)
                continue;

            for (int d2 = d1; d2 <= 32; d2++) {
                if (freq[d2] == 0)
                    continue;

                // Condition check: combined distance < K
                if (d1 + d2 < K) {
                    if (d1 == d2) {
                        // Combination formula: n * (n - 1) / 2 for pairs with same distance
                        totalPairs += (freq[d1] * (freq[d1] - 1)) / 2;
                    } else {
                        // Product rule: freq[d1] * freq[d2] for distinct distance pairs
                        totalPairs += freq[d1] * freq[d2];
                    }
                }
            }
        }
        return totalPairs;
    }
}
