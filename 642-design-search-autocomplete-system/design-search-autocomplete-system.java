class AutocompleteSystem {
    class Trie {
        Map<Character, Trie> children;
        Map<String, Integer> hotness;
        public Trie() {
            children = new HashMap();
            hotness = new HashMap();
        
        }
        public void insert(String s, int freq) {
            Trie curr = this;
            for(char c : s.toCharArray()) {
                curr.children.putIfAbsent(c, new Trie());
                curr.children.get(c).hotness.putIfAbsent(s, 0);
                curr.children.get(c).hotness.computeIfPresent(s, (k, v) -> v + freq);
                curr = curr.children.get(c);
            }
        }
        public List<String> get(String s) {
            return get(s, 0);
        }
        public List<String> get(String s, int idx) {
            if(idx == s.length()) return getTop3();
            Trie child = children.get(s.charAt(idx));
            List<String> ans = new LinkedList();
            if(child == null) return ans;
            return child.get(s, idx + 1);
        }
        private List<String> getTop3() {
            List<String> ans = new ArrayList(this.hotness.keySet());
            System.out.println("");
            System.out.println("List");

            for(Map.Entry<String, Integer> s : hotness.entrySet()) System.out.print(s.getKey() + "  & " + s.getValue() + " || ");
            ans.sort((a, b) -> {
                int x = this.hotness.get(a);
                int y = this.hotness.get(b);
                if(x == y) {
                    return a.compareTo(b);
                }
                return y - x;
            });
            if(ans.size() > 3) return ans.subList(0,3);
            return ans;
        }
    }
    private Trie root;
    private StringBuilder curr;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        curr = new StringBuilder();
        for(int i = 0; i < times.length; i++) {
            root.insert(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        if(c == '#') {
            List<String> ans = new LinkedList();
            root.insert(curr.toString(), 1);
            curr = new StringBuilder();
            return ans;
        }
        curr.append(c);
        return root.get(curr.toString());
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */