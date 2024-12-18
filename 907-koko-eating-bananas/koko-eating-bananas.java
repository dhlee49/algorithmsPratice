class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 0;
        int max = Arrays.stream(piles).max().orElse(0);
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