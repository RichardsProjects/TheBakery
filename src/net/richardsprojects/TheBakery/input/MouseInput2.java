package net.richardsprojects.TheBakery.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseInput2 implements MouseMotionListener  {

	public static int mouseXLoc = 0;
	public static int mouseYLoc = 0;
	public static boolean mouseMoved = false;
	
	@Override
	public void mouseDragged(MouseEvent arg0) {

		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {

		mouseXLoc = arg0.getX();
		mouseYLoc = arg0.getY();
		mouseMoved = true;
		
		
	}

}
