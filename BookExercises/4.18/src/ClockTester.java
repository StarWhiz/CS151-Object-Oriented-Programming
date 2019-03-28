/**
 * 
 * Tai Dao's 4.18 solution
 * ID: 006769100
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ClockTester {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClockFrame newClockFrame = new ClockFrame();
		newClockFrame.setVisible(true);
		
		ClockComponent clock = new ClockComponent();
		newClockFrame.add(clock);
		clock.setVisible(true);
		
		
		ActionListener listener = new
			ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clock.repaint();
				}
			};
			
		final int DELAY = 1000;
		Timer t = new Timer(DELAY, listener);
		t.start();
	
	}
	
}
