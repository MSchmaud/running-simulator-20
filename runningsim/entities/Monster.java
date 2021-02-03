package us.mschmaud.runningsim.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import us.mschmaud.runningsim.display.Animate;
import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.tiles.Tile;
import us.mschmaud.runningsim.utils.Tools;

public class Monster extends Enemy {
	
	private Animate downFrames, upFrames, leftFrames, rightFrames;
	private BufferedImage idle;

	public Monster(Handler handler, float x, float y, String id) {
		super(handler, x, y, 64, 64);
		speed = NORM_SPEED - (float)Math.random();
		this.boundBox.x = 18;
		this.boundBox.y = 0;
		this.boundBox.width = 27;
		this.boundBox.height = 62;
		
		downFrames = new Animate(100, 0, id);
		idle = downFrames.getFrameAt(1);
		upFrames = new Animate(100, 1, id);
		leftFrames = new Animate(100, 2, id);
		rightFrames = new Animate(100, 3, id);
	}
	
	public void tick() {
		Runner runner = handler.getLevel().getEntityController().getUser();
		downFrames.tick();
		upFrames.tick();
		leftFrames.tick();
		rightFrames.tick();
		if (entityCollidedRunner(deltaX, deltaY)) {runner.chgHealth(-.1);}
		if (!entityCollidedRunner(deltaX, 0f)) {moveX();}
		if (!entityCollidedRunner(0f, deltaY)) {moveY();}
		float distance = Tools.getDistance(x, y, runner.getX(), runner.getY());
		if (distance < 400) {
			deltaX = (-1/distance)*(x-runner.getX());
			deltaY = (-1/distance)*(y-runner.getY());
		}
		else {
			deltaX = 0;
			deltaY = 0;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(getFrame(), (int)(x - handler.getCamera().getxOff()), (int)(y - handler.getCamera().getyOff()), this.width, this.height, null);
	}
	
	public void moveX() {
		// Going left
		if (deltaX < 0) {
			int tileX = (int)(x+deltaX+boundBox.x)/Tile.TILE_WIDTH;
			if ((!collided(tileX, (int)(y+boundBox.y)/Tile.TILE_HEIGHT)) && (!collided(tileX, (int)(y+boundBox.height+boundBox.y)/Tile.TILE_HEIGHT))) {
				hasCollided = false;
				x += deltaX*speed;
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
				x += deltaX*speed;
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
				y += deltaY*speed;
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
				y += deltaY*speed;
			}
			else {
				hasCollided = true;
				y = tileY*Tile.TILE_HEIGHT - boundBox.y-boundBox.height-1;
			}
		}
	}
	
	private BufferedImage getFrame() {
		if (entityCollidedRunner(deltaX, deltaY)) {return idle;} 
		if (deltaX > 0) {return rightFrames.getFrame();}
		else if (deltaX < 0) {return leftFrames.getFrame();}
		else if (deltaY > 0) {return downFrames.getFrame();}
		else if (deltaY < 0) {return upFrames.getFrame();}
		else {return idle;}
	}
	
}
