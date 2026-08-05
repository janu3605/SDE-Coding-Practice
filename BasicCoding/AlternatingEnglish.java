
public class AlternatingEnglish {

    public static void main(String[] args) {
        String str = "aeotialiknsdf";

        String vow = "aeiou";
        StringBuilder vowels = new StringBuilder();
        StringBuilder consonants = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (vow.contains(c + "")) {
                vowels.append(c);
            } else {
                consonants.append(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vowels.length(); i++) {
            sb.append(consonants.charAt(i));
            sb.append(vowels.charAt(i));
        }
        System.out.println(sb.toString());

    }
}
