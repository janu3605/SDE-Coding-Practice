package DeltaX_Codes;


public class ValidMobile {
    public static void main(String[] args) {
        String inpt = "+91 9252139820"; // Example input
        if (isValidMobile(inpt)) {
            System.out.println("Valid mobile number");
        } else {
            System.out.println("Invalid mobile number");
        }
    }

    public static boolean isValidMobile(String mobile) {
        // Check if the mobile number is exactly 10 digits
        return mobile.matches("^(\\+91 )?[6-9]\\d{9}$");
    }
}
