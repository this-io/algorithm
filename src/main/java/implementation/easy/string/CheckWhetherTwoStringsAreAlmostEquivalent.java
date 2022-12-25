package implementation.easy.string;

import java.util.HashMap;
import java.util.Map;

public class CheckWhetherTwoStringsAreAlmostEquivalent {
    public static void main(String[] args) {
        CheckWhetherTwoStringsAreAlmostEquivalent c = new CheckWhetherTwoStringsAreAlmostEquivalent();
        System.out.println(c.checkAlmostEquivalent("aaaa", "bccb"));
        System.out.println(c.checkAlmostEquivalent("abcdeef", "abaaacc"));
        System.out.println(c.checkAlmostEquivalent("cccddabba", "babababab"));
    }

    public boolean checkAlmostEquivalent(String word1, String word2) {
        if (word1.isEmpty() || word1.isEmpty()) {
            return false;
        }
        Map<Character, Integer> word1Counter = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            word1Counter.put(word1.charAt(i), word1Counter.getOrDefault(word1.charAt(i), 0) + 1);
        }

        Map<Character, Integer> word2Counter = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            word2Counter.put(word2.charAt(i), word2Counter.getOrDefault(word2.charAt(i), 0) + 1);
        }

        for(char i = 'a'; i<='z';i++) {
            int diff = word1Counter.getOrDefault(i, 0) - word2Counter.getOrDefault(i, 0);
            if(diff < -3 || diff > 3) {
                return false;
            }
        }
        return true;
    }
}
