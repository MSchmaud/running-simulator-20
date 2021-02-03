package us.mschmaud.runningsim.states;

import java.awt.Graphics;
import us.mschmaud.runningsim.displayaudio.Animate;
import us.mschmaud.runningsim.displayaudio.Player;
import us.mschmaud.runningsim.displayaudio.Resources;
import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.ui.ClickListener;
import us.mschmaud.runningsim.ui.ImageButton;
import us.mschmaud.runningsim.ui.TextButton;
import us.mschmaud.runningsim.ui.UIController;

/**
 * 
 * @author Michael Schmauderer
 * 
 */

public class MainMenuState extends State {
	
	private UIController uiController;
	private Animate titleScreen;
	private Player p;
	
	public MainMenuState(Handler handler) {
		super(handler);
		p = new Player();
		p.setFile("assets/sounds/Oogway Ascends2.wav");
		p.setLooping();
		uiController = new UIController(handler);
		
		uiController.add(new ImageButton(152, 450, 192, 64, new ClickListener() {	// Play

			@Override												// Create a quick instance of ClickListener
			public void onClick() {
				handler.getMouseManager().setUIController(null);	// Disables main menu UI
				State.setState(handler.getSelectionState());
			}
		}, Resources.play));
		
		uiController.add(new ImageButton(456, 450, 192, 64, new ClickListener() {	// Options
			
			@Override
			public void onClick() {
				handler.getMouseManager().setUIController(null);
				State.setState(handler.getHelpState());
			}
		}, Resources.options));
		
		uiController.add(new ImageButton(300, 530, 192, 64, new ClickListener() {	// Quit
			
			@Override
			public void onClick() {
				handler.setRunning(false);
			}
		}, Resources.quit));
		
		uiController.add(new TextButton(660, 530, 125, 64, 670, 575, "Help", false, new ClickListener() {	// Help
			
			@Override
			public void onClick() {
				handler.getMouseManager().setUIController(null);
				State.setState(handler.getHelpState());
			}
		}));
		
		uiController.add(new TextButton(20, 530, 150, 64, 30, 575, "Scores", true, new ClickListener() {	// Scores
			
			@Override
			public void onClick() {
				handler.getMouseManager().setUIController(null);
				State.setState(handler.getScoresState());
			}
		}));
		
		titleScreen = new Animate(1000, -1, "titlescreen");
	}

	@Override
	public void tick() {
		if (handler.getMouseManager().getUIController() == null) {handler.getMouseManager().setUIController(uiController);}	// In case user returns to main menu
		titleScreen.tick();
		uiController.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(titleScreen.getFrame(), -200, 0, 1200, 600, null);
		uiController.render(g);
	}

	@Override
	public void preload() {
		handler.getMouseManager().setUIController(uiController);
		if (!handler.getMute()) {
			p.play();
		}
	}
	
	public Player getPlayer() {
		return p;
	}
	
}
