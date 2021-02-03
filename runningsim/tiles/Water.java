package us.mschmaud.runningsim.tiles;

import us.mschmaud.runningsim.displayaudio.Resources;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Water extends Tile {

	public Water(int id) {
		super(Resources.water, id);
		this.wall = true;
	}
	
}
