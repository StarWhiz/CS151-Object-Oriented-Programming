package chapter4exercise14;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;


public class Car {
	public void draw(Graphics2D g2) {
		Rectangle2D body = new Rectangle2D.Double(50,50,200,100);
		Ellipse2D tire1 = new Ellipse2D.Double(50,150,50,50);
		Ellipse2D tire2 = new Ellipse2D.Double(200,150,50,50);
		g2.draw(body);
		g2.draw(tire1);
		g2.draw(tire2);
	}
}
