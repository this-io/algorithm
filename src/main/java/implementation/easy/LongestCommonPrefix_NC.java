package implementation.easy;

public class LongestCommonPrefix_NC {

	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		for (int i = 0; i < strs[0].length() ; i++){
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j ++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
}
/*
  0 1 2 3 4 5
0 f l o w e r
1 f l o w
2 f l i g h t
*/