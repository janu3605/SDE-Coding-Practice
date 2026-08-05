
public class TicketDistribution {

    public static void main(String[] args) {
        int k = 6;
        int[] tickets = {1, 2, 3, 4, 5};
        int you = 3;

        // Calculate the total binary difference from you with all ur friends. 
        int binaryDiff = 0;

        for (int i = 0; i < tickets.length; i++) {
            binaryDiff += Integer.bitCount(tickets[i] ^ you);
        }
        System.out.println(binaryDiff < k ? binaryDiff : "failed");

    }
}
