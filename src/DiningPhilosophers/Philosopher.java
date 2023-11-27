package DiningPhilosophers;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
	private int philosopherKey;
	private Dining dining;
	private Semaphore forks[];

	public Philosopher(int key, Dining dining, Semaphore[] forksSemaphores) {
		this.philosopherKey = key;		
		this.dining = dining;
		this.forks = forksSemaphores;
	}

	public int getKey() { 
		return philosopherKey;
	}

	public void setStatus(PhillosopherState state) {
		dining.SetVisualState(philosopherKey, state);

		switch (state) {
			case EATING:
				eating();
				break;
			case THINKING:
				thinking();
				break;
			default:
				break;
		}
	}

	private void thinking() { 
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}

	private void eating() { 
		try {
			Thread.sleep(2500);
		} catch (Exception e) {
		}
	}
	 
	public void run() {
        while (true) {
            setStatus(PhillosopherState.THINKING);
            setStatus(PhillosopherState.HUNGRY);
            try {
                forks[getKey()].acquire();
                forks[(getKey() + 1) % 5].acquire();
                setStatus(PhillosopherState.EATING);
                eating();
                forks[getKey()].release();
                forks[(getKey() + 1) % 5].release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
