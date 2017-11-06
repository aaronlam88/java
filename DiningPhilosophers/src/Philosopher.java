import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
class Philosopher extends JLabel implements Runnable {
	Chopstick leftStick, rightStick;
	boolean full;
	DiningPhilosophers parent;
	int position;
	Thread philThread = null;

	public Philosopher(DiningPhilosophers parent, int position, ImageIcon img) {
		super(parent.names[position], img, SwingConstants.CENTER);
		this.parent = parent;
		this.position = position;

		setVerticalTextPosition(SwingConstants.BOTTOM);
		setHorizontalTextPosition(SwingConstants.CENTER);

		this.rightStick = parent.chopsticks[position];
		if (position == 0)
			this.leftStick = parent.chopsticks[DiningPhilosophers.PHILOSOPHERS - 1];
		else
			this.leftStick = parent.chopsticks[position - 1];

		this.full = false;
		philThread = new Thread(this);
	}

	@Override
	public void run() {
		try {
			while (true) {
				// set a random delay on the right chopstick
				Thread.sleep((int) (Math.random() * parent.grabDelay));
				setText("     ");
				rightStick.grab();
				setIcon(parent.imgs[DiningPhilosophers.RIGHTSPOON]);

				// set a random delay on the left chopstick
				Thread.sleep((int) (Math.random() * parent.grabDelay));
				leftStick.grab();
				setIcon(parent.imgs[DiningPhilosophers.BOTHSPOONS]);

				// release the chopsticks - philosopher is full
				Thread.sleep((int) (Math.random() * parent.grabDelay));
				rightStick.release();
				leftStick.release();
				setIcon(parent.imgs[DiningPhilosophers.HUNGRY]);
				setText("Mmmm!");
				full = true;

				// philosopher is hungry again
				Thread.sleep((int) (Math.random() * parent.grabDelay * 4));
				full = false;
			}
		} catch (java.lang.InterruptedException e) {
		}

		// recover from race-condition
		leftStick.releaseIfMine();
		rightStick.releaseIfMine();
		setIcon(parent.imgs[DiningPhilosophers.HUNGRY]);
		setText(parent.names[position]);
		full = false;
		philThread = new Thread(this);
	}
}
