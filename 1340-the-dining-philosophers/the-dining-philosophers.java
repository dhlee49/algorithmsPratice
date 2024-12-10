class DiningPhilosophers {
    private Semaphore[] forks;
    private final Semaphore mutex = new Semaphore(1);
    public DiningPhilosophers() {
        forks = new Semaphore[5];
        for(int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
        
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = philosopher;
        int right = (philosopher + 1) % 5;
        mutex.acquire();
        if(philosopher == 0) {
            forks[right].acquire();
            pickRightFork.run();
            forks[left].acquire();
            pickLeftFork.run();
        } else {
            forks[left].acquire();
            pickLeftFork.run();
            forks[right].acquire();
            pickRightFork.run();
        }
        eat.run();
        forks[left].release(1);
        putLeftFork.run();
        forks[right].release(1);
        putRightFork.run();
        mutex.release();
    }
}