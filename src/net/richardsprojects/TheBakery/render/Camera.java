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

import net.richardsprojects.TheBakery.MapUtilities;
import net.richardsprojects.TheBakery.TheBakery;
import net.richardsprojects.TheBakery.input.MouseInput;
import net.richardsprojects.TheBakery.input.MouseInput2;

public class Camera {
	
	private int x;
	private int y;
	private JPanel root;
	
	private int[][] mapData;
	
	public BufferedImage selectionFile = null;
	
	public Camera(int[][] mapData, JPanel jp) {
	
		x = 0;
		y = 0;
		this.mapData = mapData;
		this.root = jp;
		
		//Load selectionFile
		//TODO: Change to relative path
		try {
			selectionFile = ImageIO.read(new File("C:/Users/Richard/TheBakery/TheBakery/src/net/richardsprojects/TheBakery/images/tiles_selection.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setX(int xValue, String operation)
	{	
		if(x <= -360 && operation.equals("-"))
		{
			this.x = -360;
		}else if(x >= 800 && operation.equals("+"))
		{
			this.x = 800;
		}else
		{
			this.x = xValue;
		}
	}
	
	public void setY(int yValue, String operation)
	{
		if(y <= -40 && operation.equals("-"))
		{
			this.y = -40;
		}else if(y >= 720 && operation.equals("+"))
		{
			this.y = 720;
		}else
		{
			this.y = yValue;
		}		
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void render(Graphics2D g2d, Image background) {
	

		
		//Draw Gameworld
		g2d.drawImage(background, 0, 0, 800, 600, x, y, x+800, y+600, null);
		
		//Print out mouse coordinates for testing
		//System.out.println("X: " + MouseInput2.mouseXLoc);
		//System.out.println("Y: " + MouseInput2.mouseYLoc);
		
	}
	
	public void handleSelection() throws IOException
	{
		int xCoordinate = 0;
		int yCoordinate = 0;
		
		xCoordinate = MouseInput2.mouseXLoc + x;
		yCoordinate = MouseInput2.mouseYLoc + y;
		
		//Load the tile selection file
		//TODO: Change this to a relative path
		
		
		int color = 0;
		
		try{
			color = selectionFile.getRGB(xCoordinate, yCoordinate);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			
		}
		
		MapUtilities.resetMapData(mapData);
		//Reset the current placing object
		if(TheBakery.objectPlacementMode)
		{
			TheBakery.selectedObject.setXCoordinate(-1);
			TheBakery.selectedObject.setYCoordinate(-1);
		}
		switch(color)
		{
			//Checking for First Row
			case -14352384: handleTileSelected(0, 0, 3);
							break;
			case -12189696: handleTileSelected(0, 1, 4);
						    break;
			case -9961472:  handleTileSelected(0, 2, 3);
						    break;
			case -7471104:  handleTileSelected(0, 3, 4);
						    break;
			case -5373181:  handleTileSelected(0, 4, 3);
						    break;
			case -1896689:  handleTileSelected(0, 5, 4);
							break;
			case -58597:    handleTileSelected(0, 6, 3);
							break;
			case -53200:    handleTileSelected(0, 7, 4);
							break;
			case -39836:    handleTileSelected(0, 8, 3);
			                break;
			case -17477:    handleTileSelected(0, 9, 4);
			                break;
			case -7197:     handleTileSelected(0, 10, 3);
			                break;
			case -515:      handleTileSelected(0, 11, 4);
			                break;
			//Check for the Second row
			case -15193088:	handleTileSelected(1, 0, 4);
			                break;
			case -14598912: handleTileSelected(1, 1, 3);
							break;
			case -14137086: handleTileSelected(1, 2, 4);
							break;
			case -13542912: handleTileSelected(1, 3, 3);
							break;
			case -12750847: handleTileSelected(1, 4, 4);
							break;
			case -11959037: handleTileSelected(1, 5, 3);
							break;
			case -10969850: handleTileSelected(1, 6, 4);
							break;
			case -10045690: handleTileSelected(1, 7, 3);
							break;
			case -8001521:  handleTileSelected(1, 8, 4);
							break;
			case -6619357:  handleTileSelected(1, 9, 3);
							break;
			case -5570747:  handleTileSelected(1, 10, 4);
			                break;
			case -4522136:  handleTileSelected(1, 11, 3);
							break;
			//Check Third row
			case -16764609: handleTileSelected(2, 0, 3);
							break;
			case -16761779: handleTileSelected(2, 1, 4);
							break;
			case -16759206: handleTileSelected(2, 2, 3);
							break;
			case -16755347: handleTileSelected(2, 3, 4);
							break;
			case -16752002: handleTileSelected(2, 4, 3);
							break;
			case -16745569: handleTileSelected(2, 5, 4);
							break;
			case -16740424: handleTileSelected(2, 6, 3);
							break;
			case -16733477: handleTileSelected(2, 7, 4);
							break;
			case -16726273: handleTileSelected(2, 8, 3);
							break;
			case -13446657: handleTileSelected(2, 9, 4);
							break;
			case -10298113: handleTileSelected(2, 10, 3);
							break;
			case -7018497:  handleTileSelected(2, 11, 4);
							break;
			//Check fourth row
			case -10592000: handleTileSelected(3, 0, 4);
							break;
			case -9999616:  handleTileSelected(3, 1, 3);
							break;
			case -9078528:  handleTileSelected(3, 2, 4);
							break;
			case -7433472:  handleTileSelected(3, 3, 3);
							break;
			case -5920000:  handleTileSelected(3, 4, 4);
							break;
			case -4669696:  handleTileSelected(3, 5, 3);
							break;
			case -3551232:  handleTileSelected(3, 6, 4);
							break;
			case -2037760:  handleTileSelected(3, 7, 3);
							break;
			case -721664:   handleTileSelected(3, 8, 4);
							break;
			case -524515:   handleTileSelected(3, 9, 3);
							break;
			case -458957:   handleTileSelected(3, 10, 4);
							break;
			case -458939:   handleTileSelected(3, 11, 3);
							break;
			//Check fifth row
			case -9487360:  handleTileSelected(4, 0, 3);
							break;
			case -9158912:  handleTileSelected(4, 1, 4);
							break;
			case -8633600:  handleTileSelected(4, 2, 3);
							break;
			case -7057408:  handleTileSelected(4, 3, 4);
							break;
			case -5678336:  handleTileSelected(4, 4, 3);
							break;
			case -4692992:  handleTileSelected(4, 5, 4);
							break;
			case -2985472:  handleTileSelected(4, 6, 3);
							break;
			case -1212416:  handleTileSelected(4, 7, 4);
							break;
			case -28400:    handleTileSelected(4, 8, 3);
							break;
			case -25303:    handleTileSelected(4, 9, 4);
							break;
			case -20913:    handleTileSelected(4, 10, 3);
							break;
			case -17300:    handleTileSelected(4, 11, 4);
							break;
			//Check sixth row
			case -14876618: handleTileSelected(5, 0, 4);
							break;
			case -14286777: handleTileSelected(5, 1, 3);
							break;
			case -13762475: handleTileSelected(5, 2, 4);
							break;
			case -12976021: handleTileSelected(5, 3, 3);
							break;
			case -12320642: handleTileSelected(5, 4, 4);
							break;
			case -11730802: handleTileSelected(5, 5, 3);
							break;
			case -11403112: handleTileSelected(5, 6, 4);
							break;
			case -10944348: handleTileSelected(5, 7, 3);
							break;
			case -10092355: handleTileSelected(5, 8, 4);
							break;
			case -8978212:  handleTileSelected(5, 9, 3);
							break;
			case -8388372:  handleTileSelected(5, 10, 4);
							break;
			case -7732993:  handleTileSelected(5, 11, 3);
							break;
			//Handle 7th Row
			case -13303756: handleTileSelected(6, 0, 3);
							break;
			case -12124090: handleTileSelected(6, 1, 4);
							break;
			case -10747813: handleTileSelected(6, 2, 3);
							break;
			case -9502610:  handleTileSelected(6, 3, 4);
							break;
			case -8519555:  handleTileSelected(6, 4, 3);
							break;
			case -7143279:  handleTileSelected(6, 5, 4);
							break;
			case -6160224:  handleTileSelected(6, 6, 3);
							break;
			case -4915021:  handleTileSelected(6, 7, 4);
							break;
			case -3997503:  handleTileSelected(6, 8, 3);
							break;
			case -2359079:  handleTileSelected(6, 9, 4);
							break;
			case -1244950:  handleTileSelected(6, 10, 3);
							break;
			case -65284:    handleTileSelected(6, 11, 4);
							break;
			//Handle 8th row
			case -16767707: handleTileSelected(7, 0, 4);
							break;
			case -16763851: handleTileSelected(7, 1, 3);
							break;
			case -16760510: handleTileSelected(7, 2, 4);
							break;
			case -16756141: handleTileSelected(7, 3, 3);
							break;
			case -16749459: handleTileSelected(7, 4, 4);
							break;
			case -16745090: handleTileSelected(7, 5, 3);
							break;
			case -16475235: handleTileSelected(7, 6, 4);
							break;
			case -16728641: handleTileSelected(7, 7, 3);
							break;
			case -16724272: handleTileSelected(7, 8, 4);
							break;
			case -16720416: handleTileSelected(7, 9, 3);
							break;
			case -16716561: handleTileSelected(7, 10, 4);
							break;
			case -16712449: handleTileSelected(7, 11, 3);
							break;
			//Handle 9th row
			case -14076384: handleTileSelected(8, 0, 3);
							break;
			case -13417944: handleTileSelected(8, 1, 4);
							break;
			case -12297676: handleTileSelected(8, 2, 3);
							break;
			case -11639236: handleTileSelected(8, 3, 4);
							break;
			case -10387892: handleTileSelected(8, 4, 3);
							break;
			case -9861038:  handleTileSelected(8, 5, 4);
							break;
			case -9136039:  handleTileSelected(8, 6, 3);
							break;
			case -8148123:  handleTileSelected(8, 7, 4);
							break;
			case -7489681:  handleTileSelected(8, 8, 3);
							break;
			case -6567559:  handleTileSelected(8, 9, 4);
							break;
			case -5974656:  handleTileSelected(8, 10, 3);
							break;
			case -5184629:  handleTileSelected(8, 11, 4);
							break;
			//Handle 10th row
			case -14408653: handleTileSelected(9, 0, 4);
							break;
			case -13553337: handleTileSelected(9, 1, 3);
							break;
			case -12698025: handleTileSelected(9, 2, 4);
							break;
			case -11711126: handleTileSelected(9, 3, 3);
							break;
			case -11184780: handleTileSelected(9, 4, 4);
							break;
			case -10790020: handleTileSelected(9, 5, 3);
							break;
			case -10066297: handleTileSelected(9, 6, 4);
							break;
			case -9474159:  handleTileSelected(9, 7, 3);
							break;
			case -8750433:  handleTileSelected(9, 8, 4);
							break;
			case -7829327:  handleTileSelected(9, 9, 3);
							break;
			case -6710840:  handleTileSelected(9, 10, 4);
							break;
			case -5855532:  handleTileSelected(9, 11, 3);
							break;							
			//Handle 11th row
			case -12171734: handleTileSelected(10, 0, 3);
							break;
			case -10460874: handleTileSelected(10, 1, 4);
							break;
			case -9342405:  handleTileSelected(10, 2, 3);
							break;
			case -7960765:  handleTileSelected(10, 3, 4);
							break;
			case -6644912:  handleTileSelected(10, 4, 3);
							break;
			case -5592231:  handleTileSelected(10, 5, 4);
							break;
			case -4934302:  handleTileSelected(10, 6, 3);
							break;
			case -3618451:  handleTileSelected(10, 7, 4);
							break;
			case -2697339:  handleTileSelected(10, 8, 3);
							break;
			case -2105196:  handleTileSelected(10, 9, 4);
							break;
			case -1249897:  handleTileSelected(10, 10, 3);
							break;
			case -460385:   handleTileSelected(10, 11, 4);
							break;
			//Handle 12th row
			case -13295841: handleTileSelected(11, 0, 4);
							break;
			case -11850965: handleTileSelected(11, 1, 3);
							break;
			case -10602697: handleTileSelected(11, 2, 4);
							break;
			case -9944767:  handleTileSelected(11, 3, 3);
							break;
			case -8827057:  handleTileSelected(11, 4, 4);
							break;
			case -8169384:  handleTileSelected(11, 5, 3);
							break;
			case -7248282:  handleTileSelected(11, 6, 4);
							break;
			case -5671049:  handleTileSelected(11, 7, 3);
							break;
			case -4685696:  handleTileSelected(11, 8, 4);
							break;
			case -3896694:  handleTileSelected(11, 9, 3);
							break;
			case -3304557:  handleTileSelected(11, 10, 4);
							break;
			case -2055004:  handleTileSelected(11, 11, 3);
							break;
			default: MapUtilities.resetMapData(mapData);
			// TODO: Fix bug where after scrolling off the bottom of the tiles the bottom row is still selected
		}
	}
	
	public void handleTileSelected(int x, int y, int tileColor)
	{
		if(!TheBakery.objectPlacementMode) mapData[x][y] = tileColor;
		if(TheBakery.objectPlacementMode)
		{
			TheBakery.selectedObject.setXCoordinate(y);
			TheBakery.selectedObject.setYCoordinate(x);
			TheBakery.xCoordinate = y;
			TheBakery.yCoordinate = x;
		}
	}
	
	//TODO: Allow diagonal movements with WASD
	//TODO: Add in edge and corner selected tiles
}
