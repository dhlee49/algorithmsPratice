class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[target];
        int res = 0;
        for(int i = 0; i < position.length; i ++) {
            //Time it takes for each car to reach position
            time[position[i]] = (double) (target - position[i]) / speed[i];
        }
        double prev = 0.0;
        for (int i = target-1; i >=0 ; i--)
        {
            double cur = time[i];
            if (cur > prev)
            {
                prev = cur;
                res++;
            }
        }
        return res; 
    }
}