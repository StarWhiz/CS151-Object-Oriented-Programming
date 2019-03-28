import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class SnowMan implements MoveableShape {
	private int x = 0;
	private int y = 0;
	int diameter = 50;
	
	public void draw(Graphics2D g2) {
		g2.setStroke(new BasicStroke(3));
		Ellipse2D snowHead = new Ellipse2D.Double(x+diameter, y, diameter, diameter); // x, y, h, w
		g2.draw(snowHead);
		Ellipse2D snowBody = new Ellipse2D.Double(x + 37.5, y + 50, 1.5*diameter, 1.5*diameter);
		g2.draw(snowBody);
	}
	
	public void translate(double dx, double dy) {
		x += dx;
		y += dy;
	}
	
	public int getXpos () {
		return x;
	}
	
	public void newSnowManPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
