package DiningPhilosophers;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
	private int filosofo;
	private Dining jantar;
	private Semaphore garfos[];

	public Philosopher(int chave, Dining jantar, Semaphore[] garfos) {
		this.filosofo = chave;		
		this.jantar = jantar;
		this.garfos = garfos;
	}

	public int getChave() { 
		return filosofo;
	}

	public void setStatus(eEstadoDoFilosofo estado) {
		jantar.SetInfo(filosofo, estado);
	}

	private void pensando() { 
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
	}

	private void comendo() { 
		try {
			Thread.sleep(2500);
		} catch (Exception e) {
		}
	}
	 
	public void run() {
        while (true) {
            setStatus(eEstadoDoFilosofo.THINKING);
            pensando();
            setStatus(eEstadoDoFilosofo.HUNGRY);
            try {
                garfos[getChave()].acquire();
                garfos[(getChave() + 1) % 5].acquire();
                setStatus(eEstadoDoFilosofo.EATING);
                comendo();
                garfos[getChave()].release();
                garfos[(getChave() + 1) % 5].release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
