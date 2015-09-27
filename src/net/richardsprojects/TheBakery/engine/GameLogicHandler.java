package net.richardsprojects.TheBakery.engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import net.richardsprojects.TheBakery.InputManager;
import net.richardsprojects.TheBakery.gui.GUI_InGame;
import net.richardsprojects.TheBakery.input.MouseInput2;

public class GameLogicHandler implements ActionListener {

	private GUI_InGame game = null;
	
	public GameLogicHandler(GUI_InGame game)
	{
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//Update position of x and y based on mouse cursor position
		
		//Check left-side
		if(MouseInput2.mouseXLoc > 0 && MouseInput2.mouseXLoc < 60 && MouseInput2.mouseYLoc > 0) game.cam.setX(game.cam.getX() - 16, "-");
		//Check top-side
		if(MouseInput2.mouseXLoc > 0 && MouseInput2.mouseYLoc > 0 && MouseInput2.mouseYLoc < 60) game.cam.setY(game.cam.getY() - 16, "-");
		//Check bottom-side
		if(MouseInput2.mouseYLoc > 540) game.cam.setY(game.cam.getY() + 16, "+");
		//Check right-side
		if(MouseInput2.mouseXLoc > 740) game.cam.setX(game.cam.getX() + 16, "+");
		
		//Check for keyboard input
		if(InputManager.keyPressed == KeyEvent.VK_A) game.cam.setX(game.cam.getX() - 16, "-");
		if(InputManager.keyPressed == KeyEvent.VK_D) game.cam.setX(game.cam.getX() + 16, "+");
		if(InputManager.keyPressed == KeyEvent.VK_S) game.cam.setY(game.cam.getY() + 16, "+");
		if(InputManager.keyPressed == KeyEvent.VK_W) game.cam.setY(game.cam.getY() - 16, "-");
		
		//Handle actual logic such as object animations and object movement later on
		
		
	}

}
