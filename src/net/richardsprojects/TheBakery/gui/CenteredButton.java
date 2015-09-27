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

public class CenteredButton extends Button {

	private GameState gamestate;
	
	private int x;
	private int y;
	
	private boolean grayedOut;	
	private boolean hover = false;
	
	String text = "";
	
	public CenteredButton(String text, int x, int y, boolean grayedOut, GameState gamestate)
	{
		this.gamestate = gamestate;
		this.text = text;
		this.x = x;
		this.y = y;
		this.grayedOut = grayedOut;
	}
	
	@Override
	public void render(Graphics2D g2d)
	{
		//Render Image
		if(grayedOut)
		{
			g2d.drawImage(Images.centeredButton2, this.x, this.y, null);
		}
		if(!grayedOut && hover == true)
		{
			g2d.drawImage(Images.centeredButton1, this.x, this.y, null);
		}
		if(!grayedOut && !hover)
		{
			g2d.drawImage(Images.centeredButton0, this.x, this.y, null);
		}
		
		//Setup Text
		g2d.setColor(Color.white);
		Font font = new Font("Sans", Font.BOLD, 22);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
		RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(font);
		FontMetrics fm = TheBakery.panel.getFontMetrics(font);
		
		//Render Text
		int textWidth = fm.stringWidth(this.text);
		int offset = (137 - textWidth)/2;
		
		g2d.drawString(this.text, this.x + offset, this.y + fm.getHeight() - 2);
		
	}

	@Override
	public void handleInput()
	{
		if(!grayedOut)
		{
			if(MouseInput.mouseClicked)
			{
				if(MouseInput.x >= this.x && MouseInput.x <= this.x + 137 && MouseInput.y >= this.y && MouseInput.y <= this.y + 39)
				{
					MouseInput.mouseClicked = false;
					gamestate.handleButtonClick(text);
				}
			}
			//Check if button was "moused over"
			if(MouseInput2.mouseXLoc >= this.x && MouseInput2.mouseXLoc <= this.x + 137 && MouseInput2.mouseYLoc >= this.y && MouseInput2.mouseYLoc <= this.y + 39)
			{
				this.hover = true;
			}
			else
			{
				this.hover = false;
			}
		}
	}
	
	public void setGrayedOut(boolean grayed)
	{
		this.grayedOut = grayed;
	}

}
