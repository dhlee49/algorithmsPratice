class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if (map.containsKey(target - item)) {
                System.out.println(item);
                int index = map.get(target - item);
                return new int[] {index, i};
            }
            map.put(item, i);
        }
        return null;
    }
}