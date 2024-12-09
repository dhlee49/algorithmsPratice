/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int curr = 0;
        for(int i = 1; i < n; i ++) {
            if(!knows(i, curr)) {
                curr = i;
            }
        }
        for(int i = 0; i < n; i++) {
            if(i != curr && !knows(i, curr)) return -1;
            if(i != curr && knows(curr, i)) return -1;
        }
        return curr;
    }
}