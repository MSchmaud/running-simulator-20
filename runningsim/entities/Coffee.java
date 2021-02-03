package us.mschmaud.runningsim.entities;

import java.awt.Graphics;

import us.mschmaud.runningsim.displayaudio.Animate;
import us.mschmaud.runningsim.engine.Handler;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Coffee extends Entity {

	private Animate coffeeFrames;
	
	public Coffee(Handler handler, float x, float y) {
		super(handler, x, y, 32, 32);
		coffeeFrames = new Animate(100, 0, "coffee");
	}

	@Override
	public void tick() {
		coffeeFrames.tick();
		if (entityCollidedRunner(0f, 0f)) {
			die();
			handler.getLevel().getEntityController().getUser().drinkCoffee();
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(coffeeFrames.getFrame(), (int)(x - handler.getCamera().getxOff()), (int)(y - handler.getCamera().getyOff()), width, height, null);
		
	}

	@Override
	public void die() {
		eActive = false;
	}

}
