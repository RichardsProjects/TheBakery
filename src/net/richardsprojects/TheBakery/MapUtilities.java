package net.richardsprojects.TheBakery;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MapUtilities {
	
	public static void setupMap(int[][] mapData)
	{
		int temp = 1;
		
		for(int i = 0; i < 12; i++) {
			if(temp == 1)
			{
				mapData[i][0] = 1;
				mapData[i][1] = 2;
				mapData[i][2] = 1;
				mapData[i][3] = 2;
				mapData[i][4] = 1;
				mapData[i][5] = 2;
				mapData[i][6] = 1;
				mapData[i][7] = 2;
				mapData[i][8] = 1;
				mapData[i][9] = 2;
				mapData[i][10] = 1;
				mapData[i][11] = 2;
				temp = 2;
				continue;
			}
			else
			{
				temp = 1;
				mapData[i][0] = 2;
				mapData[i][1] = 1;
				mapData[i][2] = 2;
				mapData[i][3] = 1;
				mapData[i][4] = 2;
				mapData[i][5] = 1;
				mapData[i][6] = 2;
				mapData[i][7] = 1;
				mapData[i][8] = 2;
				mapData[i][9] = 1;
				mapData[i][10] = 2;
				mapData[i][11] = 1;
			}
		}		
	}
	
	public static void resetMapData(int[][] mapData) {
		
		//Call the setup map method to not repeat code
		setupMap(mapData);		
	}
	
}
