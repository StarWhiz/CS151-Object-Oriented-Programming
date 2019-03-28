package chapter4exercise14;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class ButtonPanel extends JPanel{

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double planet = new Ellipse2D.Double(0, 0, 100, 100);
		g2.setColor(Color.RED);
		g2.fill(planet);
	}
}
