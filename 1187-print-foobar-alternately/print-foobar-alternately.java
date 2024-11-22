class FooBar {
    private int n;
    private Object lock;
    private boolean first;
    private boolean second;
    public FooBar(int n) {
        this.n = n;
        lock = new Object();
        first = false;
        second = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(lock) {
                while(first) lock.wait();
                printFoo.run();
                second = false;
                first = true;
                lock.notifyAll();
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            synchronized(lock) {
                while(second) lock.wait();
                printBar.run();
                second = true;
                first = false;
                lock.notifyAll();
            }
        }
    }
}