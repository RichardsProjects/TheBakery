package net.richardsprojects.TheBakery;

import java.awt.Image;

public class Images {

	public static Image sideButton0;
	public static Image sideButton1;
	public static Image centeredButton2;
	public static Image centeredButton1;
	public static Image centeredButton0;
	public static Image scenarioSelector;
	public static Image title;
	public static Image megaMoneySelected;
	public static Image cunningCompetitorsSelected;
	public static Image gameSetup;
	public static Image textBoxCursor;
	public static Image easyIcon;
	public static Image mediumIcon;
	public static Image hardIcon;
	
	public static void load(GamePanel gp)
	{
		sideButton0 = Loader.loadImage("images/button0.png", gp);
		sideButton1 = Loader.loadImage("images/button1.png", gp);
		title = Loader.loadImage("images/title.png", gp);
		centeredButton2 = Loader.loadImage("images/centeredButton2.png", gp);
		centeredButton1 = Loader.loadImage("images/centeredButton1.png", gp);
		centeredButton0 = Loader.loadImage("images/centeredButton0.png", gp);
		scenarioSelector = Loader.loadImage("images/ScenarioSelector.png", gp);
		megaMoneySelected = Loader.loadImage("images/MegaMoneySelected.png", gp);
		cunningCompetitorsSelected = Loader.loadImage("images/CunningCompetitorsSelected.png", gp);
		gameSetup = Loader.loadImage("images/game_setup.png", gp);
		textBoxCursor = Loader.loadImage("images/textbox_cursor.png", gp);
		easyIcon = Loader.loadImage("images/EasyIcon.png", gp);
		mediumIcon = Loader.loadImage("images/MediumIcon.png", gp);
		hardIcon = Loader.loadImage("images/HardIcon.png", gp);
	}
	
}
