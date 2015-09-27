package net.richardsprojects.TheBakery.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Oven extends Object {

	
	public BufferedImage iconPurchased;
	public BufferedImage iconNotPurchased;
	
	private int xCoordinate = 0;
	private int yCoordinate = 0;
	
	private boolean purchased;
	
	public Oven(boolean purchased, int x, int y) throws IOException
	{
		this.purchased = purchased;
		
		this.xCoordinate = x;
		this.yCoordinate = y;
		
		//TODO: Change to relative paths
		iconPurchased = ImageIO.read(new File("C:/Users/Richard/TheBakery/TheBakery/src/net/richardsprojects/TheBakery/images/objects/oven.png"));
		iconNotPurchased = ImageIO.read(new File("C:/Users/Richard/TheBakery/TheBakery/src/net/richardsprojects/TheBakery/images/objects/oven_opacity.png"));
	}
	
	@Override
	public void render(Graphics2D backgroundG2D) {
		
		if(xCoordinate == -1 && yCoordinate == -1) {
			return;
		}
		
		int TILE_HEIGHT = 64;
		int TILE_WIDTH = 64;
		int x = xCoordinate * TILE_WIDTH;
		int y = yCoordinate * TILE_HEIGHT;
		int x2 = x - y;
		int y2 = ((x+y)/2) + 174;
		
		if(purchased)
		{
			backgroundG2D.drawImage(this.iconPurchased, x2 + 712, y2, null);
		}
		else
		{
			backgroundG2D.drawImage(this.iconNotPurchased, x2 + 712, y2, null);
		}
	}

	@Override
	public int getObjectID() {
		//TODO: Need later - return 0 for now
		return 0;
	
	}

	@Override
	public void setObjectID() {
				
	}
	
	@Override
	public void setXCoordinate(int x)
	{
		xCoordinate = x;
	}
	
	@Override
	public void setYCoordinate(int y)
	{
		yCoordinate = y;
	}

	@Override
	public int getCostValue()
	{
		return 200;
	}
	
}
