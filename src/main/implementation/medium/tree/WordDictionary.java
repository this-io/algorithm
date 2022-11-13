package main.implementation.medium.tree;


public class WordDictionary {

  /** Initialize your data structure here. */
  TrieNode root;
  public WordDictionary() {
    root = new TrieNode();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    TrieNode ws = root;
    for (int i = 0; i < word.length(); i++){
      char c = word.charAt(i);
      if (ws.children[c - 'a'] == null){
        ws.children[c - 'a'] = new TrieNode();
      }
      ws = ws.children[c - 'a'];
    }
    ws.isword = true;
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    char[] s = word.toCharArray();
    TrieNode ws = root;
    return helper(s, 0, ws);
  }

  private boolean helper(char[] s, int j, TrieNode ws){
    if (j >= s.length){
      return ws.isword;
    }

    if(s[j] != '.'){
      if(ws.children[s[j]-'a'] == null){
        return false;
      }
      else{
        return helper(s, j+1, ws.children[s[j]-'a']);
      }
    }
    else{
      for(char c = 'a'; c <= 'z'; c++){
        if(ws.children[c-'a'] !=null){
          if(helper(s, j+1, ws.children[c-'a'])){
            return true;
          }
        }
      }
      return false;
    }
  }
}

class TrieNode{
  boolean isword;
  TrieNode[] children;
  public TrieNode(){
    children = new TrieNode[26];
  }
}