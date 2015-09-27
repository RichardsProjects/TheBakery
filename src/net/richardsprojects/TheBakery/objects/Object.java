package net.richardsprojects.TheBakery.objects;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Object {
	
	private BufferedImage icon;
	public int objectID;
	
	public int xCoordinate;
	public int yCoordiante;
	
	public int costValue;
	
	public abstract void render(Graphics2D backgroundG2D);
	public abstract int getObjectID();
	public abstract void setObjectID();
	public abstract void setXCoordinate(int x);
	public abstract void setYCoordinate(int y);
	public abstract int getCostValue();

	
	

}
