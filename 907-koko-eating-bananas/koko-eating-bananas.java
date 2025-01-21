class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().orElse(-1);
        int mid = 0;
        long cnt = 0;
        int ans = r;
        while(r >= l) {
            mid = l + (r - l) / 2;
            cnt = 0;
            for(int pile : piles) {
                cnt += pile / mid;
                if(pile % mid > 0) cnt++;
            }
            if(cnt <= h) ans = Math.min(ans, mid);
            if(cnt > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}