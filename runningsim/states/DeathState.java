package us.mschmaud.runningsim.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.ui.ClickListener;
import us.mschmaud.runningsim.ui.TextButton;
import us.mschmaud.runningsim.ui.UIController;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class DeathState extends State {
	
	private UIController uiController;

	public DeathState(Handler handler) {
		super(handler);
		uiController = new UIController(handler);
		
		uiController.add(new TextButton(150, 420, 192, 64, 158, 465, "Respawn", true, new ClickListener() {	// Respawn
			
			@Override
			public void onClick() {
				handler.getMouseManager().setUIController(null);
				handler.getGameState().getMusicPlayer().stop();
				handler.getGameState().setLevel(handler.getGameState().getLevelID());
				State.setState(handler.getGameState());
			}
		}));
		
		uiController.add(new TextButton(458, 420, 192, 64, 506, 465, "Exit", false, new ClickListener() {	// Quit
			
			@Override
			public void onClick() {
				handler.getMouseManager().setUIController(null);
				handler.getGameState().getMusicPlayer().stop();
				DeathState.setState(handler.getMainMenuState());
			}
		}));
	}

	@Override
	public void tick() {
		uiController.tick();
		if (handler.getGameState().getMusicPlayer().isFinished()) {
			handler.getGameState().newSong();
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		uiController.render(g);
		Font font = new Font("Verdana", Font.BOLD, 50);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString("You are ", handler.getWidth()/2-200, handler.getHeight()/2);
		Font font2 = new Font("Verdana", Font.BOLD+Font.ITALIC, 50);
		g.setFont(font2);
		g.setColor(Color.RED);
		g.drawString("DEAD", handler.getWidth()/2+35, handler.getHeight()/2);
		
	}

	@Override
	public void preload() {
		handler.getMouseManager().setUIController(uiController);
	}
	
}
