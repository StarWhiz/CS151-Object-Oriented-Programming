import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Car {
	private int x = 10;
	private int y = 10;
	private int size = 0;
	
	public void draw (Graphics2D g2) {
		Rectangle2D.Double body = new Rectangle2D.Double(x, y + size / 6, size - 1, size / 6);
		Ellipse2D.Double frontTire
		      = new Ellipse2D.Double(x + size / 6, y + size / 3, 
		            size / 6, size / 6);
		Ellipse2D.Double rearTire
		      = new Ellipse2D.Double(x + size * 2 / 3, y + size / 3,
		            size / 6, size / 6);
		
		// The bottom of the front windshield
		Point2D.Double r1
		      = new Point2D.Double(x + size / 6, y + size / 6);
		// The front of the roof
		Point2D.Double r2
		      = new Point2D.Double(x + size / 3, y);
		// The rear of the roof
		Point2D.Double r3
		      = new Point2D.Double(x + size * 2 / 3, y);
		// The bottom of the rear windshield
		Point2D.Double r4
		      = new Point2D.Double(x + size * 5 / 6, y + size / 6);
		Line2D.Double frontWindshield
		      = new Line2D.Double(r1, r2);
		Line2D.Double roofTop
		      = new Line2D.Double(r2, r3);
		Line2D.Double rearWindshield
		      = new Line2D.Double(r3, r4);
		
		g2.draw(body);
		g2.draw(frontTire);
		g2.draw(rearTire);
		g2.draw(frontWindshield);
		g2.draw(roofTop);
		g2.draw(rearWindshield); 
	}
	
	public void updateSize(int size) {
		this.size = size;
	}
}

