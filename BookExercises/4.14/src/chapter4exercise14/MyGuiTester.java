package chapter4exercise14;
import java.awt.*;
import javax.swing.*;

public class MyGuiTester {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 400;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setVisible(true);
		frame.setTitle("Tai's First GUI");
		

		
		// Car Component is JComponent
		CarComponent car1 = new CarComponent();
		CarComponent car2 = new CarComponent();

		frame.add(car1);
		frame.add(car2);
		
		car1.setLocation(400,400);
		car2.setLocation(200, 200);
	}
}
