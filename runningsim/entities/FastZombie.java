package us.mschmaud.runningsim.entities;

import us.mschmaud.runningsim.engine.Handler;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class FastZombie extends Zombie {

	public FastZombie(Handler handler, float x, float y) {
		super(handler, x, y, "fastZombie");
		speed = NORM_SPEED - (float)Math.random();
		animSpeed = 100;
		setAttackCD(25);
	}

}
