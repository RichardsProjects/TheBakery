package net.richardsprojects.TheBakery.threads;

import net.richardsprojects.TheBakery.AudioManager;
import net.richardsprojects.TheBakery.GamePanel;
import net.richardsprojects.TheBakery.Images;
import net.richardsprojects.TheBakery.TheBakery;

public class ThreadLoadImagesAndSounds implements Runnable
{
	private GamePanel panel;
	private AudioManager cattails;
	
	public ThreadLoadImagesAndSounds(GamePanel gamePanel)
	{
		panel = gamePanel;
	}
	
	@Override
	public void run()
	{
		//Load Music - Only Cattails at the moment
		cattails = new AudioManager("/Music/Cattails.mp3");
		
		//Update Percent Loaded
		TheBakery.loadingPercent = 50;
		
		//Start Music
		cattails.loop();
		
		//Load Images
		Images.load(panel);
		
		//Update Perecent Loaded
		TheBakery.loadingPercent = 100;
	}

}
