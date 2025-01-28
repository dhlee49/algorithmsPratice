class Solution {
    class Trie {
        Map<Character, Trie> nextLevel;
        LinkedList<String> currentList;
        public Trie() {
            nextLevel = new HashMap<>();
            currentList = new LinkedList();
        }
        public void addToTrie(char c, String s) {
            nextLevel.putIfAbsent(c, new Trie());
            Trie nextLevelTrie = nextLevel.get(c);
            nextLevelTrie.currentList.add(s);
            //System.out.println(c + "  &&&  " + s);
            //for(String k : currentList) System.out.println(k);
            Collections.sort(nextLevelTrie.currentList);
            while(nextLevelTrie.currentList.size() > 3) nextLevelTrie.currentList.removeLast();
        }
    }
    Trie root = new Trie();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for(String product : products) {
            Trie curr = root;
            for(char c : product.toCharArray()) {
                curr.addToTrie(c, product);
                curr = curr.nextLevel.get(c);
            }
        }
        Trie curr = root;
        List<List<String>> ans = new LinkedList();
        for(char c: searchWord.toCharArray()) {
            if(curr != null) curr = curr.nextLevel.get(c);
            if(curr == null) {
                ans.add(new LinkedList());
                continue;
            }
            ans.add(curr.currentList);

        }
        return ans;
    }
}