package main.implementation.medium;

import main.datastructure.triewithmap.Trie;

import java.util.HashMap;
import java.util.Map;

public class AddBoldTag {
	String prefix = "<b>";
	String suffix = "</b>";

	public static void main(String[] args) {
		AddBoldTag abt = new AddBoldTag();
		String result = abt.addBoldTag("aaabbcc", new String[]{"aaa", "aab", "bc"});
		System.out.println(result);
	}

	public String addBoldTag(String s, String[] dict) {
		if (s == null) {
			return "";
		}

		int end = -1;
		StringBuilder sb = new StringBuilder();
		Trie trie = new Trie();

		for (String word : dict) {
			trie.insert(word);
		}

		for (int i = 0; i < s.length(); i++) {
			if (end >= i) {
				end = Math.max(end, trie.search(s, i));
			} else {
				end = trie.search(s, i);
				if (end > i) {
					sb.append(prefix);
				}
			}
			System.out.println(trie.search(s, i));
			if (end == i) sb.append(suffix);
			sb.append(s.charAt(i));
		}
		if (end == s.length()) {
			sb.append(suffix);
		}
		return sb.toString();
	}

	public static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			if (word == null) {
				return;
			}
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (!node.map.containsKey(c)) {
					node.map.put(c, new TrieNode());
				}
				node = node.map.get(c);
			}
			node.end = true;
		}

		public int search(String s, int index) {
			TrieNode node = root;
			int result = -1;
			while (node != null && index < s.length()) {
				node = node.map.getOrDefault(s.charAt(index++), null);
				if (node != null && node.end == true) {
					result = index;
				}
			}
			return result;
		}
	}

	public static class TrieNode {
		Map<Character, TrieNode> map;
		boolean end;

		public TrieNode() {
			map = new HashMap<>();
			end = false;
		}
	}
}
