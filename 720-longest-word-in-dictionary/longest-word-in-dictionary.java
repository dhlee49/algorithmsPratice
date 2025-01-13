class Solution {
    public String longestWord(String[] words) {
        Map<String, List<String>> adjGraph = new HashMap();
        Set<String> wordSet = new HashSet();
        wordSet.addAll(Arrays.asList(words));
        Set<String> starter = new HashSet();
        for(String word : words) {
            if(word.length() == 1) {
                starter.add(word);
                continue;
            }
            String shorterWord = word.substring(0, word.length() - 1);
            if(wordSet.contains(shorterWord)) {
                adjGraph.putIfAbsent(shorterWord, new LinkedList());
                adjGraph.get(shorterWord).add(word);
            } 
        }
        String biggest = "";
        for(String startWord : starter) {
            String curr = bfs(startWord, adjGraph);
            if(curr.length() > biggest.length()) {
                biggest = curr;
                continue;
            }
            if(curr.length() == biggest.length() && biggest.compareTo(curr) > 0) biggest = curr;
        }
        return biggest;
    }
    private String bfs(String startWord, Map<String, List<String>> adjGraph) {
        String ans = startWord;
        Queue<String> bfsQ = new LinkedList();
        bfsQ.offer(startWord);
        while(!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            for(int i = 0; i < size; i++) {
                List<String> currList = adjGraph.get(bfsQ.poll());
                if(currList == null) continue;
                for(String next : currList) {
                    if(next.length() > ans.length()) {
                        ans = next;
                    } else if(ans.compareTo(next) > 0) ans = next;
                    bfsQ.offer(next);
                }
            }
        }
        return ans;
    }
}