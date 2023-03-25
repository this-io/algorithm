package implementation.medium.string;

import java.util.*;

public class OptimalPartitionOfString {
    public static void main(String[] args) {
        OptimalPartitionOfString o = new OptimalPartitionOfString();
        System.out.println(o.partitionString("hdklqkcssgxlvehva"));
    }

    /*public int partitionString(String s) {
        if (s.isBlank()) {
            return 0;
        }
        Map<Character, Integer> theCharToCount = new HashMap<>();
        int keepCounter = 0;
        for (char c : s.toCharArray()) {
            if (theCharToCount.containsKey(c)) {
                int v = theCharToCount.getOrDefault(c, 0) + 1;
                theCharToCount.put(c, v);
            } else {
                theCharToCount.put(c, 1);
            }
            keepCounter++;
        }
        List<String> theResult = new ArrayList<>();
        boolean isAllowedToLoop = true;
        while (isAllowedToLoop) {
            String k = "";
            for (char c : theCharToCount.keySet()) {
                if (theCharToCount.get(c) == 0) {
                    continue;
                }
                k = k + c;
                theCharToCount.put(c, theCharToCount.get(c) - 1);
                keepCounter--;
            }
            theResult.add(k);
            if (keepCounter == 0) {
                isAllowedToLoop = false;
            }
        }
        System.out.println(theResult);
        return theResult.size();
    }*/

    /*public int partitionString(String s) {
        if (s.isBlank()) {
            return 0;
        }

        //List<String> theResult = new ArrayList<>();
        Map<String, String> stopGap = new HashMap<>();
        StringBuilder theBuilder = new StringBuilder(s);
        String intermediate = "";
        int ans = 0;
        while(!theBuilder.toString().isBlank()) {
            String temp = theBuilder.substring(0, 1);
            if(stopGap.containsKey(temp)) {
                ans++;
                intermediate = "";
                stopGap.clear();
            } else {
                theBuilder.deleteCharAt(0);
                intermediate = intermediate + temp;
                stopGap.put(temp, temp);
            }
            if (theBuilder.toString().isBlank() && !intermediate.isBlank()) {
                ans++;
            }
        }
        return ans;
    }*/

    public int partitionString(String s) {
        if (s.isBlank()) {
            return 0;
        }
        int res = 0;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); ++i) {
            if (set.contains(s.charAt(i))) {
                set.clear();
                res++;
            }
            set.add(s.charAt(i));
        }
        return set.size() == 0 ? res : res + 1;
    }
}
