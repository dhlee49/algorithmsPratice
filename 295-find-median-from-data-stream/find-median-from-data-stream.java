class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private int size;
    public MedianFinder() {
        size = 0;
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b,a));
    }
    
    public void addNum(int num) {
        if(size == 0) {
            maxHeap.offer(num);
            size++;
            return;
        }
        if(size % 2 == 0) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        size++;
    }    
    public double findMedian() {

        if(size % 2 == 1) {
            return maxHeap.peek();
        } else {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */