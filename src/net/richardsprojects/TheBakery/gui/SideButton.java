package net.richardsprojects.TheBakery.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import net.richardsprojects.TheBakery.GameState;
import net.richardsprojects.TheBakery.Images;
import net.richardsprojects.TheBakery.TheBakery;
import net.richardsprojects.TheBakery.input.MouseInput;
import net.richardsprojects.TheBakery.input.MouseInput2;

public class SideButton extends Button {
	
	private GameState gamestate;
	
	private int x;
	private int y;
	
	private boolean enabled;	
	private boolean hover = false;
	
	String text = "";
	
	public SideButton(String text, int x, int y, GameState gamestate)
	{
		this.gamestate = gamestate;
		this.text = text;
		this.x = x;
		this.y = y;
		this.enabled = true;
	}
	
	public SideButton(String text, int x, int y, boolean enabled, GameState gamestate)
	{
		this.gamestate = gamestate;
		this.text = text;
		this.x = x;
		this.y = y;
		this.enabled = enabled;
	}
	
	@Override
	public void render(Graphics2D g2d)
	{
		//Setup Text
		g2d.setColor(Color.white);
		Font font = new Font("Sans", Font.BOLD, 22);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
		RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(font);
		FontMetrics fm = TheBakery.panel.getFontMetrics(font);
		
		//Render appropiate image and text
		if(!hover)
		{
			//Render Image
			g2d.drawImage(Images.sideButton0, this.x, this.y, null);
			
			//Render Text
			g2d.drawString(text, this.x + 8, this.y + fm.getHeight() - 2);
		}
		else
		{
			//Render Image
			g2d.drawImage(Images.sideButton1, this.x, this.y, null);
			
			//Render Text
			g2d.drawString(text, this.x + 20, this.y + fm.getHeight() - 2);
		}
	}
	
	@Override
	public void handleInput()
	{
		//Check if button was clicked
		if(enabled)
		{
			if(MouseInput.mouseClicked)
			{
				if(MouseInput.x >= this.x && MouseInput.x <= this.x + 156 && MouseInput.y >= this.y && MouseInput.y <= this.y + 44)
				{
					MouseInput.mouseClicked = false;
					gamestate.handleButtonClick(text);
				}
			}
			//Check if button was "moused over"
			if(MouseInput2.mouseXLoc >= this.x && MouseInput2.mouseXLoc <= this.x + 156 && MouseInput2.mouseYLoc >= this.y && MouseInput2.mouseYLoc <= this.y + 44)
			{
				this.hover = true;
			}
			else
			{
				this.hover = false;
			}
		}
	}
}
