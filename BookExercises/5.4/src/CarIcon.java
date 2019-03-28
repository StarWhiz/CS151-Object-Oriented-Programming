import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

public class CarIcon implements Icon {
	private int width;
	private int height;
	private Car car;
	
	public CarIcon(Car car, int width, int height) {
		this.car = car;
		this.width = width;
		this.height = height;
	}
	
	public int getIconHeight() {
		return height;
	}
	
	public int getIconWidth() {
		return width;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		car.draw(g2);
	}
}
