class ZeroEvenOdd {
    private int n;
    private boolean zerolock;
    private boolean oddLock;
    private boolean evenLock;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zerolock = false;
        this.oddLock = true;
        this.evenLock = true;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <=n; i++) {
            while(zerolock) {
                wait();
            }
            printNumber.accept(0);
            if(i % 2 == 0) {
                evenLock = false;
            } else {
                oddLock = false;
            }
            zerolock = true;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n; i = i + 2) {
            while(evenLock) {
                wait();
            }
            printNumber.accept(i);
            this.zerolock = false;
            this.evenLock = true;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i = i + 2) {
            while(oddLock) {
                wait();
            }
            printNumber.accept(i);
            this.zerolock = false;
            this.oddLock = true;
            notifyAll();
        }
    }
}