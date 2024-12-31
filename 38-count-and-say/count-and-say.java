class Solution {
    public String countAndSay(int n) {
        return countToString(getRecursiveMap(n));
    }
    private List<int[]> getRecursiveMap(int n) {
        if(n == 1) {
            return null;
        }
        String curr = countToString(getRecursiveMap(n - 1));
        char prev = '\0';
        int cnt = 0;
        List<int[]> result = new LinkedList();
        for(char c: curr.toCharArray()) {
            if(prev == '\0') {
                prev = c;
                cnt = 1;
                continue;
            }
            if(c != prev) {
                result.add(new int[] { cnt, prev - '0' });
                prev = c;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        result.add(new int[] { cnt, prev - '0'});
        return result;
    }
    private String countToString(List<int[]> curr) {
        if(curr == null) return "1";
        StringBuilder sb = new StringBuilder();
        for(int[] x: curr) {
            sb.append(x[0]);
            sb.append(x[1]);
        }
        return sb.toString();
    }
}