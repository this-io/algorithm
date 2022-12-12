package implementation.medium;

public class ReverseWordsInAString {
	public static void main(String[] args) {
		ReverseWordsInAString r = new ReverseWordsInAString();
		System.out.println(r.reverseWords("a good   example"));
	}

	public String reverseWords(String s) {
		String cleanedString = s.trim();
		boolean isSpace = false;
		StringBuilder theBuilder = new StringBuilder();
		String [] cleanedStringArray = cleanedString.split(" ");
		for(int i=cleanedStringArray.length-1; i>=0; i--) {
			if(!cleanedStringArray[i].isEmpty()) {
				theBuilder.append(" "+cleanedStringArray[i].trim());
				System.out.println(i + ":" +cleanedStringArray[i]);
			}

		}
		return theBuilder.toString().trim();
	}
}
