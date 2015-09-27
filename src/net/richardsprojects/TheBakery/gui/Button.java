package net.richardsprojects.TheBakery.gui;

import java.awt.Graphics2D;

import net.richardsprojects.TheBakery.GameState;

public abstract class Button {
	
private GameState gamestate;
	
	private int x;
	private int y;
	
	private boolean hover = false;
	
	
	public abstract void render(Graphics2D g2d);
	public abstract void handleInput();	
}
