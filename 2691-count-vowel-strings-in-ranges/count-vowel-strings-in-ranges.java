class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] counts = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            if(i == 0) {
                counts[i] = startsWithVowel(words[i]) ? 1 : 0;
            } else {
                counts[i] = counts[i - 1] + (startsWithVowel(words[i]) ? 1 : 0);
            }
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int start = 0;
            if(queries[i][0] > 0) start = counts[queries[i][0] - 1];
            int end = counts[queries[i][1]];
            ans[i] = end - start;
        }
        return ans;
    }
    private boolean startsWithVowel(String s) {
        HashSet<Character> vowels = new HashSet();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        if(!vowels.contains(s.charAt(0))) return false;
        if(!vowels.contains(s.charAt(s.length() - 1))) return false;
        return true;
    }
}