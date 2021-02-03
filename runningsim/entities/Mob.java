package us.mschmaud.runningsim.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.tiles.Tile;
import us.mschmaud.runningsim.utils.Tools;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Mob extends SpriteEntity {
	
	public static final int TARGET_DISTANCE = 400;
	
	private boolean attackL, attackR, attackU, attackD = false;
	private int attackTimer = 0, attackCD = 50, attackDMG = 10;	// Put back to 1
	
	public Mob(Handler handler, float x, float y, String id) {
		super(handler, x, y, 64, 64, id);
		speed = NORM_MOB_SPEED - (float)Math.random();	// Give mobs random speeds, but always slower than the runner
		animSpeed = 200;
		this.boundBox.x = 18;
		this.boundBox.y = 0;
		this.boundBox.width = 27;
		this.boundBox.height = 62;
		
		if (this.id.equals("random")) {this.id = generateID();}
		createAnimations();
	}
	
	public boolean isAttackL() {
		return attackL;
	}

	public void setAttackL(boolean attackL) {
		this.attackL = attackL;
	}

	public boolean isAttackR() {
		return attackR;
	}

	public void setAttackR(boolean attackR) {
		this.attackR = attackR;
	}

	public boolean isAttackU() {
		return attackU;
	}

	public void setAttackU(boolean attackU) {
		this.attackU = attackU;
	}

	public boolean isAttackD() {
		return attackD;
	}

	public void setAttackD(boolean attackD) {
		this.attackD = attackD;
	}

	public int getAttackCD() {
		return attackCD;
	}

	public void setAttackCD(int attackCD) {
		this.attackCD = attackCD;
	}

	public int getAttackDMG() {
		return attackDMG;
	}

	public void setAttackDMG(int attackDMG) {
		this.attackDMG = attackDMG;
	}

	public int getAttackTimer() {
		return attackTimer;
	}
	
	public void tickAttackTimer() {
		attackTimer++;
	}
	
	public void resetAttackTimer() {
		attackTimer = 0;
	}
	
	private String generateID() {
		double p = Math.random();
		if (p < 0.25) {return "zombie_blue";}
		else if (p < 0.5) {return "zombie_green";}
		else if (p < 0.75) {return "zombie_pink";}
		else {return "zombie_white";}
	}
	
	@Override
	public void tick() {
		Runner runner = handler.getLevel().getEntityController().getUser();
		downFrames.tick();
		upFrames.tick();
		leftFrames.tick();
		rightFrames.tick();
		// Attack
		if (entityCollidedRunner(deltaX, deltaY)) {
			// Figure out where the runner is being attacked from, manage the attack damage and animations
			float xDiff = x - runner.getX();
			float yDiff = y - runner.getY();
			if (attackTimer > attackCD) {attackTimer = 0;}
			if (xDiff >= yDiff) {
				if (xDiff > 0) {
					// Attack from right
					attackR = true;
					if (attackTimer == 0) {
						runner.chgHealth(-attackDMG);
						x += 10;
					}
				}
				else if (deltaX > 0){
					// Attack from left
					attackL = true;
					if (attackTimer == 0) {
						runner.chgHealth(-attackDMG);
						x -= 10;
					}
				}
			}
			else if (yDiff > xDiff) {
				if (yDiff > 0) {
					// Attack from below
					attackU = true;
					if (attackTimer == 0) {
						runner.chgHealth(-attackDMG);
						y += 10;
					}
				}
				else if (deltaY > 0){
					// Attack from above
					attackD = true;
					if (attackTimer == 0) {
						runner.chgHealth(-attackDMG);
						y -= 10;
					}
				}
			}
			runner.resetRegenTimer();
			attackTimer++;
		}
		// Allow regeneration of the runner's health over time
		else {
			if (runner.getRegenTimer() >= runner.getRegenCD()) {
				if (runner.getHealTimer() >= runner.getHealCD()) {
					runner.regen();
					runner.resetHealTimer();
				}
				else {
					runner.tickHealTimer();
				}
			}
			else {
				runner.tickRegenTimer();
			}
		}
		// Chase the runner
		follow(runner);
	}
	
	private void follow(Runner runner) {
		if (!entityCollidedRunner(deltaX, 0f)) {moveX();}
		if (!entityCollidedRunner(0f, deltaY)) {moveY();}
		
		float distance = Tools.getDistance(x, y, runner.getX(), runner.getY());
		// Only chase if within 400 pixels
		
		// This extra block make the chase more smooth
		if (distance < 75) {
			deltaX = (-1/distance)*(x-runner.getX());
			deltaY = (-1/distance)*(y-runner.getY());
		}
		else if (distance < TARGET_DISTANCE) {
			if (x > runner.getX()-16 && x < runner.getX()+32) {
				deltaX = 0;
			}
			else {
				deltaX = (-1/distance)*(x-runner.getX());
			}
			if (y > runner.getY()-16 && y < runner.getY()+32) {
				deltaY = 0;
			}
			else {
				deltaY = (-1/distance)*(y-runner.getY());
			}
		}
		else {
			deltaX = 0;
			deltaY = 0;
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getFrame(), (int)(x - handler.getCamera().getxOff()), (int)(y - handler.getCamera().getyOff()), this.width, this.height, null);
	}
	
	@Override
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
	
	@Override
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
	
	@Override
	protected BufferedImage getFrame() {
		if (attackU || attackD) {
			attackU = false;
			attackD = false;
			attackL = false;
			attackR = false;
			return idle;
			} 
		else if (attackR) {
			attackR = false;
			attackL = false;
			attackU = false;
			attackD = false;
			return leftFrames.getFrameAt(0);
			}
		else if (attackL) {
			attackL = false;
			attackR = false;
			attackU = false;
			attackD = false;
			return rightFrames.getFrameAt(0);
			}
		if (deltaX > 0) {return rightFrames.getFrame();}
		else if (deltaX < 0) {return leftFrames.getFrame();}
		else if (deltaY > 0) {return downFrames.getFrame();}
		else if (deltaY < 0) {return upFrames.getFrame();}
		else {return idle;}
	}

	@Override
	public void die() {
		eActive = false;
	}

}
