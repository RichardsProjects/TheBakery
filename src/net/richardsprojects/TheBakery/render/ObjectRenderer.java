package net.richardsprojects.TheBakery.render;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import net.richardsprojects.TheBakery.objects.Object;

import net.richardsprojects.TheBakery.Loader;
import net.richardsprojects.TheBakery.TheBakery;

public class ObjectRenderer {

	private JPanel root;
	
	//Object Data
	private Object[][] objectData;
	
	//Images
	private Image woodDoor;
	
	public ObjectRenderer(Object[][] objectData, JPanel jp) {
	
		this.objectData = objectData;
		
		//this.objectData = objectData;
		this.root = jp;
		
		//Load Images
		//TODO: Change the door to an object rather than image
		woodDoor = Loader.loadImage("images/wood_door.png", root);
	}
	
	public void render(Graphics2D g2d, BufferedImage background) throws IOException
	{
		//Render Door
		Graphics2D backgroundG2d = (Graphics2D) background.createGraphics();		
		backgroundG2d.drawImage(woodDoor, 444, 196, null);
		
		//Draw the Row
		for(int i = 0; i < 12; i++)
		{
			//Draw the Column
			for(int i2 = 0; i2 < 12; i2++)
			{				
				if(objectData[i][i2] != null)
				{
					objectData[i][i2].render(backgroundG2d);
				}
				if(TheBakery.objectPlacementMode)
				{
					if(TheBakery.xCoordinate == i && TheBakery.xCoordinate == i2)
					{
						TheBakery.selectedObject.render(backgroundG2d);
					}
				}
			}					
		}
	}
	
}
