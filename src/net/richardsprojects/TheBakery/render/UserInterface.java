package net.richardsprojects.TheBakery.render;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.io.IOException;

import net.richardsprojects.TheBakery.GamePanel;
import net.richardsprojects.TheBakery.InputManager;
import net.richardsprojects.TheBakery.Loader;
import net.richardsprojects.TheBakery.TheBakery;
import net.richardsprojects.TheBakery.gui.GUI_InGame;
import net.richardsprojects.TheBakery.input.MouseInput;
import net.richardsprojects.TheBakery.input.MouseInput2;
import net.richardsprojects.TheBakery.objects.Oven;

public class UserInterface {
	
	//GamePanel
	private GamePanel root;
	
	//Booleans
	private boolean displayPanel;
	public boolean displayUI;
	private boolean ovenButtonHover = false;
	
	//Images
	private Image uiPanel;
	private Image uiOverlay;
	private Image upArrow;
	private Image downArrow;
	private Image timeControlsPaused;
	private Image timeControlsPlay;
	private Image timeControlsSpeed1;
	private Image timeControlsSpeed2;
	private Image buildTabOpen;
	private Image buildTabClosed;
	private Image statsTabOpen;
	private Image statsTabClosed;
	private Image buildMenuBackground;
	private Image ovenIcon;
	private Image ovenIconSelected;
	
	private String selectedPanel;
	
	public UserInterface(GamePanel gp)
	{
		//Set Values
		root = gp;
		displayPanel = true;
		displayUI = true;
		selectedPanel = "STATS";
		
		//Load Images
		uiOverlay = Loader.loadImage("images/UIOverlay2.png", root);
		uiPanel = Loader.loadImage("images/UIPanel.png", root);
		upArrow = Loader.loadImage("images/arrow-up.png", root);
		downArrow = Loader.loadImage("images/arrow-down.png", root);
		timeControlsPaused = Loader.loadImage("images/TimeControlsOverlay-paused.png", root);
		timeControlsPlay = Loader.loadImage("images/TimeControlsOverlay-play.png", root);
		timeControlsSpeed1 = Loader.loadImage("images/TimeControlsOverlay-speed1.png", root);
		timeControlsSpeed2 = Loader.loadImage("images/TimeControlsOverlay-speed2.png", root);
		buildTabOpen = Loader.loadImage("images/buildTabOpen.png", root);
		buildTabClosed = Loader.loadImage("images/buildTabClosed.png", root);
		statsTabOpen = Loader.loadImage("images/statsTabOpen.png", root);
		statsTabClosed = Loader.loadImage("images/statsTabClosed.png", root);
		buildMenuBackground = Loader.loadImage("images/build_background.png", root);
		ovenIcon = Loader.loadImage("images/ovenButton.png", root);
		ovenIconSelected = Loader.loadImage("images/ovenButton-selected.png", root);
	}
	
	public void render(Graphics2D g2d)
	{
		//Setup Clock and Money Panel
		g2d.drawImage(uiOverlay, 680, 469, null);
		printClock(g2d);
		
		//Setup main display panel
		if(displayPanel)
		{ 
			g2d.drawImage(uiPanel, 0, 436, null);
	
			//Draw Stats Panel	
			if(selectedPanel.equals("STATS")) renderStatsPanel(g2d);
			if(selectedPanel.equals("BUILD")) renderBuildPanel(g2d);

			//Draw Stats Panel Icon
			if(selectedPanel.equals("STATS"))
			{
				g2d.drawImage(statsTabOpen, 176, 463, null);
			}
			else
			{
				g2d.drawImage(statsTabClosed, 176, 463, null);
			}
			//Draw Build Panel Icon
			if(selectedPanel.equals("BUILD"))
			{
				g2d.drawImage(buildTabOpen, 213, 463, null);
			}
			else
			{
				g2d.drawImage(buildTabClosed, 213, 463, null);
			}
				
			//Draw the Down arrow
			g2d.drawImage(downArrow, 300, 580, null);
			}
		else
		{
			//Draw Up Arrow - because panel is currently hidden				
			g2d.drawImage(upArrow, 300, 580, null);
		}
	}
	
