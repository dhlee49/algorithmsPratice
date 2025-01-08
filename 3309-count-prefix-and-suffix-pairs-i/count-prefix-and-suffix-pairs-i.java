class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int size = words.length;
        int cnt = 0;
        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                if(words[j].length() < words[i].length()) continue;
                if(words[j].startsWith(words[i]) && words[j].endsWith(words[i])) cnt++; 
            }
        }
        return cnt;
    }
}