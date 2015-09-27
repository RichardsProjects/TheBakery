package net.richardsprojects.TheBakery.gui;

import net.richardsprojects.TheBakery.GamePanel;
import net.richardsprojects.TheBakery.GameState;
import net.richardsprojects.TheBakery.Images;
import net.richardsprojects.TheBakery.InputManager;
import net.richardsprojects.TheBakery.Loader;
import net.richardsprojects.TheBakery.TheBakery;
import net.richardsprojects.TheBakery.input.MouseInput;
import net.richardsprojects.TheBakery.input.MouseInput2;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class GUI_GameSetup extends GameState {

    // This is our custom JPanel
	private GamePanel root;
	
	private ArrayList<Button> buttons = new ArrayList<Button>();
	
	private boolean textbox_selected = false;
	
	private String textboxValue;
	
	private CenteredButton continueBtn = new CenteredButton("Continue", 315, 391, true, this);
	private CenteredButton backBtn = new CenteredButton("Back", 152, 391, false, this);
	
	

	public GUI_GameSetup(GamePanel gamePanel) {
		root = gamePanel;
		

		textboxValue = "";
		
		//Add main menu buttons but not enabled
		buttons.add(new SideButton("New Game", 0, 140, false, this));
		buttons.add(new SideButton("Load Game", 0, 224, false, this));
		buttons.add(new SideButton("Options", 0, 308, false, this));
		buttons.add(new SideButton("Instructions", 0, 392, false, this));
		buttons.add(new SideButton("Credits", 0, 476, false, this));
		
	}
	
	@Override
	public void handleInput() 
	{
		//Handle Textbox selection
		if(MouseInput.mouseClicked && MouseInput.x >= 180 & MouseInput.x <= 477 && MouseInput.y >= 334 && MouseInput.y <= 379)
		{
			textbox_selected = true;
			MouseInput.mouseClicked = false;
		}
		
		//Handle Input for "Easy", "Medium", & "Hard" buttons
		//Easy Button
		if(MouseInput.mouseClicked && MouseInput.x >= 155 && MouseInput.x <= 222 && MouseInput.y >= 213 && MouseInput.y <= 238)
		{
			if(TheBakery.difficulty.equals("Easy"))
			{
				TheBakery.difficulty = "";
			}
			else
			{
				TheBakery.difficulty = "Easy";
			}
			MouseInput.mouseClicked = false;
		}
		//Medium Button
		if(MouseInput.mouseClicked && MouseInput.x >= 237 && MouseInput.x <= 352 && MouseInput.y >= 212 && MouseInput.y <= 232)
		{
			if(TheBakery.difficulty.equals("Medium"))
			{
				TheBakery.difficulty = "";
			}
			else
			{
				TheBakery.difficulty = "Medium";
			}
			MouseInput.mouseClicked = false;
		}
		//Hard Button
		if(MouseInput.mouseClicked && MouseInput.x >= 366 && MouseInput.x <= 434 && MouseInput.y >= 211 && MouseInput.y <= 232)
		{
			if(TheBakery.difficulty.equals("Hard"))
			{
				TheBakery.difficulty = "";
			}
			else
			{
				TheBakery.difficulty = "Hard";
			}
			MouseInput.mouseClicked = false;
		}
		
		//Handle Input for back and continue buttons
		continueBtn.handleInput();
		backBtn.handleInput();
		
		//Handles Input For the textbox
		if(InputManager.iskeyPressed && textbox_selected) 
		{
			if(textboxValue.length() <= 13)
			{
				if(InputManager.keyPressed == KeyEvent.VK_BACK_SPACE && textboxValue.length() > 0)
				{
					textboxValue = textboxValue.substring(0, textboxValue.length() - 1);
					System.out.println("Textbox Value: " + textboxValue);
					InputManager.iskeyPressed = false;
				}
				if(InputManager.shiftPressed)
				{
					if(InputManager.keyPressed == KeyEvent.VK_A) textboxValue = textboxValue + "A";
					if(InputManager.keyPressed == KeyEvent.VK_B) textboxValue = textboxValue + "B";
					if(InputManager.keyPressed == KeyEvent.VK_C) textboxValue = textboxValue + "C";
					if(InputManager.keyPressed == KeyEvent.VK_D) textboxValue = textboxValue + "D";
					if(InputManager.keyPressed == KeyEvent.VK_E) textboxValue = textboxValue + "E";
					if(InputManager.keyPressed == KeyEvent.VK_F) textboxValue = textboxValue + "F";
					if(InputManager.keyPressed == KeyEvent.VK_G) textboxValue = textboxValue + "G";
					if(InputManager.keyPressed == KeyEvent.VK_H) textboxValue = textboxValue + "H";
					if(InputManager.keyPressed == KeyEvent.VK_I) textboxValue = textboxValue + "I";
					if(InputManager.keyPressed == KeyEvent.VK_J) textboxValue = textboxValue + "J";
					if(InputManager.keyPressed == KeyEvent.VK_K) textboxValue = textboxValue + "K";
					if(InputManager.keyPressed == KeyEvent.VK_L) textboxValue = textboxValue + "L";
					if(InputManager.keyPressed == KeyEvent.VK_M) textboxValue = textboxValue + "M";
					if(InputManager.keyPressed == KeyEvent.VK_N) textboxValue = textboxValue + "N";
					if(InputManager.keyPressed == KeyEvent.VK_O) textboxValue = textboxValue + "O";
					if(InputManager.keyPressed == KeyEvent.VK_P) textboxValue = textboxValue + "P";
					if(InputManager.keyPressed == KeyEvent.VK_Q) textboxValue = textboxValue + "Q";
					if(InputManager.keyPressed == KeyEvent.VK_R) textboxValue = textboxValue + "R";
					if(InputManager.keyPressed == KeyEvent.VK_S) textboxValue = textboxValue + "S";
					if(InputManager.keyPressed == KeyEvent.VK_T) textboxValue = textboxValue + "T";
					if(InputManager.keyPressed == KeyEvent.VK_U) textboxValue = textboxValue + "U";
					if(InputManager.keyPressed == KeyEvent.VK_V) textboxValue = textboxValue + "V";
					if(InputManager.keyPressed == KeyEvent.VK_W) textboxValue = textboxValue + "W";
					if(InputManager.keyPressed == KeyEvent.VK_X) textboxValue = textboxValue + "X";
					if(InputManager.keyPressed == KeyEvent.VK_Y) textboxValue = textboxValue + "Y";
					if(InputManager.keyPressed == KeyEvent.VK_Z) textboxValue = textboxValue + "Z";
				}
				else
				{
					if(InputManager.keyPressed == KeyEvent.VK_A) textboxValue = textboxValue + "a";
					if(InputManager.keyPressed == KeyEvent.VK_B) textboxValue = textboxValue + "b";
					if(InputManager.keyPressed == KeyEvent.VK_C) textboxValue = textboxValue + "c";
					if(InputManager.keyPressed == KeyEvent.VK_D) textboxValue = textboxValue + "d";
					if(InputManager.keyPressed == KeyEvent.VK_E) textboxValue = textboxValue + "e";
					if(InputManager.keyPressed == KeyEvent.VK_F) textboxValue = textboxValue + "f";
					if(InputManager.keyPressed == KeyEvent.VK_G) textboxValue = textboxValue + "g";
					if(InputManager.keyPressed == KeyEvent.VK_H) textboxValue = textboxValue + "h";
					if(InputManager.keyPressed == KeyEvent.VK_I) textboxValue = textboxValue + "i";
					if(InputManager.keyPressed == KeyEvent.VK_J) textboxValue = textboxValue + "j";
					if(InputManager.keyPressed == KeyEvent.VK_K) textboxValue = textboxValue + "k";
					if(InputManager.keyPressed == KeyEvent.VK_L) textboxValue = textboxValue + "l";
					if(InputManager.keyPressed == KeyEvent.VK_M) textboxValue = textboxValue + "m";
					if(InputManager.keyPressed == KeyEvent.VK_N) textboxValue = textboxValue + "n";
					if(InputManager.keyPressed == KeyEvent.VK_O) textboxValue = textboxValue + "o";
					if(InputManager.keyPressed == KeyEvent.VK_P) textboxValue = textboxValue + "p";
					if(InputManager.keyPressed == KeyEvent.VK_Q) textboxValue = textboxValue + "q";
					if(InputManager.keyPressed == KeyEvent.VK_R) textboxValue = textboxValue + "r";
					if(InputManager.keyPressed == KeyEvent.VK_S) textboxValue = textboxValue + "s";
					if(InputManager.keyPressed == KeyEvent.VK_T) textboxValue = textboxValue + "t";
					if(InputManager.keyPressed == KeyEvent.VK_U) textboxValue = textboxValue + "u";
					if(InputManager.keyPressed == KeyEvent.VK_V) textboxValue = textboxValue + "v";
					if(InputManager.keyPressed == KeyEvent.VK_W) textboxValue = textboxValue + "w";
					if(InputManager.keyPressed == KeyEvent.VK_X) textboxValue = textboxValue + "x";
					if(InputManager.keyPressed == KeyEvent.VK_Y) textboxValue = textboxValue + "y";
					if(InputManager.keyPressed == KeyEvent.VK_Z) textboxValue = textboxValue + "z";
					if(InputManager.keyPressed == KeyEvent.VK_SPACE) textboxValue = textboxValue + " ";
				}
				System.out.println("Textbox Value: " + textboxValue);
				InputManager.iskeyPressed = false;
			}
			else
			{
				if(InputManager.keyPressed == KeyEvent.VK_BACK_SPACE)
				{
					textboxValue = textboxValue.substring(0, textboxValue.length() - 1);
					System.out.println("Textbox Value: " + textboxValue);
					InputManager.iskeyPressed = false;
				}
			}		
		}
		if(MouseInput.mouseClicked)
		{
			textbox_selected = false;
			MouseInput.mouseClicked = false;
		}
	}
	
	@Override 
	public void render(Graphics g) {
		//Clear the background
		Graphics2D g2d = (Graphics2D)g;
		g.clearRect(0,0, 650, 450);
		
		//Draw the title screen
		g.drawImage(Images.title, 0, 0, null);
		
		//Render Buttons
		for(Button btn : buttons)
		{
			btn.render(g2d);
		}
		
		//Render Dialog
		g.drawImage(Images.gameSetup, 120, 150, null);
		
		continueBtn.render(g2d);
		backBtn.render(g2d);
		
		//Draw Difficulty Setting
		if(TheBakery.difficulty.equals("Easy")) g.drawImage(Images.easyIcon, 151, 206, null);
		if(TheBakery.difficulty.equals("Medium")) g.drawImage(Images.mediumIcon, 231, 206, null);
		if(TheBakery.difficulty.equals("Hard")) g.drawImage(Images.hardIcon, 361, 208, null);
		
		//Render text
		g2d.setColor(Color.gray);
		Font font = new Font("Courier New", Font.BOLD, 32);
		g2d.setFont(font);
		FontMetrics fm = root.getFontMetrics(font);
		if(textboxValue.length() > 0)
		{
			if(textbox_selected)
			{
				int textWidth = 0;
				
				g2d.setColor(Color.black);
				for (char ch: textboxValue.toCharArray()) {
					String s = "" + ch;
					g2d.drawString(s, textWidth + 162, 326 + fm.getHeight());
					textWidth = textWidth + fm.stringWidth(s);
				}
				
				g.drawImage(Images.textBoxCursor, 165 + textWidth, 338, null);
			}
			else
			{
				int textWidth = 0;
				
				g2d.setColor(Color.gray);
				for (char ch: textboxValue.toCharArray()) {
					String s = "" + ch;
					g2d.drawString(s, textWidth + 162, 326 + fm.getHeight());
					textWidth = textWidth + fm.stringWidth(s);
				}
			}
		}
		else
		{
			if(textbox_selected)
			{
				
				g.drawImage(Images.textBoxCursor, 165, 338, null);
			}
		}
		
	}

	@Override
	public void update()
	{
		if(TheBakery.difficulty.length() > 0 && textboxValue.length() > 0)
		{
			continueBtn.setGrayedOut(false);
		}
		else
		{
			continueBtn.setGrayedOut(true);
		}
	}		
		

	@Override
	public void handleButtonClick(String text)
	{
		if(text.equals("Back"))
		{
			root.changeState(GamePanel.SCENARIO_SELECTOR);
			System.out.println("Returning to Scenario Selector");
		}
		if(text.equals("Continue"))
		{
			//Set BakeryName
			TheBakery.bakeryName = textboxValue;
			
			//Change State
			root.changeState(GamePanel.IN_GAME);
			System.out.println("Switching to in game state.");			
		}
	}

}