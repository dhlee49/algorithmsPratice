class FizzBuzz {
    private int n;
    private int counter;
    private ReentrantLock lock;
    private Condition condition;
    public FizzBuzz(int n) {
        this.n = n;
        counter = 1;
        //mutex to control the printing
        lock  = new ReentrantLock();
        condition = lock.newCondition();        
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(true) {
            lock.lock();
            try {
                while(counter > n || counter % 3 != 0 || counter % 5 == 0) {
                    if(counter > n) return;
                    condition.await();
                }
                printFizz.run();
                counter++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(true) {
            lock.lock();
            try {
                while(counter > n || counter % 5 != 0 || counter % 3 == 0) {
                    if(counter > n) return;
                    condition.await();
                }
                printBuzz.run();
                counter++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true) {
            lock.lock();
            try {
                while(counter > n || counter % 5 != 0 || counter % 3 != 0) {
                    if(counter > n) return;
                    condition.await();
                }
                printFizzBuzz.run();
                counter++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            lock.lock();
            try {
                while(counter > n || counter % 5 == 0 || counter % 3 == 0) {
                    if(counter > n) return;
                    condition.await();
                }
                printNumber.accept(counter);
                counter++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}