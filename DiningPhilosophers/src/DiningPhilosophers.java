
/*
 * Dining Philosophers Problem
 * 
 * Five philosophers are sitting at a round table. In front of each philosopher
 * is a bowl of rice. Between each pair of philosophers is one chopstick. 
 * Before an individual philosopher can take a bite of rice, he must have 
 * two chopsticks, one taken from the left, and one taken from the right. 
 * The philosophers must find some way to share chopsticks such that 
 * they all get to eat.  Deadlock will occur in this story, if all 
 * philosophers are taking the chopstick from the left side at the 
 * same time, and no one is willing to put down the chopstick until 
 * he gets the chopstick on the right side.
 */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class DiningPhilosophers extends JApplet implements ActionListener, ChangeListener {
	static final int PHILOSOPHERS = 5;
	static final int HUNGRY = 0;
	static final int RIGHTSPOON = 1;
	static final int BOTHSPOONS = 2;
	JButton stopStartButton = new JButton("start");
	// delays can go from 0 to 10,000 milliseconds, initial value is 500
	int grabDelay = 500;
	JSlider grabDelaySlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 5);
	JLabel label = new JLabel("  500 milliseconds");
	JPanel philosopherArea;
	ImageIcon[] imgs = new ImageIcon[3];
	Chopstick[] chopsticks = new Chopstick[PHILOSOPHERS];
	String[] names = { "Alan", "Bob", "Chris", "Duko", "Evan" };
	Philosopher[] philosophers = new Philosopher[PHILOSOPHERS];

	@Override
	public void actionPerformed(ActionEvent e) {
		if (stopStartButton.getText().equals("stop/reset")) {
			stopPhilosophers();
			stopStartButton.setText("start");
		} else if (stopStartButton.getText().equals("start")) {
			startPhilosophers();
			stopStartButton.setText("stop/reset");
		}
	}

	public void createPhilosophersAndChopsticks() {
		for (int i = 0; i < PHILOSOPHERS; i++)
			chopsticks[i] = new Chopstick();
		for (int i = 0; i < PHILOSOPHERS; i++) {
			philosophers[i] = new Philosopher(this, i, imgs[HUNGRY]);
			philosopherArea.add(philosophers[i]);
		}
	}

	protected URL getURL(String filename) {
		URL codeBase = getCodeBase();
		URL url = null;
		try {
			url = new URL(codeBase, filename);
		} catch (java.net.MalformedURLException e) {
			System.out.println("Couldn't create image: " + "badly specified URL");
			return null;
		}
		return url;
	}

	@Override
	public void init() {
		setSize(275, 350);
		imgs[HUNGRY] = new ImageIcon(getURL("images/hungryduke.gif"));
		imgs[RIGHTSPOON] = new ImageIcon(getURL("images/rightspoonduke.gif"));
		imgs[BOTHSPOONS] = new ImageIcon(getURL("images/bothspoonsduke.gif"));
		GridBagLayout gridBag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		JPanel panel = new JPanel();
		panel.setLayout(gridBag);
		philosopherArea = new JPanel(new GridLayout(3, 3));
		createPhilosophersAndChopsticks();

		// position the philosophers
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // end row
		gridBag.setConstraints(philosopherArea, gbc);
		panel.add(philosopherArea);

		// position the start/stop button
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gridBag.setConstraints(stopStartButton, gbc);
		panel.add(stopStartButton);

		// position the slider
		gbc.gridwidth = GridBagConstraints.RELATIVE; // don't end row
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gridBag.setConstraints(grabDelaySlider, gbc);
		panel.add(grabDelaySlider);

		// position the label
		gbc.weightx = 0.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER; // end row
		gridBag.setConstraints(label, gbc);
		panel.add(label);

		setContentPane(panel);
		stopStartButton.addActionListener(this);
		grabDelaySlider.addChangeListener(this);
	}

	public void startPhilosophers() {
		for (int i = 0; i < PHILOSOPHERS; i++)
			philosophers[i].philThread.start();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		grabDelay = source.getValue() * 100;
		label.setText(String.valueOf(grabDelay + " milliseconds"));
	}

	public void stopPhilosophers() {
		for (int i = 0; i < PHILOSOPHERS; i++)
			philosophers[i].philThread.interrupt();
	}
}
