package main.implementation.medium.string;

public class PalindromicSubstrings {
  public static void main(String[] args) {
    PalindromicSubstrings p = new PalindromicSubstrings();
    System.out.println(p.countSubstrings("aaa"));
  }

  public int countSubstrings(String s) {
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
      int left = i, right = i;

      result = theFunction(s, result, left, right);

      left = i;
      right = i + 1;

      result = theFunction(s, result, left, right);
    }
    return result;
  }

  private static int theFunction(String s, int result, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      result++;
      left--;
      right++;
    }

    return result;
  }
}
