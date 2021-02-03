package us.mschmaud.runningsim.displayaudio;

import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.entities.Entity;
import us.mschmaud.runningsim.tiles.Tile;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Camera {

	private Handler handler;
	private float xOff, yOff;
	
	public Camera(Handler handler, float xOff, float yOff) {
		this.handler = handler;
		this.xOff = xOff;
		this.xOff = yOff;
	}
	
	public void setFocus(Entity e) {
		xOff = e.getX() - handler.getWidth()/2 + e.getWidth()/2;
		yOff = e.getY() - handler.getHeight()/2 + e.getHeight()/2;
		checkBounds();
	}
	
	public void checkBounds() {
		if (xOff < 0) {xOff = 0;}	// Left border
		else if (xOff > handler.getLevel().getWidth()*Tile.TILE_WIDTH - handler.getWidth()) {
			xOff = handler.getLevel().getWidth()*Tile.TILE_WIDTH - handler.getWidth();		// Right border
		}
		if (yOff < 0) {yOff = 0;}	// Top border
		else if (yOff > handler.getLevel().getHeight()*Tile.TILE_HEIGHT - handler.getHeight()) {
			yOff = handler.getLevel().getHeight()*Tile.TILE_HEIGHT - handler.getHeight();	// Bottom Border
		}
		
	}
	
	public void move(int x, int y) {
		xOff += x;
		yOff += y;
		checkBounds();
	}

	public float getxOff() {
		return xOff;
	}

	public void setxOff(float xOff) {
		this.xOff = xOff;
		checkBounds();
	}

	public float getyOff() {
		return yOff;
	}

	public void setyOff(float yOff) {
		this.yOff = yOff;
		checkBounds();
	}
	
	public void reset() {
		xOff = 0;
		yOff = 0;
	}
	
}
