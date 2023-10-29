package implementation.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String inp = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring(inp));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.isBlank()) {
            return 0;
        }

        int i = 0;
        int result = 0;
        HashMap<Character, Integer> theMap = new HashMap<>();

        for(int j=0; j<s.length(); j++) {
            char c = s.charAt(j);
            if(theMap.containsKey(c)) {
                i = Math.max(i, theMap.get(c) + 1);
            }

            result = Math.max(result, j - i + 1);
            theMap.put(c, j);
        }

        return result;
    }
}
