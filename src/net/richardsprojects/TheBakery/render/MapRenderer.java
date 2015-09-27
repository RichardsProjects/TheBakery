package net.richardsprojects.TheBakery.render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MapRenderer {
	
	private JPanel root;
	
	private int[][] mapData;
	
	public BufferedImage t1 = null;
	public BufferedImage t2 = null;
	public BufferedImage t3 = null;
	public BufferedImage t4 = null;
	public BufferedImage backdrop = null;	
	
	public MapRenderer(int[][] mapData, JPanel jp) {
	
		this.mapData = mapData;
		this.root = jp;
		
		try {
			t1 = ImageIO.read(new File("C:/Users/Richard/TheBakery/TheBakery/src/net/richardsprojects/TheBakery/images/tiles/t1.png"));
			t2 = ImageIO.read(new File("C:/Users/Richard/TheBakery/TheBakery/src/net/richardsprojects/TheBakery/images/tiles/t2.png"));
			t3 = ImageIO.read(new File("C:/Users/Richard/TheBakery/TheBakery/src/net/richardsprojects/TheBakery/images/tiles/t3.png"));
			t4 = ImageIO.read(new File("C:/Users/Richard/TheBakery/TheBakery/src/net/richardsprojects/TheBakery/images/tiles/t4.png"));
			backdrop = ImageIO.read(new File("C:/Users/Richard/TheBakery/TheBakery/src/net/richardsprojects/TheBakery/images/bakeryWall.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void render(Graphics2D g2d, BufferedImage background)
	{
		//Render background of Map
		Graphics2D backgroundG2d = (Graphics2D) background.createGraphics();
		backgroundG2d.setBackground(Color.decode("#333333"));
		backgroundG2d.clearRect(0,0, 1544, 1050);
		
		//Draw Bakery Wall
		backgroundG2d.drawImage(backdrop, 0, 0, null);
		
		
		int startingX = 32;
		int startingY = 32;
		
		//temp x and y values
		int x = startingX;
		int y = startingY;
		
		int TILE_HEIGHT = 64;
		int TILE_WIDTH = 64;
		
		//Draw the Row
		for(int i = 0; i < 12; i++)
		{
			int tempX = x;
			//Draw the Column
			for(int i2 = 0; i2 < 12; i2++)
			{				
				Image img2 = null;
				x = i2 * TILE_WIDTH;
				y = i * TILE_HEIGHT;
				int x2 = x - y;
				int y2 = ((x+y)/2) + 246;
				
				if(mapData[i][i2] == 1)	backgroundG2d.drawImage(t1, x2 + 704, y2, null);
				if(mapData[i][i2] == 2) backgroundG2d.drawImage(t2, x2 + 704, y2, null);
				if(mapData[i][i2] == 3) backgroundG2d.drawImage(t3, x2 + 704, y2, null);
				if(mapData[i][i2] == 4) backgroundG2d.drawImage(t4, x2 + 704, y2, null);
				tempX = tempX + 136;				
			}
			y = y + 32;
			if(x == startingX){
				x = startingX + 68;
			}
			else
			{
				x = startingX;
			}
			
			//x = startingX + (32*(i+1));
			
		}
		
		backgroundG2d.dispose();
	
		//No longer needed
		/*File file = new File("myimage.png");
		try {
			ImageIO.write(background, "png", file);
		} catch (IOException e) {
			//Required but not needed method
			e.printStackTrace();
		}*/	

	}
}
