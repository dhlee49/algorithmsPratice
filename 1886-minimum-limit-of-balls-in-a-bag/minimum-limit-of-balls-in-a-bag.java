class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        if(nums.length == 1) {
            if(nums[0] == 1) return 1;
            return (int) Math.ceil(nums[0] / (maxOperations + 1));
        }
        int low = 1;
        int high = Arrays.stream(nums).max().orElse(-1);
        if(high == 1) return 1;
        int count;
        int min = high;
        while(low < high){ 
            int mid = (low + high)/2;
            count = 0;
            for(int num : nums) {
                count += (num - 1) / mid;
            }
            if(count > maxOperations) {
                low = mid + 1;
            } else {
                min = Math.min(min, mid);
                high = mid;
            }
        }
        return min;
    }   
}