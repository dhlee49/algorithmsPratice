class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = Math.min(height[l], height[r]) * r - l;
        while(l < r) {
            if(height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
        }
        return max;
    }
}