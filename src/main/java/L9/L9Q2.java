package L9;

import java.util.ArrayList;

public class L9Q2 {
    public static void main(String[] args) {
        ArrayList<String> permutations = permute("abc");
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static ArrayList<String> permute(String str) {
        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char first = str.charAt(0);
        String remainder = str.substring(1);
        ArrayList<String> words = permute(remainder);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                permutations.add(insertCharAt(word, first, i));
            }
        }
        return permutations;
    }

    public static String insertCharAt(String str, char c, int i) {
        String start = str.substring(0, i);
        String end = str.substring(i);
        return start + c + end;
    }
}
