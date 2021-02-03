package us.mschmaud.runningsim.entities;

import java.awt.Graphics;

import us.mschmaud.runningsim.displayaudio.Animate;
import us.mschmaud.runningsim.engine.Handler;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Coin extends Entity {
	
	private Animate coinFrames;

	public Coin(Handler handler, float x, float y) {
		super(handler, x, y, 32, 32);
		coinFrames = new Animate(100, 0, "coinnn");	// the name is stupid because of the way Animate breaks down id's (needed 6 characters)
	}

	@Override
	public void tick() {
		coinFrames.tick();
		if (entityCollidedRunner(0f, 0f)) {
			die();
			handler.getLevel().getEntityController().getUser().pickupCoin();
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(coinFrames.getFrame(), (int)(x - handler.getCamera().getxOff()), (int)(y - handler.getCamera().getyOff()), width, height, null);
		
	}

	@Override
	public void die() {
		eActive = false;
	}

}
