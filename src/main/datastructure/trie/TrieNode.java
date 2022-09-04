package main.datastructure.trie;

public class TrieNode {
    int terminating;
    final TrieNode[] trieNodes = new TrieNode[26];

    public TrieNode next(final char c){
        return trieNodes[c - 'a'];
    }
}
