package net.richardsprojects.TheBakery.animations;

import java.awt.Graphics2D;

public class TextAnimation extends Animation{

	private String animatedText;
	private int xCoordinate;
	private int yCoordinate;
	
	private int originalXCoordinate;
	private int originalYCoordinate;
	
	public boolean markedForDeletion = false;
	
	public TextAnimation(int x, int y, String text)
	{
		this.animatedText = text;
		this.originalXCoordinate = x;
		this.originalYCoordinate = y;
		this.yCoordinate = y;
		this.xCoordinate = x;
	}
	
	@Override
	public void update() {
		if(xCoordinate >= originalXCoordinate + 60)
		{
			this.markedForDeletion = true;
		}
		else
		{
			xCoordinate++;
			yCoordinate++;
		}
	}

	@Override
	public void render(Graphics2D backgroundG2d) {
		
		
	}

}
