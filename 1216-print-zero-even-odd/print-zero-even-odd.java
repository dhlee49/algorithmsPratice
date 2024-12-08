class ZeroEvenOdd {
    private int n;
    private final Semaphore zeroSem = new Semaphore(1);
    private final Semaphore evenSem = new Semaphore(0);
    private final Semaphore oddSem = new Semaphore(0);
    private int curr;
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.curr = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(curr <= n) {
            zeroSem.acquire();
            if(curr <= n) {
                printNumber.accept(0);
                if(curr % 2 == 0) {
                    evenSem.release(1);
                } else {
                    oddSem.release(1);
                }
            } else {
                oddSem.release(1);
                evenSem.release(1);
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(curr <= n) {
            evenSem.acquire(1);
            if(curr <= n) printNumber.accept(curr);
            curr++;
            zeroSem.release(1);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(curr <= n) {
            oddSem.acquire(1);
            if(curr <= n) printNumber.accept(curr);
            curr++;
            zeroSem.release(1);
        }
    }
}