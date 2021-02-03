package us.mschmaud.runningsim.states;

import java.awt.Color;
import java.awt.Graphics;

import us.mschmaud.runningsim.displayaudio.Player;
import us.mschmaud.runningsim.displayaudio.Resources;
import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.tiles.TileMap;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class GameState extends State {
	
	private TileMap level;
	private String lvl;
	private String runnerID;
	private Player p, musicP;
	private String[] songs;
	private int currentChoice;
	
	public GameState(Handler handler, String lvl, String runnerID) {
		super(handler);
		p = new Player();
		p.setFile(Resources.coinSound);
		musicP = new Player();
		this.lvl = lvl;
		this.runnerID = runnerID;
		level = new TileMap(handler, lvl, runnerID);
		handler.setLevel(this.level);
		songs = new String[]{"sweden2", "subwoofer2", "mice2", "wet2", "dry2"};
	}
	
	@Override
	public void tick() {
		level.tick();
		if (State.getTimer() > State.BUFFER_TIME) {
			if (handler.getKeyManager().esc) {
				State.setState(handler.getSettingsState());
			}
		}
		if (musicP.isFinished()) {
			newSong();
		}
	}

	@Override
	public void render(Graphics g) {
		level.render(g);
		g.drawImage(Resources.coin[0], 1, 1, 64, 64, null);
		g.setColor(Color.WHITE);
		g.setFont(Resources.infoFont);
		g.drawString("x" + handler.getLevel().getEntityController().getUser().getCoins(), 70, 64);
	}

	@Override
	public void preload() {
		handler.getLevel().getEntityController().getUser().setControls(handler.getControls());
		if (!handler.getMute() && (State.getLastState().equals(handler.getSelectionState()) || State.getLastState().equals(handler.getDeathState()))) {
			startSong();
		}
	}
	
	public void setLevel(String lvl) {
		this.lvl = lvl;
		level = new TileMap(handler, lvl, runnerID);
		handler.setLevel(level);
	}
	
	public void setRunner(String runnerID) {
		this.runnerID = runnerID;
		level = new TileMap(handler, lvl, runnerID);
		handler.setLevel(level);
	}
	
	public TileMap getLevel() {
		return level;
	}
	
	public String getLevelID() {
		return lvl;
	}
	
	public Player getPlayer() {
		return p;
	}
	
	public Player getMusicPlayer() {
		return musicP;
	}
	
	private void startSong() {
		int choice = (int) (Math.random() * songs.length);
		currentChoice = choice;
		musicP.setFile("assets/sounds/" + songs[choice] + ".wav");
		musicP.play();
	}
	
	public void newSong() {
		musicP.stop();
		int choice = currentChoice;
		while (choice == currentChoice) {
			choice = (int) (Math.random() * songs.length);
		}
		currentChoice = choice;
		musicP.setFile("assets/sounds/" + songs[choice] + ".wav");
		musicP.play();
	}

}
