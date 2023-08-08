package implementation.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence s = new IsSubsequence();
        System.out.println(s.isSubsequence("ab", "baab"));
    }
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty() && t.isEmpty()) {
            return true;
        }
        Map<Integer, Character> theMap = new HashMap<>();
        Set<Character> indvChar = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            theMap.put(i, s.charAt(i));
            indvChar.add(s.charAt(i));
        }
        String repositionedStringFromT = "";
        int posTapper = 0;
        for(int i=0; i<t.length(); i++) {
            if(indvChar.contains(t.charAt(i)) && posTapper < s.length() && theMap.get(posTapper) == t.charAt(i)) {
                repositionedStringFromT += t.charAt(i);
                posTapper++;
            }
        }
        System.out.println(repositionedStringFromT);
        if(s.equals(repositionedStringFromT)) {
            return true;
        }

        return false;
    }
}
