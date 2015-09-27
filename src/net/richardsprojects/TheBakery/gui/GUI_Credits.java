package net.richardsprojects.TheBakery.gui;

import net.richardsprojects.TheBakery.GamePanel;
import net.richardsprojects.TheBakery.GameState;
import net.richardsprojects.TheBakery.InputManager;
import net.richardsprojects.TheBakery.Loader;
import net.richardsprojects.TheBakery.quit;
import net.richardsprojects.TheBakery.input.MouseInput;
import net.richardsprojects.TheBakery.input.MouseInput2;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class GUI_Credits extends GameState {

    // This is our custom JPanel
	private GamePanel root;

	private ArrayList<Button> buttons = new ArrayList<Button>();


	public GUI_Credits(GamePanel gamePanel) {
		root = gamePanel;
		
		buttons.add(new SideButton("Back", 0, 460, this));
	}
	
	@Override
	public void handleInput() 
	{
		for(Button btn : buttons)
		{
			btn.handleInput();
		}
	}
	
	@Override 
	public void render(Graphics g) {
		//Clear the background
		Graphics2D g2d = (Graphics2D)g;
		g.clearRect(0,0, 650, 450);
		
		//Draw a solid color background
		g2d.setColor(new Color(145, 116, 0));
		g2d.fillRect(0, 0, 800, 600);
	
		//Setup Text
		g2d.setColor(Color.white);
		Font font = new Font("Courier New", Font.BOLD, 16);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
		RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(font);
		FontMetrics fm = root.getFontMetrics(font);
		
		//Print Credits
		String str = "Artwork & Programming";
		int x = 2;
		int y = (fm.getHeight()*3);
		g2d.drawString(str, x, y);
		
		str = "Richard Bimmer";
		y = y + (fm.getHeight()*1);
		g2d.drawString(str, x, y);
		
		str = "Concept & Game Mechanics";
		y = y + (fm.getHeight()*3);
		g2d.drawString(str, x, y);
		
		str = "Tallyn Clark";
		y = y + (fm.getHeight()*1);
		g2d.drawString(str, x, y);
		
		str = "Sound Effects";
		y = y + (fm.getHeight()*3);
		g2d.drawString(str, x, y);
		
		str = "http://www.soundfxnow.com/";
		y = y + (fm.getHeight());
		g2d.drawString(str, x, y);
		
		str = "Music";
		y = y + (fm.getHeight()*3);
		g2d.drawString(str, x, y);
		
		str = "Cattails - Kevin MacLeod";
		y = y + (fm.getHeight());
		g2d.drawString(str, x, y);
		
		//Handle Rendering Buttons
		for(Button btn : buttons)
		{
			btn.render(g2d);
		}
		
	}

    //Not needed in this state
	@Override
	public void update() {}

	@Override
	public void handleButtonClick(String text)
	{
		if(text.equals("Back"))
		{
			root.changeState(GamePanel.TITLE);
			System.out.println("Switching to title screen.");
		}
	}

}