	public void handleInput()
	{
		if(InputManager.keyPressed == KeyEvent.VK_ESCAPE)
		{
			if(TheBakery.objectPlacementMode)
			{
				TheBakery.objectPlacementMode = false;
				TheBakery.selectedObject = null;
				InputManager.keyPressed = 0;
			}
		}
		if(InputManager.keyPressed == KeyEvent.VK_F1)
		{
			//Toggle UI Display
			if(displayUI)
			{
				displayUI = false;
			}
			else
			{
				displayUI = true;
			}
			InputManager.keyPressed = 0;
		}
		
		//Check if the up/down arrow was clicked
		if(MouseInput.mouseClicked)
		{
			if(MouseInput.x > 300 && MouseInput.y > 580 && MouseInput.x < 351)
			{
				if(displayPanel)
				{
					displayPanel = false;
				}
				else
				{
					displayPanel = true;
					
				}
				MouseInput.mouseClicked = false;
				return;
			}
			if(MouseInput.x > 701 && MouseInput.y > 502 && MouseInput.x < 712 && MouseInput.y < 516)
			{
				//Pause Button Clicked
				TheBakery.gameSpeed = 0;
				MouseInput.mouseClicked = false;
				return;
			}
			if(MouseInput.x > 717 && MouseInput.y > 502 && MouseInput.x < 728 && MouseInput.y < 516)
			{
				//Play Button Clicked
				TheBakery.gameSpeed = 1;
				MouseInput.mouseClicked = false;
				return;
			}
			if(MouseInput.x > 738 && MouseInput.y > 502 && MouseInput.x < 756 && MouseInput.y < 516)
			{
				//Speed 1 Button Clicked
				TheBakery.gameSpeed = 2;
				MouseInput.mouseClicked = false;
				return;
			}
			if(MouseInput.x > 763 && MouseInput.y > 502 && MouseInput.x < 785 && MouseInput.y < 516)
			{
				//Speed 2 Button Clicked
				TheBakery.gameSpeed = 3;
				MouseInput.mouseClicked = false;
				return;
			}
			// TODO: These coordinates are currently incorrect for the stats and build panel
			if(MouseInput.x > 176 && MouseInput.x < 262 && MouseInput.y > 463 && MouseInput.y < 494)
			{
				//Stats Tab Clicked
				selectedPanel = "STATS";
				MouseInput.mouseClicked = false;
				return;
			}
			if(MouseInput.x > 213 && MouseInput.x < 249 && MouseInput.y > 463 && MouseInput.y < 494)
			{
				//Build Tab Clicked
				selectedPanel = "BUILD";
				MouseInput.mouseClicked = false;
				return;
			}
			//Check if oven button has been clicked
			if(MouseInput.x >= 180 && MouseInput.y >= 350 && MouseInput.x <= 355 && MouseInput.y <= 420)
			{
				TheBakery.objectPlacementMode = true;
				try {
					TheBakery.selectedObject = new Oven(false, -1, -1);
				} catch (IOException e) {
				}
				MouseInput.mouseClicked = false;
				return;
			}
			if(TheBakery.objectPlacementMode)
			{
				TheBakery.objectPlacementMode = false;
				try {
					if(TheBakery.money - TheBakery.selectedObject.getCostValue() >= 0)
					{
						//TODO: Render - money value animation
						GUI_InGame.kaching.play();
						TheBakery.money = TheBakery.money - TheBakery.selectedObject.getCostValue();
						TheBakery.totalExpenses = TheBakery.totalExpenses + TheBakery.selectedObject.getCostValue();
						TheBakery.purchases = TheBakery.selectedObject.getCostValue() + TheBakery.purchases;
						GUI_InGame.objectData[TheBakery.xCoordinate][TheBakery.yCoordinate] = new Oven(true, TheBakery.xCoordinate, TheBakery.yCoordinate);
						TheBakery.selectedObject = null;
					}
					else
					{
						//TODO: Render not enough money animation
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				TheBakery.selectedObject = null;
			}
			
			
		}
		
		//Handle Mouse Hover
		if(MouseInput2.mouseMoved)
		{
			if(MouseInput2.mouseXLoc >= 180 && MouseInput2.mouseYLoc >= 350 && MouseInput2.mouseXLoc <= 355 && MouseInput2.mouseYLoc <= 420)
			{
				ovenButtonHover = true;
			}
			else
			{
				ovenButtonHover = false;
			}
		}
	}
	
	//A private method included to print the clock
	private void printClock(Graphics2D g2d)
	{
		//Print Text
		g2d.setColor(Color.red);
		Font font = new Font("Courier New", Font.BOLD, 14);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
		RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(font);
		FontMetrics fm = root.getFontMetrics(font);
	
		String hourString = TheBakery.inGameHour + "";
		String minuteString = TheBakery.inGameMinute + "";
	
		if(hourString.length() > 1)
		{
			hourString = TheBakery.inGameHour + "";			
		}
		else
		{
			hourString = "0" + TheBakery.inGameHour;
		}
	
		if(minuteString.length() > 1)
		{
			minuteString = TheBakery.inGameMinute + "";
		}
		else
		{
			minuteString = "0" + TheBakery.inGameMinute;
		}
	
	
		String str = "Day " + TheBakery.inGameDay + " " +hourString + ":" + minuteString;
		g2d.drawString(str, 692, 490);
		g2d.drawRect(688, 477, 104, 18);
		
		//Add In Time Controls
		if(TheBakery.gameSpeed == 0) g2d.drawImage(timeControlsPaused, 701, 502, null);
		if(TheBakery.gameSpeed == 1) g2d.drawImage(timeControlsPlay, 701, 502, null);
		if(TheBakery.gameSpeed == 2) g2d.drawImage(timeControlsSpeed1, 701, 502, null);
		if(TheBakery.gameSpeed == 3) g2d.drawImage(timeControlsSpeed2, 701, 502, null);
		
		//Draw Money Section
		int yStart = 602 - fm.getHeight() - 14;
		g2d.drawString("$", 692, 602 - fm.getHeight());
		g2d.drawString(TheBakery.money + "", 706, 602 - fm.getHeight());
		g2d.drawRect(704, yStart, 88, 18);
	}
	
	// TODO: Center UI hide button
	
	private void renderStatsPanel(Graphics2D g2d)
	{
		g2d.setColor(Color.white);
		g2d.drawString("Bakery Name: " + TheBakery.bakeryName, 174, 506);
		g2d.drawString("Money Earned: $" + TheBakery.moneyEarned, 174, 520);
		g2d.drawString("Expenses: $" + TheBakery.totalExpenses, 174, 538);
		g2d.drawString("Salaries: $" + TheBakery.salaries, 190, 552);
		g2d.drawString("Purchases: $" + TheBakery.purchases, 190, 566);
	}
	
	private void renderBuildPanel(Graphics2D g2d)
	{
		g2d.drawImage(buildMenuBackground, 172, 494, null);
		if(ovenButtonHover == false)
		{
			g2d.drawImage(ovenIcon, 180, 500, null);
		}
		else
		{
			g2d.drawImage(ovenIconSelected, 180, 500, null);
		}
	}

}