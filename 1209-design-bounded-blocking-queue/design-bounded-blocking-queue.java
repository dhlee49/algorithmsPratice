class BoundedBlockingQueue {
    int size;
    Queue<Integer> queue;
    Semaphore insertSem = new Semaphore(1);
    Semaphore removeSem = new Semaphore(0);
    Semaphore mutex = new Semaphore(1);
    public BoundedBlockingQueue(int capacity) {
        this.queue = new LinkedList();
        this.size = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        insertSem.acquire();
        mutex.acquire();
        this.queue.offer(element);
        if(this.queue.size() == 1) removeSem.release(1);
        if(this.size > this.queue.size()) insertSem.release(1);
        mutex.release();
    }
    
    public int dequeue() throws InterruptedException {
        int val = 0;
        removeSem.acquire();
        mutex.acquire();
        val = this.queue.remove();
        if(this.queue.size() < this.size) insertSem.release(1);
        if(this.queue.size() > 0) removeSem.release(1);
        mutex.release(1);
        return val;
    }
    
    public int size() { 
        return this.queue.size();
    }
}