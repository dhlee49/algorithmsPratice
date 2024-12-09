class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 1) return 1;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] candies = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++) minHeap.offer(new int[] {ratings[i], i});
        int sum = 0;
        for(int i = 0; i < ratings.length; i++) {
            int[] curr = minHeap.poll();
            int rate = curr[0];
            int idx = curr[1];
            //Case 1. You are the edge.
            if(idx == 0) {
                if(ratings[idx + 1] >= rate) {
                    //You are the lowest
                    candies[idx] = 1;
                } else{ 
                    //You are higher than one on right
                    candies[idx] = candies[idx + 1] + 1;
                };
            } else if(idx == ratings.length - 1) {
                //Case 2. You are the other edge.
                if(ratings[idx - 1] >= rate) {
                    //You are the lowest
                    candies[idx] = 1;
                } else{ 
                    //You are higher than one on the left
                    candies[idx] = candies[idx - 1] + 1;
                };
            } else {
                //You are regular Node
                //3 cases
                //1 You are lowest
                //2 you are highest
                //3 you are higher than 1
                int right = ratings[idx + 1];
                int left = ratings[idx - 1];
                if(rate > left) {
                    //Bigger than left
                    if(rate > right) {
                        //also right
                        candies[idx] = Math.max(candies[idx - 1], candies[idx + 1]) + 1;
                    } else {
                        candies[idx] = candies[idx - 1] + 1;
                    }
                } else {
                    //Smaller than left
                    if(rate <= right) {
                        //also right
                        candies[idx] = 1;
                    } else {
                        //bigger than right
                        candies[idx] = candies[idx + 1] + 1;
                    }
                }
            }
            System.out.println(idx + " & " + candies[idx]);
        
            sum += candies[idx];
        }
        return sum;
    }
}