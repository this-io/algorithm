package implementation.easy.string;

public class BreakPalindrome {
    public static void main(String[] args) {
        BreakPalindrome b = new BreakPalindrome();
        System.out.println(b.breakPalindrome("abccba"));
    }

    public String breakPalindrome(String palindrome) {
        if (palindrome.isEmpty()) {
            return "";
        }

        if (palindrome.length() == 1) {
            return "";
        }
        char[] palindromeA = palindrome.toCharArray();
        for (int i = 0; i < palindromeA.length / 2; i++) {
            if (palindromeA[i] != 'a') {
                palindromeA[i] = 'a';
                return String.valueOf(palindromeA);
            }

        }

        palindromeA[palindrome.length() - 1] = 'b';
        return String.valueOf(palindromeA);
    }
}
