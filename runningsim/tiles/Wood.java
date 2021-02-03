package us.mschmaud.runningsim.tiles;

import us.mschmaud.runningsim.displayaudio.Resources;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Wood extends Tile {

	public Wood(int id) {
		super(Resources.wood, id);
		this.wall = true;
	}
	
}
