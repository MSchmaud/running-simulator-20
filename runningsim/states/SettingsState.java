package us.mschmaud.runningsim.states;

import java.awt.Color;
import java.awt.Graphics;
import us.mschmaud.runningsim.displayaudio.Resources;
import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.ui.ClickListener;
import us.mschmaud.runningsim.ui.Score;
import us.mschmaud.runningsim.ui.TextButton;
import us.mschmaud.runningsim.ui.UIController;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class SettingsState extends State {
	
	private UIController uiController;
	private TextButton resume, controls, mute;
	
	public SettingsState(Handler handler) {
		super(handler);
		uiController = new UIController(handler);
		resume = new TextButton(300, 70, 192, 64, 307, 115, "Resume", false, new ClickListener() {			// Resume
			
			@Override
			public void onClick() {
				handler.getMouseManager().setUIController(null);
				State.setState(handler.getGameState());
			}
		});
		
		uiController.add(resume);
		
		uiController.add(new TextButton(300, 530, 192, 64, 352, 575, "Exit", false, new ClickListener() {	// Exit
			
			@Override
			public void onClick() {
				if (State.getLastState().equals(handler.getGameState())) {
					Score.addScore(handler.getLevel().getEntityController().getUser().getCoins());
					handler.getGameState().getMusicPlayer().stop();
				}
				handler.getMouseManager().setUIController(null);
				State.setState(handler.getMainMenuState());
			}
		}));
		
		controls = new TextButton(300, 375, 192, 64, 303, 420, handler.getControls(), true, new ClickListener() {	// Controls
			
			@Override
			public void onClick() {
				if (handler.getControls().equals("Keyboard")) {handler.setControls("ClkToMov");}
				else {handler.setControls("Keyboard");}
				controls.setText(handler.getControls());
				handler.getGameState().getLevel().getEntityController().getUser().setControls(handler.getControls());
			}
			
		});
		
		uiController.add(controls);
		
		mute = new TextButton(300, 225, 192, 64, 340, 270, setMute(), false, new ClickListener() {	// Mute
			
			@Override
			public void onClick() {
				if (handler.getMute()) {
					handler.setMute(false);
					mute.setTextPos(340, 270);
					if (State.getLastState().equals(handler.getMainMenuState())) {
						handler.getMainMenuState().getPlayer().resume();
					}
					else if (State.getLastState().equals(handler.getGameState())) {
						handler.getGameState().getMusicPlayer().resume();
					}
				}
				else {
					handler.setMute(true);
					mute.setTextPos(306, 270);
					if (State.getLastState().equals(handler.getMainMenuState())) {
						handler.getMainMenuState().getPlayer().pause();
					}
					else if (State.getLastState().equals(handler.getGameState())) {
						handler.getGameState().getMusicPlayer().pause();
					}
				}
				mute.setText(setMute());
			}
			
		});
		
		uiController.add(mute);
	
	}
	
	@Override
	public void tick() {
		if (State.getTimer() > BUFFER_TIME) {
			if (handler.getKeyManager().esc) {
				handler.getMouseManager().setUIController(null);
				State.setState(State.getLastState());
			}
		}
		if (State.getLastState().equals(handler.getGameState())) {
			if (handler.getGameState().getMusicPlayer().isFinished()) {
				handler.getGameState().newSong();
			}
		}
		uiController.tick();
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Resources.optScreen, -200, 0, 1200, 600, null);
		uiController.render(g);
		g.setFont(Resources.infoFont);
		g.setColor(Color.BLACK);
		g.drawString("Sounds", 336, 205);
		g.drawString("Controls", 325, 355);
		
	}

	@Override
	public void preload() {
		handler.getMouseManager().setUIController(uiController);
		controls.setText(handler.getControls());
		mute.setText(setMute());
		if (State.getLastState() == handler.getMainMenuState()) {
			resume.setFunctional(false);
		}
		else {
			resume.setFunctional(true);
		}
	}
	
	private String setMute() {
		if (handler.getMute()) {return "Unmute";}
		else {return "Mute";}
	}
	
}
