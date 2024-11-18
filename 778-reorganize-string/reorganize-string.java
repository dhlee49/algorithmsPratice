class Solution {
    public String reorganizeString(String s) {
        int size = s.length();
        HashMap<Character, Integer> frequency = new HashMap();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
        int max = 0;
        for(Character c: s.toCharArray()) {
            frequency.computeIfPresent(c, (k, v) -> v + 1);
            frequency.putIfAbsent(c, 1);
            if(max < frequency.get(c)) max = frequency.get(c);
        }
        //Base case. Too many single chars we cant do it
        if(max > (size + 1) / 2) return "";

        //Build the MaxHeap;
        for(Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            maxHeap.add(entry);
        }
        //Build string now
        StringBuffer ans = new StringBuffer();
        Map.Entry<Character, Integer> prev = null;
        Map.Entry<Character, Integer> curr = null;
        while(!maxHeap.isEmpty()) {
            curr = maxHeap.poll();
            ans.append(curr.getKey());
            curr.setValue(curr.getValue() - 1);
            if(prev != null) {
                maxHeap.offer(prev);
            }
            prev = curr;
            if(curr.getValue() == 0) prev = null;
        }
        return ans.toString();
    }
}