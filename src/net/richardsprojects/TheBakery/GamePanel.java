package net.richardsprojects.TheBakery;

import net.richardsprojects.TheBakery.gui.GUI_Credits;
import net.richardsprojects.TheBakery.gui.GUI_GameSetup;
import net.richardsprojects.TheBakery.gui.GUI_InGame;
import net.richardsprojects.TheBakery.gui.GUI_LoadingScreen;
import net.richardsprojects.TheBakery.gui.GUI_ScenarioSelector;
import net.richardsprojects.TheBakery.gui.GUI_Title;
import net.richardsprojects.TheBakery.input.MouseInput;
import net.richardsprojects.TheBakery.input.MouseInput2;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -7410866854040854373L;
	
	// The constants are defined in constructor.
	public static final int PANELWIDTH;
	public static final int PANELHEIGHT;

        public static final int TITLE = 0;
        public static final int CREDITS = 1;
        public static final int GAME_SETUP = 2;
        public static final int IN_GAME = 3;
        public static final int SCENARIO_SELECTOR = 4;
        public static final int LOADING_SCREEN1 = 5;
	
    // Represents the current state
	GameState currentState;

    // Our input manger class.
	InputManager input;
	MouseInput mouse;
	MouseMotionListener mouse2;
	
   // This is called a static constructor. Basically,
   // it grabs the window size constants form our JFrame
   // and set them to the final static ints.
	static {
		PANELWIDTH = TheBakery.GAMEWIDTH;
		PANELHEIGHT = TheBakery.GAMEHEIGHT;
	}
	
	public GamePanel(TheBakery master) {
		
		input = new InputManager();
		mouse = new MouseInput();
		mouse2 = new MouseInput2();
		
		currentState = new GUI_LoadingScreen(this);
	
                // Lets KeyListener work correctly
		setFocusable(true);
		requestFocus();
		
                // Sets our InputManager as the listener
		addKeyListener(input);
		addMouseListener(mouse);
		addMouseMotionListener(mouse2);
		
		// Set a timer to go off every 15 milliseconds. That gives a frame rate 
		// of about 67.
		Timer time = new Timer(15, this);
		time.start();
	}

    // Every time Timer executes, update everything
	@Override
	public void actionPerformed(ActionEvent arg0) {		
		updateAll();
	}
	
	private void updateAll() {
        // Tell the current state to handle
        // input however it needs to.
		try {
			currentState.handleInput();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Tell the current state to handle
        // update however necessary.
		currentState.update();
		
        // Calls paintComponent
		repaint();
	}

    @Override
    public void paintComponent(Graphics g) {
    	// Tell current state to paint!
        try {
			currentState.render(g);
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	public void changeState(int command) {
		if (command == TITLE) {
			currentState = new GUI_Title(this);
		}
		else if(command == CREDITS)
		{
			currentState = new GUI_Credits(this);
		}
		else if(command == GAME_SETUP)
		{
			currentState = new GUI_GameSetup(this);
		}
		else if(command == IN_GAME)
		{
			currentState = new GUI_InGame(this, TheBakery.difficulty, TheBakery.bakeryName);
		}
		else if(command == SCENARIO_SELECTOR)
		{
			currentState = new GUI_ScenarioSelector(this);
		}
		// And so on...
                else {
                    System.out.println("That state does not exist");
                    System.exit(0);
                } 
	}


}

