package us.mschmaud.runningsim.entities;

import java.awt.Graphics;

import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.entities.Entity;
import us.mschmaud.runningsim.tiles.Tile;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public abstract class Enemy extends Entity {
	
	public static final int NORM_WIDTH = 32, NORM_HEIGHT = 32;
	public static final float NORM_SPEED = 4.0f;
	public static final int NORM_HEALTH = 100;
	
	protected float speed;
	protected float deltaX, deltaY;
	protected double health;
	protected boolean hasCollided;

	public Enemy(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		this.speed = NORM_SPEED;
		this.deltaX = 0; 
		this.deltaY = 0;
		this.health = NORM_HEALTH;
		
	}
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		
	}
	
	protected boolean collided(int x, int y) {
		return handler.getLevel().getTile(x, y).isWall();
	}
	
	public void masterMove() {
		if (!entityCollidedRunner(deltaX, 0f)) {moveX();}
		if (!entityCollidedRunner(0f, deltaY)) {moveY();}
	}
	
	public void moveX() {
		// Going left
		if (deltaX < 0) {
			int tileX = (int)(x+deltaX+boundBox.x)/Tile.TILE_WIDTH;
			if ((!collided(tileX, (int)(y+boundBox.y)/Tile.TILE_HEIGHT)) && (!collided(tileX, (int)(y+boundBox.height+boundBox.y)/Tile.TILE_HEIGHT))) {
				hasCollided = false;
				x += deltaX;
			}
			else {
				hasCollided = true;
				x = tileX*Tile.TILE_WIDTH + Tile.TILE_WIDTH-boundBox.x;
			}
		}
		// Going right
		else if (deltaX > 0) {
			int tileX = (int)(x+deltaX+boundBox.x+boundBox.width)/Tile.TILE_WIDTH;
			if ((!collided(tileX, (int)(y+boundBox.y)/Tile.TILE_HEIGHT)) && (!collided(tileX, (int)(y+boundBox.height+boundBox.y)/Tile.TILE_HEIGHT))) {
				hasCollided = false;
				x += deltaX;
			}
			else {
				hasCollided = true;
				x = tileX*Tile.TILE_WIDTH - boundBox.x-boundBox.width-1;
				}
		}
	}
	
	public void moveY() {
		// Going up
		if (deltaY < 0) {
			int tileY = (int)(y+deltaY+boundBox.y)/Tile.TILE_HEIGHT;
			if ((!collided((int)(x+boundBox.x)/Tile.TILE_WIDTH, tileY)) && (!collided((int)(x+boundBox.width+boundBox.x)/Tile.TILE_WIDTH, tileY))) {
				hasCollided = false;
				y += deltaY;
			}
			else {
				hasCollided = true;
				y = tileY*Tile.TILE_HEIGHT + Tile.TILE_HEIGHT-boundBox.y;
				}
		}
		// Going down
		else if (deltaY > 0) {
			int tileY = (int)(y+deltaY+boundBox.height+boundBox.y)/Tile.TILE_HEIGHT;
			if ((!collided((int)(x+boundBox.x)/Tile.TILE_WIDTH, tileY)) && (!collided((int)(x+boundBox.width+boundBox.x)/Tile.TILE_WIDTH, tileY))) {
				hasCollided = false;
				y += deltaY;
			}
			else {
				hasCollided = true;
				y = tileY*Tile.TILE_HEIGHT - boundBox.y-boundBox.height-1;
				}
		}
	}
	
	public double getHealth() {
		return health;
	}
	
	public void setHealth(double h) {
		health = h;
	}
	
	public void chgHealth(double h) {
		health += h;
	}

}
