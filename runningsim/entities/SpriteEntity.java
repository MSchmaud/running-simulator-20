package us.mschmaud.runningsim.entities;

import java.awt.image.BufferedImage;
import us.mschmaud.runningsim.displayaudio.Animate;
import us.mschmaud.runningsim.displayaudio.Resources;
import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.entities.Entity;
import us.mschmaud.runningsim.tiles.Tile;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public abstract class SpriteEntity extends Entity {
	
	public static final int NORM_WIDTH = 32, NORM_HEIGHT = 32;
	public static final float NORM_SPEED = 4.0f, NORM_MOB_SPEED = 3.0f;
	public static final int NORM_HEALTH = 100;
	
	protected Animate downFrames, upFrames, leftFrames, rightFrames;
	protected BufferedImage idle;
	protected String id;
	protected String[] attributes;
	protected float speed;
	protected int animSpeed, regenTimer = 0, regenCD = 100, regenAmt = 1;
	protected int healTimer = 0, healCD = 50;
	protected float deltaX, deltaY;
	protected double health, maxHealth;
	protected boolean hasCollided;

	public SpriteEntity(Handler handler, float x, float y, int width, int height, String id) {
		super(handler, x, y, width, height);
		this.id = id;
		attributes = this.id.split("_");
		this.speed = NORM_SPEED;
		this.deltaX = 0; 
		this.deltaY = 0;
		this.maxHealth = NORM_HEALTH;
		this.health = maxHealth;
		createAnimations();
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
	
	public void createAnimations() {
		downFrames = new Animate(animSpeed, 0, id);
		idle = downFrames.getFrameAt(1);
		upFrames = new Animate(animSpeed, 1, id);
		leftFrames = new Animate(animSpeed, 2, id);
		rightFrames = new Animate(animSpeed, 3, id);
	}
	
	public void setAnimSpeed(int speed) {
		animSpeed = speed;
		downFrames.setSpeed(animSpeed);
		upFrames.setSpeed(animSpeed);
		leftFrames.setSpeed(animSpeed);
		rightFrames.setSpeed(animSpeed);
	}
	
	protected BufferedImage getFrame() {
		if (deltaX > 0) {return rightFrames.getFrame();}
		else if (deltaX < 0) {return leftFrames.getFrame();}
		else if (deltaY > 0) {return downFrames.getFrame();}
		else if (deltaY < 0) {return upFrames.getFrame();}
		else {return idle;}
	}
	
	public double getHealth() {
		return health;
	}
	
	public void setHealth(double h) {
		health = h;
	}
	
	public void chgHealth(double h) {
		health += h;
		if (h < 0 && !handler.getMute()) {
			handler.getGameState().getPlayer().setFile(Resources.hitSound);
			handler.getGameState().getPlayer().play();
		}
		if (health <= 0) {die();}
	}
	
	public void setIdle(BufferedImage img) {
		idle = img;
	}
	
	public BufferedImage getIdle() {
		return idle;
	}
	
	public void updateID(String id) {
		this.id = id;
		attributes = this.id.split("_");
		createAnimations();
	}
	
	public void setSize(int size) {
		width = size;
		height = size;
	}
	
	public void resetRegenTimer() {
		regenTimer = 0;
	}
	
	public void tickRegenTimer() {
		regenTimer++;
	}
	
	public int getRegenTimer() {
		return regenTimer;
	}
	
	public void setRegenCD(int c) {
		regenCD = c;
	}
	
	public int getRegenCD() {
		return regenCD;
	}
	
	public void regen() {
		health += regenAmt;
		if (health > maxHealth) {health = maxHealth;}
	}
	
	public void resetHealTimer() {
		healTimer = 0;
	}
	
	public void tickHealTimer() {
		healTimer++;
	}
	
	public int getHealTimer() {
		return healTimer;
	}
	
	public void setHealCD(int c) {
		healCD = c;
	}
	
	public int getHealCD() {
		return healCD;
	}
	
	public String[] getAttributes() {
		return attributes;
	}
	
	public void setAttribute(int ind, String atr) {
		attributes[ind] = atr;
		String id = attributes[0].toLowerCase() + "_" + attributes[1].toLowerCase() + "_" + attributes[2].toLowerCase() + "_" + attributes[3].toLowerCase();
		updateID(id);
	}
	
	

}
