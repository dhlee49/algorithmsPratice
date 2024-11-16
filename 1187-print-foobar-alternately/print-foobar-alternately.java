class FooBar {
    private int n;
    private boolean lock;
    public FooBar(int n) {
        this.n = n;
        this.lock = false;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(lock) {
               wait(); 
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            lock = true;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(!lock) {
                wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            lock = false;
            notifyAll();
        }
    }
}