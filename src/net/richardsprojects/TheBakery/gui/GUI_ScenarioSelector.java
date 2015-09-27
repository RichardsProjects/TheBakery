package net.richardsprojects.TheBakery.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import net.richardsprojects.TheBakery.GamePanel;
import net.richardsprojects.TheBakery.GameState;
import net.richardsprojects.TheBakery.Images;
import net.richardsprojects.TheBakery.Loader;
import net.richardsprojects.TheBakery.TheBakery;
import net.richardsprojects.TheBakery.input.MouseInput;
import net.richardsprojects.TheBakery.input.MouseInput2;

public class GUI_ScenarioSelector extends GameState {

	// This is our custom JPanel
	private GamePanel root;
	
	private ArrayList<Button> buttons = new ArrayList<Button>();
	
	private CenteredButton continueBtn = new CenteredButton("Continue", 348, 403, true, this);
	private CenteredButton backBtn = new CenteredButton("Back", 138, 403, false, this);
	
	private String selectedScenario = "";
	
	public GUI_ScenarioSelector(GamePanel gp)
	{
		//Set the GamePanel
		root = gp;
		
		//Add main menu buttons but not enabled
		buttons.add(new SideButton("New Game", 0, 140, false, this));
		buttons.add(new SideButton("Load Game", 0, 224, false, this));
		buttons.add(new SideButton("Options", 0, 308, false, this));
		buttons.add(new SideButton("Instructions", 0, 392, false, this));
		buttons.add(new SideButton("Credits", 0, 476, false, this));
		
		//Create continue and back buttons
		
	}

	@Override
	public void render(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		
		//Render the background
		g.drawImage(Images.title, 0, 0, null);

		//Render the buttons
		for(Button btn : buttons)
		{
			btn.render((Graphics2D) g);
		}
		
		//Render the dialog
		g.drawImage(Images.scenarioSelector, 120, 150, null);
		
		//Render Buttons
		continueBtn.render(g2d);
		backBtn.render(g2d);
		
		//Render which scenario is selected
		if(selectedScenario.equals("Mega Money"))
		{
			g2d.drawImage(Images.megaMoneySelected, 139, 181, null);
		}
		if(selectedScenario.equals("Cunning Competitors"))
		{
			g2d.drawImage(Images.cunningCompetitorsSelected, 139, 231, null);
		}
	}

	@Override
	public void handleInput() throws IOException {
		
		//Handle Input for scenario selected
		if(MouseInput.mouseClicked)
		{
			//Mega Money clicked
			if(MouseInput.x >= 139 && MouseInput.x <= 480 && MouseInput.y >= 181 && MouseInput.y <= 229)
			{
				if(selectedScenario.equals("Mega Money"))
				{
					selectedScenario = "";
					TheBakery.scenario = 0;
					continueBtn.setGrayedOut(true);
				}
				else
				{
					selectedScenario = "Mega Money";
					TheBakery.scenario = 1;
					continueBtn.setGrayedOut(false);
				}
				MouseInput.mouseClicked = false;
			}
			//Cunning Competitors Clicked
			if(MouseInput.x >= 139 && MouseInput.x <= 480 && MouseInput.y >= 231 && MouseInput.y <= 279)
			{
				if(selectedScenario.equals("Cunning Competitors"))
				{
					selectedScenario = "";
					TheBakery.scenario = 0;
					continueBtn.setGrayedOut(true);
				}
				else
				{
					selectedScenario = "Cunning Competitors";
					TheBakery.scenario = 2;
					continueBtn.setGrayedOut(false);
				}
				MouseInput.mouseClicked = false;
			}
		}
		
		//Handle Input of buttons
		continueBtn.handleInput();
		backBtn.handleInput();
		
	}

	@Override
	public void handleButtonClick(String text)
	{
		if(text.equals("Back"))
		{
			root.changeState(GamePanel.TITLE);
			System.out.println("Returning to title screen.");
		}
		if(text.equals("Continue") && TheBakery.scenario > 0)
		{
			root.changeState(GamePanel.GAME_SETUP);
			System.out.println("Switching to Game Setup.");
		}
	}
	
	//Not Needed
	@Override
	public void update() {}	
}
