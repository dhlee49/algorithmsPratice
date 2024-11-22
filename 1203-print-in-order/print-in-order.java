class Foo {
    private Object lock;
    private boolean first;
    private boolean second;
    public Foo() {
        lock = new Object();
        first = true;
        second = true;
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(lock) {
            printFirst.run();
            first = false;
            lock.notifyAll();
        } 
        // printFirst.run() outputs "first". Do not change or remove this line.
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(lock) {
            while(first) lock.wait();
            printSecond.run();
            second = false;
            lock.notifyAll();
        } 
        // printSecond.run() outputs "second". Do not change or remove this line.
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized(lock) {
            while(second) lock.wait();
            printThird.run();
        } 
    }
}