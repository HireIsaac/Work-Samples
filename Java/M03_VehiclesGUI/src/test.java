import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class test {

	static Timer timer;
	static DrawHere d = new DrawHere();
	static JFrame frame;
	protected static int screenHeight, screenWidth;
	protected static int initDelay = 100, delay = 0;

	/**Sets jframe up and fills with content from drawhere.
	 * 
	 * Basically all of this is simply reused code from older programs created from examples.
	 * @param args
	 */
	public static void main(String[] args) {
		screenHeight = d.screenHeight;
		screenWidth = d.screenWidth;
		System.out.println("JFrame Starting..");
		
		// Set up jFrame window for drawing
		frame = new JFrame();
		d.addKeyListener(d);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screenWidth, screenHeight);
		frame.setVisible(true);
		frame.setContentPane(d);
		frame.getRootPane().setBackground(Color.WHITE);
		
		
		// Set up Timer
		timer = new Timer(delay, d); // Set time, and this object gets event
		timer.setInitialDelay(initDelay); // Initial wait
		timer.setCoalesce(true); // Don't stack up events
		timer.start(); // Start the timer object
		
		System.out.println("JFrame Started..");
	}
		
}		
		
		
		
		
		
		



