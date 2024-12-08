class H2O {
    private final Semaphore oxySem = new Semaphore(2);
    private final Semaphore hydroSem = new Semaphore(0);
    
    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hydroSem.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oxySem.release(1);
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxySem.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        hydroSem.release(2);
    }
}