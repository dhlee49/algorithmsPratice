class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numbers = new HashSet();
        for(int i = 0; i < nums.length; i ++) {
            numbers.add(nums[i]);
        }
        int length = 0;
        int max = 0;
        for(int i : numbers) {
            //Case 1. Is start of sequence
            if(!numbers.contains(i - 1)) {
                length = 1;
                while(numbers.contains(i + length)) {
                    length++;
                }
                max = Math.max(max, length);
            }
        }
        return max;

    }
}