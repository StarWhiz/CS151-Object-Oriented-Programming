import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.GregorianCalendar;

public class Clock {
	
	public void draw (Graphics2D g2) {
		
		int hours;
		int minutes;
		int seconds;
		double hourX;
		double hourY;
		double minX;
		double minY;
		double secX;
		double secY;
		int diameter = 600;
		int radius = diameter/2;
		int originX = radius;
		int originY = radius;
		
		GregorianCalendar calendar = new GregorianCalendar();
		hours = calendar.get(calendar.HOUR);
		minutes = calendar.get(calendar.MINUTE);
		seconds = calendar.get(calendar.SECOND);

		hourX = radius * Math.sin(Math.toRadians(hours*30)); // convert to x,y
		hourY = radius * Math.cos(Math.toRadians(hours*30));
		hourX = hourX/2; //length of hand halved
		hourY = hourY/2;
		
		minX = radius * Math.sin(Math.toRadians(minutes*6));
		minY = radius * Math.cos(Math.toRadians(minutes*6));
		minX = minX/1.25;
		minY= minY/1.25;
		
		secX = radius * Math.sin(Math.toRadians(seconds*6));
		secY = radius * Math.cos(Math.toRadians(seconds*6));
		secX = secX/1.25;
		secY = secY/1.25;
		
		Ellipse2D clockBody = new Ellipse2D.Double(0,0, diameter, diameter);
		g2.draw(clockBody);
	
		g2.setStroke(new BasicStroke(5));
		g2.draw(new Line2D.Double(originX, originY, originX+hourX, originY-hourY));  //draws hour
		g2.draw(new Line2D.Double(originX, originY, originX+minX, originY-minY));  // draws minutes
		g2.setStroke(new BasicStroke(1));
		g2.draw(new Line2D.Double(originX, originY, originX+secX, originY-secY)); //draws second hand

	}
}
