/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        int idx = l + (r - l) / 2;
        int curr = guess(idx);
        while(curr != 0) {
            if(curr == 1) {
                l = idx + 1;
            } else {
                r = idx - 1;
            }
            idx = l + (r - l) /  2;
            curr = guess(idx);
        }
        return idx;
    }
}