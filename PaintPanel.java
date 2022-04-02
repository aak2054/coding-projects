import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PaintPanel extends JPanel implements ActionListener {
	//private static final String ColorDropdown = null;
	// instance variables
	//private ArrayList<ColorButton> colorButtons;
	private JButton resetButton;
	private CanvasPanel canvas;
	private ArrayList<ColorDropdown> colorList;
	
	// constructor
	public PaintPanel() {
		// set the layout of this panel to be borderlayout
		super.setLayout(new BorderLayout());
		
		// add the color buttons
		//this.colorButtons = new ArrayList<ColorButton>();
		this.colorList = new ArrayList<ColorDropdown>();
		
		// we have 4 colors here. we can add more if we want.
		String[] colorNames = {"","Black", "Red", "Green", "Blue","YELLOW"};
		Color[] colors = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
		
		final JComboBox<String> cb = new JComboBox<String>(colorNames);
		// add these color buttons to a JPanel object for PAGE_START
		JPanel topPanel = new JPanel();
		
		// make this top panel to be a grid layout with 1 row and as many buttons as colors + reset
		topPanel.setLayout(new GridLayout(1, this.colorList.size() + 1));
		//cb.actionPerformed(null);
		cb.setVisible(true);
		topPanel.add(cb);
		// add the reset button
		
		this.resetButton = new JButton("Reset");
		
		// make this panel respond to the reset button
		this.resetButton.addActionListener(this);
		
		topPanel.add(this.resetButton);
		
		// add the top panel to the PAGE_START section
		super.add(topPanel, BorderLayout.PAGE_START);
		
		// create and add a canvaspanel
		canvas = new CanvasPanel();
		
		// add the canvas panel to the CENTER section
		super.add(canvas, BorderLayout.CENTER);
		
		cb.addActionListener(event -> {
            // Get the source of the component, which is our combo
            // box.
            JComboBox comboBox1 = (JComboBox) event.getSource();

            // Print the selected items and the action command.
            Object selected = cb.getSelectedItem();
            if(selected =="Black") {
            	Color x = Color.BLACK;
            	this.canvas.setPenColor(x);
            }
            else if(selected =="Red") {
            	Color x = Color.RED;
            	this.canvas.setPenColor(x);
            }
            else if(selected =="Green") {
            	Color x = Color.GREEN;
            	this.canvas.setPenColor(x);
            }
            else if(selected =="Blue") {
            	Color x = Color.BLUE;
            	this.canvas.setPenColor(x);
            }
            else if(selected =="YELLOW") {
            	Color x = Color.YELLOW;
            	this.canvas.setPenColor(x);
            }
		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// did the user press a color button
		
		// did the user press the reset button
		if (event.getSource() == this.resetButton) {
			// reset the canvas panel
			this.canvas.reset();
		}
	}

}
