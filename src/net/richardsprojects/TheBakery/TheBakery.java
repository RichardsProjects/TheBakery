package net.richardsprojects.TheBakery;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JApplet;

import net.richardsprojects.TheBakery.objects.Object;

public class TheBakery extends JApplet {
	
	public static GamePanel panel;
	
	private static final long serialVersionUID = 5816581980475389668L;
	public static final int GAMEWIDTH = 800;
	public static final int GAMEHEIGHT = 600;
	
	public static String bakeryName = "";
	public static String difficulty = "";
	
	public static int gameSpeed = 0;
	public static int inGameHour = 0;
	public static int inGameMinute = 0;
	public static int inGameDay = 0;
	public static int money = 0;
	public static int moneyEarned = 0;
	public static int totalExpenses = 0;
	public static int purchases = 0;
	public static int salaries = 0;
	
	public static int scenario = 0;
	
	//Variables used for object placement mode
	public static boolean objectPlacementMode = false;
	public static Object selectedObject = null;
	
	//Stores last known x and y coordinate of oject placement
	public static int xCoordinate;
	public static int yCoordinate;
	
	public static int tempCounter = 0;
	
	public static int loadingPercent = 0;
	
	//Object ArrayList
	public static ArrayList<Object> objectData = new ArrayList<Object>();
	
	public void init()
	{
		//Set Size
		setSize(GAMEWIDTH, GAMEHEIGHT);
		
		// Add our custom panel
		panel = new GamePanel(this);
		add(panel, BorderLayout.CENTER);
		
	}
	
	//TODO: Add options menu (with settings like volume, screen scrolling (enabled or disabled) & screen scrolling speed)
	//TODO: Add saving and loading functionality
	//TODO: Add the ability to select objects
	//TODO: Add the ability to sell objects
	//TODO: Add a loading screen that loads images, musics/sounds and options.
}
