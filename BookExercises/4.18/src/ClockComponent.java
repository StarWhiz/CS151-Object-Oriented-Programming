import javax.swing.*;
import java.awt.*;

public class ClockComponent extends JComponent{

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Clock clock = new Clock();
		clock.draw(g2);
	}
}
