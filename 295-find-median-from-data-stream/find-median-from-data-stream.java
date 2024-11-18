class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    int size;
    public MedianFinder() {
        maxHeap = new PriorityQueue(Collections.reverseOrder());
        minHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        size++;
        if(size % 2 == 1) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(size % 2 == 1) {
            return maxHeap.peek();
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2d;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */