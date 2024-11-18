class Trie {
    class Node {
        boolean ends;
        Node[] entries;
        Node() {
            this.entries = new Node[27];
            ends = false;
        }
    }
    //Dummy head for start
    Node head;
    public Trie() {
        head = new Node();
    }
    
    public void insert(String word) {
        Node curr = head;
        for(char c: word.toLowerCase().toCharArray()) {
            //Case 1 start
            int idx = c - 'a';
            if(curr.entries[idx] == null) {
                curr.entries[idx] = new Node();
                curr = curr.entries[idx];
            } else {
                curr = curr.entries[idx];
            };
        }
        curr.ends = true;
    }
    
    public boolean search(String word) {
        Node curr = head;
        for(char c: word.toLowerCase().toCharArray()) {
            int idx = c - 'a';
            if(curr.entries[idx] == null) return false;
            curr = curr.entries[idx];
        }
        return curr.ends;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = head;
        for(char c: prefix.toLowerCase().toCharArray()) {
            int idx = c - 'a';
            if(curr.entries[idx] == null) return false;
            curr = curr.entries[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */