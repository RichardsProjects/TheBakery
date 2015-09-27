package net.richardsprojects.TheBakery.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import net.richardsprojects.TheBakery.GamePanel;
import net.richardsprojects.TheBakery.GameState;
import net.richardsprojects.TheBakery.TheBakery;
import net.richardsprojects.TheBakery.threads.ThreadLoadImagesAndSounds;

public class GUI_LoadingScreen extends GameState
{

	private GamePanel root;

	public GUI_LoadingScreen(GamePanel gamePanel)
	{
		root = gamePanel;
		
		//Start loading images and sounds
		Thread loadThread = new Thread(new ThreadLoadImagesAndSounds(root));
		loadThread.start();
	}
	
	@Override
	public void render(Graphics g) throws IOException
	{
		//Convert Graphics to Graphics2D
		Graphics2D g2d = (Graphics2D) g;
		
		//Set Color to black
		g2d.setColor(Color.BLACK);
		
		//Clear the screen from previous render cycle
		g2d.fillRect(0, 0, 800, 600);
		
		if(TheBakery.loadingPercent == 0)
		{
			
		}
		
		if(TheBakery.loadingPercent == 100)
		{
			//Change State
			root.changeState(GamePanel.TITLE);			
		}
	}
	
	//Not needed as there are no buttons, input, or clicks to
	//handle on a loading screen.
	@Override
	public void handleInput() throws IOException {}
	@Override
	public void handleButtonClick(String text) {}
	@Override
	public void update(){}

}
