class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] sol = new int[spells.length]; 
        for(int i = 0; i < spells.length; i++) sol[i] = binarySearch(spells[i], success, potions);
        return sol;
    }
    private int binarySearch(int curr, long target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        int n  = arr.length;
        while(right >= left) {
            mid = (left + right) / 2;
            if((long) arr[mid] * curr >= target) {
                n = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return arr.length - n;
    }
}