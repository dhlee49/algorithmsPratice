class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        int x = Math.min(word1.length(), word2.length());
        int y = Math.max(word1.length(), word2.length());
        String z = word1.length() > word2.length() ? word1 : word2;
        for(int i = x; i < y; i++) {
            sb.append(z.charAt(i));
        }
        return sb.toString();
    }
}