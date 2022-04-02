import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import java.util.ArrayList;

public class Line {
	// instance variables
	private Color color;
	private ArrayList<Point> points;
	
	// constructor
	public Line(Point point, Color color) {
		this.points = new ArrayList<Point>(); // empty list of points
		this.points.add(point); // add the starting point
		
		this.color = color; // initialize the color
	}
	
	// instance methods
	public void draw(Graphics page) {
		// set the pen color
		page.setColor(this.color);
		// connect all the points in order
		// go through all points starting with the first pair (0, 1)
		for (int index = 1; index < this.points.size(); index++) {
			Point prevPoint = this.points.get(index - 1);
			Point point = this.points.get(index);
			page.drawLine(prevPoint.x, prevPoint.y, point.x, point.y);
		}
	}
	
	public void addPoint(Point point) {
		this.points.add(point);
	}
}
