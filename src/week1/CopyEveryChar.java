package week1;

/**
 * Created by georgipavlov on 23.11.15.
 */
public class CopyEveryChar {
    String copyEveryChar(String input, int k) {
        k=Math.abs(k);
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                for (int j = 0; j < k; j++) {
                    b.append(input.charAt(i));
                }
            } else {
                b.append(input.charAt(i));
            }

        }
        return b.toString();
    }

}
