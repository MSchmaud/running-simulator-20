package us.mschmaud.runningsim.tiles;

import us.mschmaud.runningsim.displayaudio.Resources;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Border extends Tile {

	public Border (int id) {
		super(Resources.border, id);
		this.wall = true;
	}

}
