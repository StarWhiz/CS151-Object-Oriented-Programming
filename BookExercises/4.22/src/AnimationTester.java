
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Tai Dao
 * 006769100
 * 
 * Credits to horstmann for the MoveableShape interface. And some of the ShapeIcon class.
 * Source: http://www.horstmann.com/oodp2/solutions/Ch4/Ex21/MoveableShape.java
 * 
 */

public class AnimationTester {
	private static final int ICON_WIDTH = 88;
	private static final int ICON_HEIGHT = 125;
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 200;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Moving Snowman");
		frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		
		SnowMan snowman = new SnowMan();
		ShapeIcon snowmanIcon = new ShapeIcon(snowman, ICON_WIDTH, ICON_HEIGHT );
		final JLabel label = new JLabel(snowmanIcon);
		frame.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		final int DELAY = 10;
		
		Timer t = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				if (snowman.getXpos() > FRAME_WIDTH) {
					snowman.newSnowManPosition(0, 0);
				}
				snowman.translate(5, 0);
				label.repaint();
			}
		});
		t.start();
	}
}
