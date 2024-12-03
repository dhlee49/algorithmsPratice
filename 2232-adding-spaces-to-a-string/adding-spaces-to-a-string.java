class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s.substring(0, spaces[0]));
        for(int i = 1; i < spaces.length; i ++) {
            sb.append(' ');
            sb.append(s.substring(spaces[i - 1], spaces[i]));
        }
        if(spaces[spaces.length - 1] < s.length()) {
            sb.append(' ');
            sb.append(s.substring(spaces[spaces.length - 1], s.length()));
        }
        return sb.toString();
    }
}