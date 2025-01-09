class MedianFinder {
    private PriorityQueue<Integer> topHalf;
    private PriorityQueue<Integer> bottomHalf;
    private int size;
    public MedianFinder() {
        topHalf = new PriorityQueue<>((a, b) -> b - a);
        bottomHalf = new PriorityQueue<>((a, b) -> a - b);
        size = 0;
    }
    
    public void addNum(int num) {
        size++;
        if(size % 2 == 1) {
            topHalf.offer(num);
            bottomHalf.offer(topHalf.poll());
        } else {
            bottomHalf.offer(num);
            topHalf.offer(bottomHalf.poll());
        }
    }
    
    public double findMedian() {
        if(size % 2 == 1) return bottomHalf.peek();
        double ans = (bottomHalf.peek() + topHalf.peek()) / 2d;
        return ans;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */