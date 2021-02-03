package us.mschmaud.runningsim.tiles;

import us.mschmaud.runningsim.displayaudio.Resources;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Stone extends Tile {

	public Stone(int id) {
		super(Resources.stone, id);
		this.wall = true;
	}

}
