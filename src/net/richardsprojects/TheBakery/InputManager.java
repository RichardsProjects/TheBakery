package net.richardsprojects.TheBakery;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {
	
	public static boolean shiftPressed = false;
	public static boolean escapePressed = false;
	
	private boolean keyPressedAlready = false;
	
	public static boolean iskeyPressed = false;
	public static int keyPressed = 0;

	@Override
	public void keyPressed(KeyEvent e) {
		if(!keyPressedAlready)
		{
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_SHIFT)
			{
				shiftPressed = true;
			}
			else
			{
				if (key == KeyEvent.VK_ESCAPE)
				{
					escapePressed = true;
				}
			iskeyPressed = true;
			keyPressed = key;
			keyPressedAlready = true;
			}
		}
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
            // Edited this part due to pbl.
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_SHIFT)
            {
            	shiftPressed = false;
            }
            else
            {
        		iskeyPressed = false;
        		keyPressed = 0;
        		keyPressedAlready = false;
            }

	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		//Required but not needed method
		
	}
}

