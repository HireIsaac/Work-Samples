

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import java.util.ArrayList;



/**
 * Main drawing class, declares objects to use and clip, which is used to store static balls.
 * @author Isaac Lohnes
 *
 */
public class DrawHere extends JPanel implements ActionListener, KeyListener {

	protected int screenHeight, screenWidth;
	Random rand = new Random();
	ArrayList<vehicle> vehicles;
	/**
	 * Sets up drawing, makes balls and paddles, and adds static balls.
	 */
	public DrawHere() {
		
		vehicles = new ArrayList<vehicle>();
		airVehicle f;
		vehicles.add(f = new airVehicle(6));
		
		for(vehicle v :vehicles) {
			v.start();
		}
		
		
		
		screenHeight = 1000;
		screenWidth = 1500;
		this.setFocusable(true);
		this.requestFocusInWindow();

	}

	public void paintComponent(Graphics g) {
		
		// Setup and clear the buffer
		BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_BGR);
		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.setColor(getBackground());
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight()); // fill with color

		// Draw on the buffer
		for(vehicle v :vehicles) {
			v.paint(g2d);
		}
		
		
		
		// Set the buffer to be visible
		Graphics2D g2dComponent = (Graphics2D) g;
		g2dComponent.drawImage(bufferedImage, null, 0, 0);
	}


	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
		
		
		
			
		// Take focus if we don't have it
		if (!this.isFocusOwner()) {
			this.requestFocusInWindow();
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		    int key = arg0.getKeyCode();

		    if (key == KeyEvent.VK_LEFT) {
		    	airVehicle a = new airVehicle(0);
		    	a.start();
		    	vehicles.add(a);
		    }

		    if (key == KeyEvent.VK_RIGHT) {
		    	landVehicle b = new landVehicle(0);
		    	b.start();
		    	vehicles.add(b);
		        
		    }

		    if (key == KeyEvent.VK_UP) {
		    	for(vehicle v :vehicles) {
		    		vehicles.clear();
				}
		    }

		    if (key == KeyEvent.VK_DOWN) {
		        for(vehicle v :vehicles) {
		        	v.direction += 90;
		        }
		    }
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
