package implementation.easy;

import java.util.HashMap;
import java.util.Map;

/*
	There is a special keyboard with all keys in a single row.
	Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25).
	Initially, your finger is at index 0. To type a character, you have to move your finger to the index of the
	desired character. The time taken to move your finger from index i to index j is |i - j|.
	You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.

	Example 1:
	Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
	Output: 4
	Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b' then to 0 again to write 'a'.
	Total time = 2 + 1 + 1 = 4.

	Example 2:
	Input: keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
	Output: 73
* */

public class SingleRowKeyBoard {
	public static void main(String[] args) {
		SingleRowKeyBoard s = new SingleRowKeyBoard();
		System.out.println(s.calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
	}

	private int calculateTime(String keyboard, String word) {
		Map<Character, Integer> keyBoardHash = keyboardToHashMap(keyboard);
		int result = 0;
		char previous = '.';
		boolean first = true;
		for(char keyStroke : word.toCharArray()) {
			if(keyBoardHash.containsKey(keyStroke)) {
				if(first) {
					first = false;
					result += keyBoardHash.get(keyStroke);
				} else {
					result += Math.abs(keyBoardHash.get(previous) - keyBoardHash.get(keyStroke));
				}
				previous = keyStroke;
			}
		}
		return result;
	}

	private static Map<Character, Integer> keyboardToHashMap(String keyboard) {
		Map<Character, Integer> keyBoardHash = new HashMap<>();
		int keyIndex = 0;
		for(char key : keyboard.toCharArray()) {
			keyBoardHash.put(key, keyIndex);
			keyIndex++;
		}
		return keyBoardHash;
	}

	private int calculateTime1(String keyboard, String word) {
		int[] keyIndices = new int[26];

		// Get the index for each key.
		for (int i = 0; i < keyboard.length(); i++) {
			keyIndices[keyboard.charAt(i) - 'a'] = i;
		}

		// Initialize previous index as starting index = 0.
		int prev = 0;
		int result = 0;

		// Calculate the total time.
		for (char c : word.toCharArray()) {
			// Add the distance from previous index
			// to current letter's index to the result.
			result += Math.abs(prev - keyIndices[c - 'a']);

			// Update the previous index to current index for next iteration.
			prev = keyIndices[c - 'a'];
		}
		return result;
	}
}
