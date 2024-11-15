class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int min = 0;
        int max = piles[piles.length - 1];
        int curr = min + max / 2;
        int hours = 0;
        while( min < max) {
            curr = (min + max + 1)/ 2;
            if(curr == min || curr == max) return curr;
            for(int banana : piles) {
                hours += (banana / curr); 
                if(banana % curr > 0) hours++;
            }
            if(hours > h) {
                min = curr;
            } else {
                max = curr;
            }
            hours = 0;
        }
        return curr;
    }
}