package us.mschmaud.runningsim.states;

import java.awt.Color;
import java.awt.Graphics;
import us.mschmaud.runningsim.displayaudio.Resources;
import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.ui.Score;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class ScoresState extends State {

	public ScoresState(Handler handler) {
		super(handler);
	}

	@Override
	public void tick() {
		if (State.getTimer() > State.BUFFER_TIME) {
			if (handler.getKeyManager().esc) {
				handler.getMouseManager().setUIController(null);
				State.setState(State.getLastState());
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Resources.backgr, 0, 0, handler.getWidth(), handler.getHeight(), null);
		g.setFont(Resources.infoFont);
		g.setColor(Color.WHITE);
		g.drawString("HIGH SCORE:", handler.getWidth()/2-110, 50);
		if (!Score.lastTime().isEmpty()) {
			g.drawString(Score.getHighScore(), handler.getWidth()/2-275, 100);
			g.drawString("All Scores:", handler.getWidth()/2-90, 200);
			for (int i=0; i < Score.getScores().size(); i++) {
				g.drawString(Score.getScores().get(i), handler.getWidth()/2-275, 250+(i*50));
			}
		}
		else {
			g.drawString("Play a game first to see your score", handler.getWidth()/2-300, 100);
		}
	}

	@Override
	public void preload() {
		// TODO Auto-generated method stub
	}

}
