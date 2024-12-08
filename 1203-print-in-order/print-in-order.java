class Foo {
    private final Semaphore second = new Semaphore(0);
    private final Semaphore third = new Semaphore(0);
    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.release(1);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.release(1);
        
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.acquire(1);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}