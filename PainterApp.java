import javax.swing.JFrame;

/**
 * 
 * @author Anamo Kisho
 *
 */
public class PainterApp {

	public static void main(String[] args) {
		// create a new frame
		JFrame painterFrame = new JFrame("Painter");
		
		// when the window is closed, terminate the java application
		painterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add a new BallPanel object to the animation frame
		painterFrame.getContentPane().add(new PaintPanel());
		
		// pack the frame
		painterFrame.pack();
		
		// make the frame visible
		painterFrame.setVisible(true);

	}

}
