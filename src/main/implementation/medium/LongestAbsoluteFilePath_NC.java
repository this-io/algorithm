package main.implementation.medium;

public class LongestAbsoluteFilePath_NC {

	public static void main(String[] args) {
		LongestAbsoluteFilePath_NC a = new LongestAbsoluteFilePath_NC();
		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		a.lengthLongestPath(input);
	}

	public int lengthLongestPath(String input) {
		if(input.isEmpty()) {
			return 0;
		}

		return 0;
	}
}
