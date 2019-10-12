package nz.ac.massey.assignment1;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimeAndDate extends JFrame{
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private LabelPanel lp = null;

	public TimeAndDate() {

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(200, 150);
		setResizable(false);
		//set parameter of the time Jframe
		
		lp = new LabelPanel();
		getContentPane().add(new TimePanel());
		//add the Jpanel of time

		setVisible(true);

		Timer timer = new Timer();
		timer.schedule(new ShowTime(), new Date(), 1000);
		//set the time can auto change
	}

	class ShowTime extends TimerTask {
		public void run() {
			lp.label.setText(sdf.format(new Date()));
			repaint();
			//update time
		}
	}

	class TimePanel extends JPanel {
		public void paint(Graphics g) {
			super.paint(g);
			g.drawString(sdf.format(new Date()), 10, 10);
			//display the time
		}
	}

	class LabelPanel extends JPanel {
		JLabel label = new JLabel();

		public LabelPanel() {
			add(label);
		}
	}

	public static void main(String[] args) {
		new TimeAndDate();
	}

}
