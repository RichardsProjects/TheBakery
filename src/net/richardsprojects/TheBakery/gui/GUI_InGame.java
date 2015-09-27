package net.richardsprojects.TheBakery.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.Timer;

import net.richardsprojects.TheBakery.AudioManager;
import net.richardsprojects.TheBakery.GamePanel;
import net.richardsprojects.TheBakery.GameState;
import net.richardsprojects.TheBakery.TheBakery;
import net.richardsprojects.TheBakery.engine.GameLogicHandler;
import net.richardsprojects.TheBakery.engine.GameTimeHandler;
import net.richardsprojects.TheBakery.render.Camera;
import net.richardsprojects.TheBakery.render.MapRenderer;
import net.richardsprojects.TheBakery.render.ObjectRenderer;
import net.richardsprojects.TheBakery.render.UserInterface;
import net.richardsprojects.TheBakery.objects.Object;

public class GUI_InGame extends GameState {

	//TODO: Update the UI to 800x600
	
	// This is our custom JPanel
	private GamePanel root;
	private String difficulty = "";
	private String bakeryName = "";
	private static Timer gameTimeTimer;
	private static Timer gameLogicTimer;
	
	//Camera & UI object for rendering
	public Camera cam;
	private UserInterface ui; 
	private MapRenderer map;
	private ObjectRenderer objects;
	
	public static AudioManager kaching;
	
	//Map & Object Data
	private int[][] mapData = new int[12][12];
	public static Object[][] objectData = new Object[12][12];
	

	public GUI_InGame(GamePanel master, String difficulty, String bakeryName)
	{
		root = master;
	
		//Setup camera and UI objects
		cam = new Camera(mapData, root);
		ui = new UserInterface(root);
		map = new MapRenderer(mapData, root);
		objects = new ObjectRenderer(objectData, root);
		
		//Load settings from Previous GUI
		this.difficulty = difficulty;
		this.bakeryName = bakeryName;
		
		//print out name and difficulty recieved for debug purposes
		System.out.println("Name: " + this.bakeryName);
		System.out.println("Difficulty: " + this.difficulty);
		
		//Set in-game time & funds
		TheBakery.inGameDay = 1;
		TheBakery.inGameHour = 8;
		
		//Set Money based on difficulty
		if(TheBakery.difficulty.equals("Easy")) TheBakery.money = 900;
		if(TheBakery.difficulty.equals("Medium")) TheBakery.money = 750;
		if(TheBakery.difficulty.equals("Hard")) TheBakery.money = 600;
		
		//Pause the Game for tutorial
		TheBakery.gameSpeed = 0;
		
		//Start timer
		gameTimeTimer = new Timer(500, new GameTimeHandler());
		gameTimeTimer.start();
		
		gameLogicTimer = new Timer(33, new GameLogicHandler(this));
		gameLogicTimer.start();
		
		//Load ka-ching sound
		kaching = new AudioManager("/SFX/kaching.mp3");
	}
	
	@Override
	public void update() {
		
		
	}

	@Override
	public void render(Graphics g) throws IOException {
		
		//TODO: Add Pause Menu
		
		//Convert Graphics to Graphics2D
		Graphics2D g2d = (Graphics2D) g;
		
		//Clear the screen from previous render cycle
		g2d.fillRect(0, 0, 800, 600);
		
		//Image Data
		BufferedImage background = new BufferedImage(1544, 1050, BufferedImage.TYPE_INT_ARGB);
		
		//Render the map into the image
		map.render(g2d, background);
		
		//Render the objects
		objects.render(g2d, background);
		
		//Render the Game world into the Camera
		cam.render(g2d, background);
		
		//Render the UI
		if(ui.displayUI)
		{
			ui.render(g2d);
		}
	}

	@Override
	public void handleInput() throws IOException {
		
		//Check Cursor Positions for Screen-Scrolling
		cam.handleSelection();
		ui.handleInput();

		
	}

	@Override
	public void handleButtonClick(String text) {}	
}