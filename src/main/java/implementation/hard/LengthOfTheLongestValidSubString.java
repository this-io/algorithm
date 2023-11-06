package implementation.hard;

import java.util.*;

public class LengthOfTheLongestValidSubString {
    public static void main(String[] args) {
        LengthOfTheLongestValidSubString l = new LengthOfTheLongestValidSubString();
        String[] arr =  {"aaa","cb" };
        System.out.println(l.longestValidSubstring("cbaaaabc", new ArrayList<>(Arrays.asList(arr))));
    }

    public int longestValidSubstring(String word, List<String> forbidden) {
        int left =0 , right = left +1;
        List<String> perms = new ArrayList<>();
        Set<String> deDupedForbidden = new HashSet();
        int maxLength = 0;

        for(String a : forbidden) {
            maxLength = Math.max(maxLength , a.length());
            deDupedForbidden.add(a);
        }

        int ans = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i< word.length(); i++) {
            char ch = word.charAt(i);
            sb.append(ch+"");

            int len = sb.length();

            for(int j = len-1; j >= Math.max(0, len-maxLength); j-- ) {
                String s = sb.substring(j);
                if(deDupedForbidden.contains(s)) {
                    sb.delete(0, j+1);
                    break;
                }
            }
            ans = Math.max(sb.length(), ans);
        }

        System.out.println("Max : "+ ans);
        return ans;
    }
}
