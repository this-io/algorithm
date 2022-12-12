package datastructure.triewithmap;

import datastructure.triewithmap.TrieNode;

public class Trie {

    //Only once instance of root should be present.
    private final TrieNode root;

    //Constructor
    public Trie(){
        root = new TrieNode();
    }

    /**
     * @desc Method inserts the word in to Trie.
     * @param word String
     * */
    public void insert(String word){
        TrieNode current = root;

        for(int i=0; i< word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = (current.children.containsKey(ch)) ? current.children.get(ch) : null;
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.isEndOfWord = true;
    }

    /**
     * @desc Method to search a word in trie.
     * @param word string
     * @return boolean to represent whether word was found or not.
     * */
    public boolean search(String word){
        TrieNode current = root;

        for(int i=0; i< word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = (current.children.containsKey(ch)) ? current.children.get(ch) : null;
            if(node == null){
                return false;
            }
            current = node;
        }
        return current.isEndOfWord;
    }

    /**
     * @desc
     * @param
     * */
    public void delete(String word){
        delete(root, word, 0);
    }

    /**
     * @desc
     * @param
     * @return boolean
     * */
    private boolean delete(TrieNode current, String word, int index){
        if(index == word.length()){
            if(!current.isEndOfWord){
                return false;
            }
            current.isEndOfWord = false;
            return current.children.size() == 0;
        }

        char ch = word.charAt(index);
        TrieNode node =  current.children.get(ch);
        if(node == null){
            return false;
        }

        boolean shouldDeleteNode = delete(node, word, index+1);

        if(shouldDeleteNode){
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }

    /**
     * @desc
     * @param
     * */
    public void modify(String wordToChange, String changeWithWord){
        if(wordToChange.isEmpty() || changeWithWord.isEmpty()){
            System.out.println("Arguments cannot be empty");
        }

        if(search(wordToChange)){
            delete(wordToChange);
            insert(changeWithWord);
        } else {
            System.out.println("Word to modify does not exist.");
        }
    }
}
