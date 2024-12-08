class BoundedBlockingQueue {
    private final LinkedList<Integer> queue = new LinkedList();
    private int capacity;
    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore enqueSem = new Semaphore(1);
    private final Semaphore dequeSem = new Semaphore(0);
    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        enqueSem.acquire(1);
        mutex.acquire(1);
        this.queue.offer(element);
        if(this.queue.size() == 1) dequeSem.release(1);
        if(this.queue.size() < this.capacity) enqueSem.release(1);
        mutex.release();
    }
    
    public int dequeue() throws InterruptedException {
        dequeSem.acquire(1);
        mutex.acquire(1);
        int val = this.queue.poll();
        if(this.queue.size() == this.capacity - 1) enqueSem.release(1);
        if(this.queue.size() > 0) dequeSem.release(1);
        mutex.release();
        return val;
        
    }
    
    public int size() {
        return this.queue.size();
        
    }
}