package net.richardsprojects.TheBakery.animations;

import java.awt.Graphics2D;

public abstract class Animation {

	public boolean markedForDeletion;
	
	public abstract void update();
	public abstract void render(Graphics2D backgroundG2d);
	
}
