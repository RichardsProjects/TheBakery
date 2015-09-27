package net.richardsprojects.TheBakery.engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.richardsprojects.TheBakery.TheBakery;

public class GameTimeHandler implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{

		if(TheBakery.gameSpeed == 3)
		{
			TheBakery.inGameMinute++;
			if(TheBakery.inGameMinute > 59)
			{
				TheBakery.inGameHour++;
				TheBakery.inGameMinute = 0;
			}
		
		}
		else if(TheBakery.gameSpeed == 2)
		{
			TheBakery.tempCounter ++;
			if(TheBakery.tempCounter >= 3)
			{
				TheBakery.tempCounter = 0;
				TheBakery.inGameMinute++;
				if(TheBakery.inGameMinute > 59)
				{
					TheBakery.inGameHour++;
					TheBakery.inGameMinute = 0;
				}
			}
		}
		else if(TheBakery.gameSpeed == 1)
		{
			TheBakery.tempCounter ++;
			if(TheBakery.tempCounter >= 6)
			{
				TheBakery.tempCounter = 0;
				TheBakery.inGameMinute++;
				if(TheBakery.inGameMinute > 59)
				{
					TheBakery.inGameHour++;
					TheBakery.inGameMinute = 0;
				}
			}
		}
		else
		{
			//Do Nothing
		}
	}
}