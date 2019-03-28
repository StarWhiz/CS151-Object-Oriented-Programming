/**
 * Tai Dao
 * 006769100
 * 
 * Most of Car.java was taken from the textbook.
 * 
 * 
 */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTester {
	public static final int DEFAULT_WIDTH = 230;
	public static final int DEFAULT_HEIGHT = 170;
	static CarComponent car;
	
	   public static void main(String[] args) {
		   
			JFrame testerFrame = new JFrame();
			testerFrame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
			testerFrame.setTitle("Car Slider Tester");
			testerFrame.setLayout(new BorderLayout());
			testerFrame.setVisible(true);
			
			car = new CarComponent(100);
			testerFrame.add(car, BorderLayout.CENTER);
			car.setVisible(true);
			
			
			JSlider slider = new JSlider();
			slider.setVisible(true);
			testerFrame.add(slider ,BorderLayout.SOUTH);
			slider.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					JSlider tempSlide = (JSlider) e.getSource();
		              if (!slider.getValueIsAdjusting()) {
		            	  int size = tempSlide.getValue();
		            	  car.updateSize(size*2);
		            	  car.repaint();
		            	  System.out.println("This is New Size: " + size);
		              }
				}
			});
	   }
}
