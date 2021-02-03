package us.mschmaud.runningsim.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import us.mschmaud.runningsim.displayaudio.Animate;
import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.utils.Tools;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Spawner extends Entity {

	private Animate spawnerFrames;
	private String type;
	private boolean active = true;
	private int spawnAmt;
	private long spawnCD, oldTime, timer;
	
	public Spawner(Handler handler, float x, float y, String type, int spawnAmt, long spawnCD) {
		super(handler, x, y, 64, 64);
		this.type = type;
		this.spawnAmt = spawnAmt;
		this.spawnCD = spawnCD;
		this.oldTime = System.currentTimeMillis();
		spawnerFrames = new Animate(400, 0, "spawner");
	}

	@Override
	public void tick() {
		if (Tools.getDistance(x, y, handler.getLevel().getEntityController().getUser().getX(), 
				handler.getLevel().getEntityController().getUser().getY()) < Mob.TARGET_DISTANCE) {
			active = true;
		}
		else {active = false;}
		
		if (active) {
			spawnerFrames.tick();
			timer += System.currentTimeMillis() - oldTime;
			oldTime = System.currentTimeMillis();
			if (timer > spawnCD) {
				spawn();
				timer = 0;
			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getFrame(), (int)(x - handler.getCamera().getxOff()), (int)(y - handler.getCamera().getyOff()), this.width, this.height, null);
	}
	
	private void spawn() {
		// Random spawner
		if (type.equals("random")) {
			for (int i=0; i < spawnAmt; i++) {
				// (Math.random() * ( max - min )) + min
				int x = (int) ((Math.random()*((this.x+3*width/2)-(this.x-width/2))) + (this.x-width/2));
				int y = (int) ((Math.random()*((this.y+3*height/2)-(this.y-height/2))) + (this.y-height/2));
				if (Math.random() < 0.2) {handler.getLevel().getEntityController().add(new FastZombie(handler, (float)x, (float)y));}
				else {handler.getLevel().getEntityController().add(new Zombie(handler, (float)x, (float)y, "random"));}
			}
		}
		// Fast zombie spawner
		else if (type.equals("fast zombie")) {
			for (int i=0; i < spawnAmt; i++) {
				int x = (int) ((Math.random()*((this.x+3*width/2)-(this.x-width/2))) + (this.x-width/2));
				int y = (int) ((Math.random()*((this.y+3*height/2)-(this.y-height/2))) + (this.y-height/2));
				handler.getLevel().getEntityController().add(new FastZombie(handler, (float)x, (float)y));
			}
		}
		// Specific zombie spawner
		else {
			for (int i=0; i < spawnAmt; i++) {
				int x = (int) ((Math.random()*((this.x+3*width/2)-(this.x-width/2))) + (this.x-width/2));
				int y = (int) ((Math.random()*((this.y+3*height/2)-(this.y-height/2))) + (this.y-height/2));
				handler.getLevel().getEntityController().add(new Zombie(handler, (float)x, (float)y, type));
			}
		}
	}
	
	private BufferedImage getFrame() {
		if (!active) {return spawnerFrames.getFrameAt(0);}
		else if (timer > spawnCD-1000) {return spawnerFrames.getFrameAt(1);}
		else {return spawnerFrames.getFrame();}
	}

	@Override
	public void die() {
		eActive = false;
	}

}
