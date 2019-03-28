import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class CarComponent extends JComponent {
	Car car;
	int size;
	
	CarComponent(int size) {
		this.size = size;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		car = new Car();
		car.updateSize(size);
		car.draw(g2);
	}
	public void updateSize(int size) {
		this.size = size;
	}
}
