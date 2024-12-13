class Solution {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = k - 1;
        int sum = 0;
        int max = blocks.length() + 1;
        for(int i = 0; i < k; i++) {
            if(blocks.charAt(i) == 'W') sum++;
        }
        max = Math.min(sum, max);
        while(right < blocks.length() - 1) {
            if(blocks.charAt(left) == 'W') sum--;
            left++;
            //right = k
            right++;
            if(right < blocks.length() && blocks.charAt(right) == 'W') sum++;
            max = Math.min(sum, max);
        }
        return max;
    }
}