import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
/**
 * 
 * @author Anamo Kisho
 *
 */

public class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener {
	// instance variable
	private ArrayList<Line> lines;
	private Color penColor;
	
	// constructor
	public CanvasPanel() {
		// set the size of this panel to be 800x600 pixels
		super.setPreferredSize(new Dimension(800, 600));
		
		// make this panel to react to the mouse events
		super.addMouseListener(this);
		super.addMouseMotionListener(this);
		
		// initialize the list of lines to be empty
		this.lines = new ArrayList<Line>();
		
		// default pen color is black
		this.penColor = Color.BLACK;
	}
	
	// instance methods
	public void reset() {
		this.lines.clear(); // remove all lines from the list
		
		super.repaint(); // force a repaint
	}
	
	public void setPenColor(Color color) {
		this.penColor = color;
	}
	
	public void addLine(Line line) {
		this.lines.add(line);
	}
	
	public Line getLastLine() {
		if (this.lines.size() > 0) {
			return this.lines.get(lines.size() - 1);
		}
		throw new RuntimeException("There is no line yet!");
	}
	
	protected void paintComponent(Graphics page) {
		// draw the empty JPanel (super)
		super.paintComponent(page);
		
		// draw all the lines
		for (Line line: this.lines) {
			line.draw(page);
		}
	}
	@Override
	public void mousePressed(MouseEvent event) {
		// mouse button is pressed
		// create a new line with the mouse position
		this.addLine(new Line(event.getPoint(), this.penColor));
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// mouse is dragged
		// add the mouse position as a new point to the line being drawn
		this.getLastLine().addPoint(event.getPoint());
		super.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
