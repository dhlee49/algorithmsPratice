class Foo {
    private Semaphore first;
    private Semaphore second;
    
    public Foo() {
        first = new Semaphore(0);
        second = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first.release(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        first.acquire(1);
        printSecond.run();
        second.release(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        second.acquire(1);
        printThird.run();
    }
}