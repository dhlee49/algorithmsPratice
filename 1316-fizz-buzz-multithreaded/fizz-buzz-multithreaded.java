class FizzBuzz {
    private int n;
    private final Semaphore fizzSem;
    private final Semaphore fizzBuzzSem;
    private final Semaphore buzzSem;
    private final Semaphore numberSem;
    private int curr;
    public FizzBuzz(int n) {
        this.n = n;
        this.curr = 0;
        fizzSem = new Semaphore(0);
        buzzSem = new Semaphore(0);
        fizzBuzzSem = new Semaphore(0);
        numberSem = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(curr <= n) {
            fizzSem.acquire();
            if(curr <= n) printFizz.run();
            numberSem.release(1);
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(curr <= n) {
            buzzSem.acquire();
            if(curr <= n) printBuzz.run();
            numberSem.release(1);
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(curr <= n) {
            fizzBuzzSem.acquire(1);
            if(curr <= n) printFizzBuzz.run();
            numberSem.release(1);
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(curr <= n) {
            numberSem.acquire(1);
            curr++;
            if(curr > n) {
                fizzSem.release(1);
                buzzSem.release(1);
                fizzBuzzSem.release(1);
                numberSem.release(1);
            } else if(curr % 5 == 0 && curr % 3 == 0) {
                fizzBuzzSem.release(1);
            } else if(curr % 5 == 0) {
                buzzSem.release(1);
            } else if(curr % 3 == 0) {
                fizzSem.release(1);
            } else {
                printNumber.accept(curr);
                numberSem.release(1);
            } 
        } 
    }
}