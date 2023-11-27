package DiningPhilosophers;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.concurrent.Semaphore;

public class Dining extends JFrame {
	private static final long serialVersionUID = 8531554653309568273L;
	private Image table, filosofo0, filosofo1, filosofo2, filosofo3, filosofo4;
	private Philosopher f0, f1, f2, f3, f4;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dining frame = new Dining();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void paint(Graphics g){	
		Graphics2D graphics = (Graphics2D) g;
		
		graphics.drawImage(table, 0, 0, null);
		graphics.drawImage(filosofo0, 0, 0, null);
		graphics.drawImage(filosofo1, 0, 0, null);
		graphics.drawImage(filosofo2, 0, 0, null);
		graphics.drawImage(filosofo4, 0, 0, null);
		graphics.drawImage(filosofo3, 0, 0, null);
	}
	
	public void jantar_WindowDestroy(Object target) {
		System.exit(0);
	}
	
	public Dining() {
		setTitle("Dining Philosophers");;
		ImageIcon reference = new ImageIcon("src\\Images\\Table.png");
		table = reference.getImage();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		reference = new ImageIcon("src\\Images\\Table.png");
		

		Semaphore[] garfosSem = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            garfosSem[i] = new Semaphore(1);
        }
		
		f0 = new Philosopher(0, this, garfosSem);
		f1 = new Philosopher(1, this, garfosSem);
		f2 = new Philosopher(2, this, garfosSem);
		f3 = new Philosopher(3, this, garfosSem);
		f4 = new Philosopher(4, this, garfosSem);
		
		f0.start();
		f1.start();
		f2.start();
		f3.start();
		f4.start();
	}
	
	public void SetVisualState(int key, PhillosopherState state) {
		
		if (key == 0) {		
			if (state == PhillosopherState.THINKING) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo0Thinking.png");		
				filosofo0 = reference.getImage();
				
			} else if (state == PhillosopherState.HUNGRY) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo0Hungry.png");		
				filosofo0 = reference.getImage();
				
			} else if (state == PhillosopherState.EATING) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo0Eating.png");		
				filosofo0 = reference.getImage();				
			}
		}
		else if (key == 1) {
			if (state == PhillosopherState.THINKING) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo1Thinking.png");		
				filosofo1 = reference.getImage();
			
			} else if (state == PhillosopherState.HUNGRY) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo1Hungry.png");		
				filosofo1 = reference.getImage();
			

			} else if (state == PhillosopherState.EATING) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo1Eating.png");		
				filosofo1 = reference.getImage();
			}
		}
		else if (key == 2) {
			if (state == PhillosopherState.THINKING) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo2Thinking.png");		
				filosofo2 = reference.getImage();
			
			} else if (state == PhillosopherState.HUNGRY) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo2Hungry.png");		
				filosofo2 = reference.getImage();
			

			} else if (state == PhillosopherState.EATING) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo2Eating.png");		
				filosofo2 = reference.getImage();
			}
		}
		else if (key == 3) {
			if (state == PhillosopherState.THINKING) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo3Thinking.png");		
				filosofo3 = reference.getImage();
			
			} else if (state == PhillosopherState.HUNGRY) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo3Hungry.png");		
				filosofo3 = reference.getImage();
			

			} else if (state == PhillosopherState.EATING) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo3Eating.png");		
				filosofo3 = reference.getImage();
			}
		}
		else if (key == 4) {
			if (state == PhillosopherState.THINKING) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo4Thinking.png");		
				filosofo4 = reference.getImage();
			
			} else if (state == PhillosopherState.HUNGRY) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo4Hungry.png");		
				filosofo4 = reference.getImage();
			

			} else if (state == PhillosopherState.EATING) {
				ImageIcon reference = new ImageIcon("src\\Images\\imgFilosofo4Eating.png");		
				filosofo4 = reference.getImage();
			}
		}
		
		repaint();
	}
	
	public void start() {
	}

	public void stop() {
	}

	public void destroy() {
	}
}
