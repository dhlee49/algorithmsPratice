class Solution {
    public int maxVowels(String s, int k) {
        int curr = 0;
        for(int i = 0; i < k; i++) if(checkVowel(s.charAt(i))) curr++;
        int max = curr;
        for(int i = 0; i < s.length() - k; i++) {
            char c = s.charAt(i + k);
            char prev  = s.charAt(i);
            if(checkVowel(c)) curr++;
            if(checkVowel(prev)) curr--;
            max = Math.max(curr, max);
        }
        return max;
    }
    private boolean checkVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}