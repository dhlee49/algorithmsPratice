class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> newMap = new HashMap(); 
        for(String s: strs) {
            char[] sequence = s.toCharArray();
            Arrays.sort(sequence);
            String key = new String(sequence);
            if(newMap.containsKey(key)) {
                newMap.get(key).add(s);
            } else {
                List<String> cur = new LinkedList();
                cur.add(s);
                newMap.put(key, cur);
            }
        }
        return new LinkedList(newMap.values());
    }
}