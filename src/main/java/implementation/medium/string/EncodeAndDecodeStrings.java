package implementation.medium.string;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
  public static void main(String[] args) {
    EncodeAndDecodeStrings e = new EncodeAndDecodeStrings();

  }

  /*
   * @param strs: a list of strings
   * @return: encodes a list of strings to a single string.
   */
  public String encode(List<String> strs) {
    String encoded = "";
    // write your code here
    for (String s : strs) {
      encoded += s.length() + "#" + s;
    }
    return encoded;
  }

  /*
   * @param str: A string
   * @return: dcodes a single string to a list of strings
   */
  public List<String> decode(String str) {
    // write your code here
    List<String> result = new ArrayList<>();
    int i = 0;

    while (i < str.length()) {
      int j = i;
      while (str.charAt(j) != '#') {
        j++;
      }

      int length = Integer.valueOf(str.substring(i, j));
      result.add(str.substring(j + 1, j + 1 + length));
    }
    return result;
  }

}
