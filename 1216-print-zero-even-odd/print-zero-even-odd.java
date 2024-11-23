class ZeroEvenOdd {
    private int n;
    private boolean printZero;
    private boolean printOne;
    private boolean printTwo;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        printZero = true;
        printOne = false;
        printTwo = false;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i ++) {
            while(!printZero) wait();
            printNumber.accept(0);
            printZero = false;
            if(i % 2 == 1) {
                printOne = true;
                printTwo = false;
            } else {
                printOne = false;
                printTwo = true;
            }
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i += 2) {
            while(!printOne) wait();
            printNumber.accept(i);
            printOne = false;
            printZero = true;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n; i += 2) {
            while(!printTwo) wait();
            printNumber.accept(i);
            printTwo = false;
            printZero = true;
            notifyAll();
        }
    }
}