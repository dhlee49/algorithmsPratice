class Solution {
    public String compressedString(String word) {
        char prev = '\0';
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for(char c : word.toCharArray()) {
            if(prev == '\0') {
                prev = c;
                count++;
                continue;
            } 
            if(prev != c) {
                sb.append(count);
                count = 1;
                sb.append(prev);
                prev = c;
            } else {
                if(count == 9) {
                    sb.append(count);
                    sb.append(prev);
                    count = 0;
                }
                count++;
            }
        }
        if(prev == word.charAt(word.length() - 1)) {
            sb.append(count);
            sb.append(prev);
        }
        return sb.toString();
    }
}