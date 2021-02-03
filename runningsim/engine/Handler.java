package us.mschmaud.runningsim.engine;

import us.mschmaud.runningsim.displayaudio.Camera;
import us.mschmaud.runningsim.displayaudio.Display;
import us.mschmaud.runningsim.inputs.KeyManager;
import us.mschmaud.runningsim.inputs.MouseManager;
import us.mschmaud.runningsim.states.GameState;
import us.mschmaud.runningsim.states.MainMenuState;
import us.mschmaud.runningsim.states.SettingsState;
import us.mschmaud.runningsim.states.State;
import us.mschmaud.runningsim.tiles.TileMap;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Handler {

	private BeanEngine game;
	private TileMap level;
	private String controls = "Keyboard";
	private boolean mute, canPlayCustom;
	
	public Handler(BeanEngine engine) {
		this.game = engine;
		canPlayCustom = false;
	}

	public BeanEngine getGame() {
		return game;
	}

	public void setGame(BeanEngine game) {
		this.game = game;
	}
	
	public GameState getGameState() {
		return (GameState)game.getGameState();
	}
	
	public State getSelectionState() {
		return game.getSelectionState();
	}
	
	public State getHelpState() {
		return game.getHelpState();
	}
	
	public MainMenuState getMainMenuState() {
		return (MainMenuState)game.getMainMenuState();
	}
	
	public SettingsState getSettingsState() {
		return (SettingsState)game.getSettingsState();
	}
	
	public State getDeathState() {
		return game.getDeathState();
	}
	
	public State getScoresState() {
		return game.getScoresState();
	}

	public TileMap getLevel() {
		return level;
	}

	public void setLevel(TileMap level) {
		this.level = level;
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}
	
	public Camera getCamera() {
		return game.getCamera();
	}
	
	public void setRunning(boolean b) {
		game.setRunning(b);
	}
	
	public Display getDisplay() {
		return game.getDisplay();
	}
	
	public String getControls() {
		return controls;
	}
	
	public void setControls(String c) {
		controls = c;
	}
	
	public boolean getMute() {
		return mute;
	}
	
	public void setMute(boolean b) {
		mute = b;
	}
	
	public boolean getCanPlayCustom() {
		return canPlayCustom;
	}
	
	public void setCanPlayCustom(boolean b) {
		canPlayCustom = b;
	}
	
}
