package net.richardsprojects.TheBakery;
import java.awt.Graphics;
import java.io.IOException;


public abstract class GameState {

	public abstract void update();
	public abstract void render(Graphics g) throws IOException;
	public abstract void handleInput() throws IOException;
	public abstract void handleButtonClick(String text);
	
}

