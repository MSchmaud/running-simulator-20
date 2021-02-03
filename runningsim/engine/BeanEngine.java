package us.mschmaud.runningsim.engine;

import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import us.mschmaud.runningsim.displayaudio.Camera;
import us.mschmaud.runningsim.displayaudio.Display;
import us.mschmaud.runningsim.displayaudio.Resources;
import us.mschmaud.runningsim.inputs.KeyManager;
import us.mschmaud.runningsim.inputs.MouseManager;
import us.mschmaud.runningsim.states.DeathState;
import us.mschmaud.runningsim.states.GameState;
import us.mschmaud.runningsim.states.HelpState;
import us.mschmaud.runningsim.states.MainMenuState;
import us.mschmaud.runningsim.states.ScoresState;
import us.mschmaud.runningsim.states.SelectionState;
import us.mschmaud.runningsim.states.SettingsState;
import us.mschmaud.runningsim.states.State;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class BeanEngine implements Runnable {

	// Graphics stuff
	private Display display;
	private String name;
	private int width, height;
	private Camera cam;
	private BufferStrategy bStrat;
	private Graphics g;
	
	// Screens stuff
	private State gameState;
	private State mainMenuState;
	private State selectionState;
	private State settingsState;
	private State deathState;
	private State helpState;
	private State scoresState;
	
	// Engine stuff
	private Thread thread;
	public boolean isRunning = false;
	private Handler handler;
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	public BeanEngine(String name, int width, int height) {
		this.name = name;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}
	
	private void preload() {
		Resources.loadResources();
		
		this.display = new Display(this.name, this.width, this.height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);

		handler = new Handler(this);
		
		cam = new Camera(this.handler, 0, 0);
		
		settingsState = new SettingsState(handler);
		gameState = new GameState(this.handler, "assets/levels/home.txt", "male_dark_blue_gold");
		mainMenuState = new MainMenuState(handler);
		selectionState = new SelectionState(handler);
		deathState = new DeathState(handler);
		helpState = new HelpState(handler);
		scoresState = new ScoresState(handler);
		State.setState(mainMenuState);
	}
	
	private void tick() {
		keyManager.tick();
		
		if (State.getState() != null) {
			State.getState().tick();
		}
	}
	
	private void render() {
		bStrat = display.getCanvas().getBufferStrategy();
		if (bStrat == null) {
			display.getCanvas().createBufferStrategy(3);
			return;		// Does not like to work without this
		}
		g = bStrat.getDrawGraphics();
		
		g.clearRect(0, 0, this.width, this.height);
		if (State.getState() != null) {
			State.getState().render(g);
		}
		bStrat.show();
		g.dispose();
	}

	@Override
	public void run() {
		preload();
		
		int fps = 60;
		double tickTime = 1000000000/fps;
		double delta = 0;
		long currentTime;
		long previousTime = System.nanoTime();
		
		// main game loop
		while(this.isRunning) {
			currentTime = System.nanoTime();
			delta += (currentTime-previousTime)/tickTime;
			previousTime = currentTime;
			
			if (delta >= 1) {
				tick();
				render();
				delta--;
			}
		}
		stop();
	}
	
	public synchronized void start() {
		if (!this.isRunning) {
			this.isRunning = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public synchronized void stop() {
		if (this.isRunning) {
			this.isRunning = false;
		}
		display.getFrame().dispatchEvent(new WindowEvent(display.getFrame(), WindowEvent.WINDOW_CLOSING));
	}
	
	protected int getWidth() {
		return width;
	}
	
	protected int getHeight() {
		return height;
	}
	
	protected KeyManager getKeyManager() {
		return keyManager;
	}
	
	protected MouseManager getMouseManager() {
		return mouseManager;
	}
	
	protected Camera getCamera() {
		return cam;
	}
	
	protected State getMainMenuState() {
		return mainMenuState;
	}
	
	protected State getSelectionState() {
		return selectionState;
	}
	
	protected State getGameState() {
		return gameState;
	}
	
	protected State getSettingsState() {
		return settingsState;
	}
	
	protected State getDeathState() {
		return deathState;
	}
	
	protected State getHelpState() {
		return helpState;
	}
	
	protected State getScoresState() {
		return scoresState;
	}
	
	protected void setRunning(boolean b) {
		isRunning = b;
	}
	
	protected Display getDisplay() {
		return display;
	}
	
}
