class Solution {
    public String reorganizeString(String s) {
        int size = s.length();
        HashMap<Character, Integer> frequency = new HashMap();
        for(char c: s.toCharArray()) {
            frequency.computeIfPresent(c, (k, v) -> v + 1);
            frequency.putIfAbsent(c, 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            maxHeap.offer(entry);
        }
        if(maxHeap.peek().getValue() > (size + 1) / 2) return "";
        StringBuilder ansString = new StringBuilder();
        Map.Entry<Character, Integer> curr;
        Map.Entry<Character, Integer> prev = null;
        while(!maxHeap.isEmpty()) {
            //Add current
            curr = maxHeap.poll();
            ansString.append(curr.getKey());
            curr.setValue(curr.getValue() - 1);
            if(prev != null) maxHeap.offer(prev);
            prev = curr;
            if(curr.getValue() == 0) prev = null;
            
        }
        return ansString.toString();
        
    }
}