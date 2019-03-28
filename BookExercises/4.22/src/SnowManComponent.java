import java.awt.Graphics;
import java.awt.Graphics2D;

public class SnowManComponent {
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		SnowMan snowman = new SnowMan();
		snowman.draw(g2);
	}
}
