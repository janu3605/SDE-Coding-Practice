package BasicCoding;


public class HarmonicString {

    public static void main(String[] args) {
        String pattern = "abcdefghijklmnopqrstuvwxyz";
        String str = "aababcabcdefg"; // Contains: "a" + "ab" + "abc" + "abcd" -> total length 10

        int i = 0;          // Start index of the current expected chunk
        int targetLen = 1;  // Expected length of current chunk: 1 ('a'), 2 ('ab'), 3 ('abc'), etc.

        int currentTotalLength = 0;
        int maxTotalLength = 0;

        while (i + targetLen <= str.length()) {
            // Extract substring of required length
            String currentChunk = str.substring(i, i + targetLen);
            String expectedChunk = pattern.substring(0, targetLen);

            if (currentChunk.equals(expectedChunk)) {
                // Matched! Add the chunk's length to running total
                currentTotalLength += targetLen;
                maxTotalLength = Math.max(maxTotalLength, currentTotalLength);

                // Move 'i' forward by targetLen to start checking the next block
                i += targetLen;
                targetLen++;
            } else {
                // Match failed! Reset sequence counters
                currentTotalLength = 0;
                targetLen = 1;

                // Move starting pointer 'i' by 1 to test for a new sequence starting at the next position
                i++;
            }
        }

        System.out.println(maxTotalLength); // Output: 10
    }
}
