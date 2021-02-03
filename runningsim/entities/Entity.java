package us.mschmaud.runningsim.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import us.mschmaud.runningsim.engine.Handler;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public abstract class Entity implements Comparable<Entity> {

	protected float x, y;
	protected int width, height;
	protected Handler handler;
	protected Rectangle boundBox;
	protected boolean eActive = true;
	
	public Entity(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.boundBox = new Rectangle(0, 0, width, height);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void die();
	
	public Rectangle getBounds(float xOff, float yOff) {
		return new Rectangle((int)(x+boundBox.x+xOff), (int)(y+boundBox.y+yOff), boundBox.width, boundBox.height);
	}
	
	public boolean entityCollidedRunner(float xOff, float yOff) {
		for (Entity e : handler.getLevel().getEntityController().getEntities()) {
			if (e.equals(this)) {continue;}
			if (e instanceof Runner) {
				if (e.getBounds(0f, 0f).intersects(getBounds(xOff, yOff))) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean entityCollided(float xOff, float yOff) {
		for (Entity e : handler.getLevel().getEntityController().getEntities()) {
			if (e.equals(this)) {continue;}
			if (e.getBounds(0f, 0f).intersects(getBounds(xOff, yOff))) {
				return true;
			}
		}
		return false;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	// To decide which entities are visible at what times
	public int compareTo(Entity e) {
		if (this.getY() + this.getHeight() < e.getY() + e.getHeight()) {return -1;}
		else {return 1;}
	}
	
	public boolean isActive() {
		return eActive;
	}
	
}
