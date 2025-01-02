class Solution {
    public boolean isDecomposable(String s) {
        boolean usedTwo = false;
        int count = 0;
        char prev = '\0';
        for(char c: s.toCharArray()) {
            if(prev == '\0') {
                prev = c;
                count++;
                continue;
            }
            if(prev == c) {
                count++;
            } else {
                if(count % 3 == 0) {
                    prev = c;
                    count = 1;
                } else if(count % 3 == 2 && !usedTwo) {
                    usedTwo = true;
                    prev = c;
                    count = 1;
                } else {
                    return false;
                }
            }
        }
        if(count % 3 == 0 && usedTwo) return true;
        if(count % 3 == 2 && !usedTwo) return true;
        return false;
    }
}