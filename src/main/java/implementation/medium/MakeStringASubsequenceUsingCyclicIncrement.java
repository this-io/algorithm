package implementation.medium;

public class MakeStringASubsequenceUsingCyclicIncrement {
    public static void main(String[] args) {
        MakeStringASubsequenceUsingCyclicIncrement m = new MakeStringASubsequenceUsingCyclicIncrement();
        System.out.println(m.canMakeSubsequence("abc", "ad"));
    }

    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0;
        for(char c : str2.toCharArray()) {
            char temp = (c == 'a') ? 'z' : (char)(c - 1);
            while(i < str1.length() && (str1.toCharArray()[i] != c && str1.toCharArray()[i] != temp)) {
                i++;
            }
            if(i >= str1.length()) {
                return false;
            }
        }
        return true;
    }
}
