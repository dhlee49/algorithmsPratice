class Solution {
    public int maximumLength(String s) {
        int size = s.length();
        int max = -1;
        Map<String, Integer> counter = new HashMap();
        for(int i = 0; i < size; i++) {
            for(int j = i + 1; j <= size; j++) {
                if(s.charAt(j - 1) != s.charAt(i)) break;
                String curr = s.substring(i,j);
                if(counter.containsKey(curr)) {
                    int count = counter.get(curr) + 1;
                    counter.put(curr, count);
                    if(count > 2) {
                        System.out.println(curr);
                        max = Math.max(curr.length(), max);
                    }
                } else {
                    counter.put(curr, 1);
                }
            }
        }
        return max;
    }
}