package main.datastructure.trie;

public class Trie {
    final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public int query(final String q){
        TrieNode current = root;
        for(int i = 0; i< q.length(); i++){
            if(current == null){
                return 0;
            }
            current = current.next(q.charAt(i));
        }
        return current.terminating;
    }

    public void insert(final String ins){
        TrieNode current = root;
        System.out.println("This is error === " + ins);
        for(int i=0; i<ins.length(); i++){
            if(current.trieNodes[ins.charAt(i) - 'a'] == null){
                current.trieNodes[ins.charAt(i) - 'a'] = new TrieNode();
            }
            current = current.next(ins.charAt(i));
        }
        current.terminating++;
    }

    public void delete(final String del){
        TrieNode current = root;
        for(int i = 0; i< del.length(); i++){
            if(current == null){
                throw new RuntimeException();
            }
            current = current.next(del.charAt(i));
        }

        if(current.terminating != 0){
            current.terminating--;
        } else {
            throw new RuntimeException();
        }

    }

    public void update(final String previous, final String updateWith){
        delete(previous);
        insert(updateWith);
    }
}