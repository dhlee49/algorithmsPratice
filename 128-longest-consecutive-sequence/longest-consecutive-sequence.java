class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> check = new HashSet();
        for(int num : nums) {
            if(!check.contains(num)) check.add(num);
        }
        int max = 0;
        int curr, count;
        for(int num : nums) {
            if(check.contains(num + 1)) continue;
            curr = num;
            count = 1;
            while(check.contains(curr - 1)) {
                count++;
                curr--;
            }
            if(count > max) max = count;
        }
        return max;
    }
}