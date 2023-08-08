package implementation.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        String s = "catsandog";
        List<String> dict = Arrays.asList(new String[] {"cats","dog","sand","and","cat"});
        System.out.println(w.wordBreak(s, dict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < wordDict.size(); j++) {
                String currentWord = wordDict.get(j);
                if (i + currentWord.length() <= s.length() && s.substring(i, i + currentWord.length()).equals(currentWord)) {
                    dp[i] = dp[i + currentWord.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}
