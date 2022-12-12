package implementation.practice;

import datastructure.triewithmap.*;

public class TrieImpl {
    public static void main(String[] args){
        TrieImpl trieImpl = new TrieImpl();
        trieImpl.operateTrie();
    }

    private void operateTrie(){
        Trie trie = new Trie();

        trie.insert("Shraddha");
        trie.insert("suhas");

        System.out.println("=====1"+ trie.search("suhas"));
        trie.delete("suhas");
        System.out.println("=====2"+ trie.search("suhas"));

        trie.insert("Arun");
        System.out.println("=====3"+ trie.search("Arun"));
        trie.modify("Arun", "Sinni");
        System.out.println("=====4"+ trie.search("Arun"));
        System.out.println("=====5"+ trie.search("Sinni"));
    }
}
