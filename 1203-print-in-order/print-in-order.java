class Foo {
    Semaphore first;
    Semaphore second;
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
        first.acquire(1);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        first.release(0);
        second.release(1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        second.acquire(1);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}