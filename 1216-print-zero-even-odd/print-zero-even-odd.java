class ZeroEvenOdd {
    private int n;
    private Semaphore firstSem = new Semaphore(1);
    private Semaphore secondSem = new Semaphore(0);
    private Semaphore thirdSem = new Semaphore(0);
    int curr;
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.curr = 0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(curr <= n) {
            firstSem.acquire();
            curr++;
            if(curr <= n) printNumber.accept(0);
            if(curr % 2 == 0) {
                secondSem.release(1);
            } else {
                thirdSem.release(1);
            }
        }
        secondSem.release();
        thirdSem.release();
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(curr <= n) {
            secondSem.acquire();
            if(curr <= n) printNumber.accept(curr);
            firstSem.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(curr <= n) {
            thirdSem.acquire();
            if(curr <= n) printNumber.accept(curr);
            firstSem.release();
        }
    }
}