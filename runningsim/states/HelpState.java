package us.mschmaud.runningsim.states;

import java.awt.Graphics;

import us.mschmaud.runningsim.displayaudio.Resources;
import us.mschmaud.runningsim.engine.Handler;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class HelpState extends State {

	public HelpState(Handler handler) {
		super(handler);
	}

	@Override
	public void tick() {
		if (State.getTimer() > State.BUFFER_TIME) {
			if (handler.getKeyManager().esc) {
				State.setState(State.getLastState());
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Resources.helpScreen, 0, -70, handler.getWidth(), handler.getHeight()+250, null);
	}

	@Override
	public void preload() {
		// TODO Auto-generated method stub
	}

}
