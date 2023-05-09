package implementation.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntLeetCode {
    private static final Map<Character, Integer> symbolToInt = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public static void main(String[] args) {
        RomanToIntLeetCode r = new RomanToIntLeetCode();
        System.out.println(r.romanToInt("LVIII"));
    }
    public int romanToInt(String s) {
        if(s.isBlank() || s.isEmpty()) {
            return 0;
        }

        char[] inputSinCharArray = s.toCharArray();
        int result = 0;
        for(int i = inputSinCharArray.length - 1; i >= 0; i--) {
            if(inputSinCharArray[i] == 'I') {
                result += symbolToInt.getOrDefault(inputSinCharArray[i], 0);
                if(i + 1 < inputSinCharArray.length) {
                    if(inputSinCharArray[i+1] == 'V' || inputSinCharArray[i+1] == 'X') {
                        result -= 2;
                    }
                }
            } else if(inputSinCharArray[i] == 'V') {
                result += symbolToInt.getOrDefault(inputSinCharArray[i], 0);
            } else if(inputSinCharArray[i] == 'X') {
                result += symbolToInt.getOrDefault(inputSinCharArray[i], 0);
                if(i + 1 < inputSinCharArray.length) {
                    if(inputSinCharArray[i+1] == 'L' || inputSinCharArray[i+1] == 'C') {
                        result -= 20;
                    }
                }
            } else if(inputSinCharArray[i] == 'L') {
                result += symbolToInt.getOrDefault(inputSinCharArray[i], 0);
            } else if(inputSinCharArray[i] == 'C') {
                result += symbolToInt.getOrDefault(inputSinCharArray[i], 0);
                if(i + 1 < inputSinCharArray.length) {
                    if(inputSinCharArray[i+1] == 'D' || inputSinCharArray[i+1] == 'M') {
                        result -= 200;
                    }
                }
            } else if(inputSinCharArray[i] == 'D') {
                result += symbolToInt.getOrDefault(inputSinCharArray[i], 0);
            } else if(inputSinCharArray[i] == 'M') {
                result += symbolToInt.getOrDefault(inputSinCharArray[i], 0);
            }
        }
        return result;
    }
}
