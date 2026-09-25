public class ReduceBill {
    public static void main(String[] args) {
        int n = 13;
        String binstr = Integer.toBinaryString(n);
        System.out.println(binstr);
        int minans = Integer.MAX_VALUE;
        for (int i = 0; i < binstr.length(); i++) {
            char[] temp = binstr.toCharArray();

            if (temp[i] == '0') {
                temp[i] = '1';
            } else {
                temp[i] = '0';
            }
            int num = Integer.parseInt(new String(temp), 2);
            minans = Math.min(minans, num);
        }
        System.out.println(minans);
    }
}
