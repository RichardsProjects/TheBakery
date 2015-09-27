package net.richardsprojects.TheBakery.gui;

import net.richardsprojects.TheBakery.GamePanel;
import net.richardsprojects.TheBakery.GameState;
import net.richardsprojects.TheBakery.Images;
import net.richardsprojects.TheBakery.InputManager;
import net.richardsprojects.TheBakery.Loader;
import net.richardsprojects.TheBakery.quit;
import net.richardsprojects.TheBakery.input.MouseInput;
import net.richardsprojects.TheBakery.input.MouseInput2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;


public class GUI_Title extends GameState {

    // This is our custom JPanel
	public GamePanel root;

	private ArrayList<Button> buttons = new ArrayList<Button>();
	
	public GUI_Title(GamePanel gamePanel) {
		root = gamePanel;

		//Setup the buttons
		buttons.add(new SideButton("New Game", 0, 140, this));
		buttons.add(new SideButton("Load Game", 0, 224, this));
		buttons.add(new SideButton("Options", 0, 308, this));
		buttons.add(new SideButton("Instructions", 0, 392, this));
		buttons.add(new SideButton("Credits", 0, 476, this));
	}
	
    // We handle input here, and if the user presses the right 
    // arrow key, then we move to the level screen
	@Override
	public void handleInput() 
	{
		//Handle Input for each of the buttons
		for(Button btn : buttons)
		{
			btn.handleInput();
		}
	}

	
	@Override 
	public void render(Graphics g) {

		// Paint the background
		g.drawImage(Images.title, 0, 0, null);

		//Render the buttons
		for(Button btn : buttons)
		{
			btn.render((Graphics2D) g);
		}
	}

	@Override
	public void handleButtonClick(String name)
	{
		if(name.equals("New Game"))
		{
			root.changeState(GamePanel.SCENARIO_SELECTOR);
			System.out.println("Switching to \"Scenario Selector\"");
		}
		if(name.equals("Credits"))
		{
			root.changeState(GamePanel.CREDITS);
			System.out.println("Switching to \"Credits\"");
		}
	}
	
	//Not Needed as this UI has nothing that nees to update
	@Override
	public void update() {}
}