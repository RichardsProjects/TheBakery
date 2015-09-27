package net.richardsprojects.TheBakery.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;


public class MouseInput implements MouseListener {
	
	//Type of Click - left (0) or right (1)
	public static int typeOfClick = -1;
	
	//X coordinate of the click
	public static int x = 0;
	
	//Y coordinate of the click
	public static int y = 0;
	
	//Has mouse been clicked
	public static boolean mouseClicked = false;
	

	public void mouseMoved(MouseEvent arg0) {
		//Required but not needed method
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		//Required but not needed method			
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		//Required but not needed method
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		//Required but not needed method
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		//Required but not needed method
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

		mouseClicked = true;
		if(SwingUtilities.isLeftMouseButton(arg0)) {
			typeOfClick = 0;
			x = arg0.getX();
			y = arg0.getY();			
		}
		if(SwingUtilities.isRightMouseButton(arg0)) {
			typeOfClick = 1;
			x = arg0.getX();
			y = arg0.getY();			
		}	
		
	}

}
