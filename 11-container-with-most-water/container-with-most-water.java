class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right) {
            int curr = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(curr, max);
            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}