package us.mschmaud.runningsim.entities;

import us.mschmaud.runningsim.engine.Handler;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Zombie extends Mob {

	public Zombie(Handler handler, float x, float y, String id) {
		super(handler, x, y, id);
		this.id = id;
	}
	
}
