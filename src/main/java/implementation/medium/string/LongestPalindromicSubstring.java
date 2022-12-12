package implementation.medium.string;

public class LongestPalindromicSubstring {
  public static void main(String[] args) {
    LongestPalindromicSubstring l = new LongestPalindromicSubstring();
    System.out.println(l.longestPalindrome("babad"));
    System.out.println(l.longestPalindrome("cbbd"));
  }

  public String longestPalindrome(String s) {
    String result = "";
    int resultLen = 0;

    for (int i = 0; i < s.length(); i++) {
      int left = i, right = i;

      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        if ((right - left + 1) > resultLen) {
          result = s.substring(left, right + 1);
          resultLen = right - left + 1;
        }

        left--;
        right++;
      }

      left = i;
      right = i + 1;

      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        if((right - left + 1) > resultLen) {
          result = s.substring(left, right + 1);
          resultLen = right - left + 1;
        }
        left--;
        right++;
      }
    }
    return result;
  }
}

