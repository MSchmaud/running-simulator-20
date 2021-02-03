package us.mschmaud.runningsim.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import us.mschmaud.runningsim.displayaudio.Resources;
import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.states.State;
import us.mschmaud.runningsim.ui.Score;
import us.mschmaud.runningsim.utils.Tools;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Runner extends SpriteEntity {
	
	private int staminaTimer = 0, staminaCD = 100, stamina = 100;
	private float lastMouseX, lastMouseY;
	private String controls;
	private int coins = 0;
	private boolean cafRush = false;
	private long cafTime;
	private final long CAF_RUSH_LENGTH = 15000;
	
	public Runner(Handler handler, float x, float y, String id) {
		super(handler, x, y, 64, 64, id);
		this.boundBox.x = 18;
		this.boundBox.y = 0;
		this.boundBox.width = 27;
		this.boundBox.height = 62;
		setAnimSpeed(100);
		lastMouseX = this.x;
		lastMouseY = this.y;
		controls = handler.getControls();
	}
	
	private void getKeyInput() {
		this.deltaX = 0;
		this.deltaY = 0;
		float currentSpeed;
		
		if (handler.getKeyManager().sprint && stamina > 0) {
			setAnimSpeed(50);
			currentSpeed = this.speed * 1.8f;
			stamina --;
			staminaTimer = 0;
		}
		
		else if (handler.getKeyManager().sprint) {
			setAnimSpeed(100);
			currentSpeed = this.speed;
			staminaTimer = 0;
		}
		
		else {
			setAnimSpeed(100);
			if (staminaTimer < staminaCD) {staminaTimer++;}
			currentSpeed = this.speed;
			if (stamina < 100 && staminaTimer >= staminaCD) {
				stamina++;
			}
		}
		
		if (handler.getKeyManager().left) {this.deltaX -= currentSpeed;}
		if (handler.getKeyManager().right) {this.deltaX += currentSpeed;}
		if (handler.getKeyManager().up) {this.deltaY -= currentSpeed;}
		if (handler.getKeyManager().down) {this.deltaY += currentSpeed;}
	}
	
	// Allows click-to-move controls
	private void moveToLoc(float x, float y) {
		if (!entityCollidedRunner(deltaX, 0f)) {moveX();}
		if (!entityCollidedRunner(0f, deltaY)) {moveY();}
		
		float distance = Tools.getDistance(this.x, this.y, x+handler.getCamera().getxOff(), y+handler.getCamera().getyOff());
		
		// This extra block make the chase more smooth
		if (distance < 75) {
			deltaX = (-1/distance)*(this.x-x)*speed*speed*(speed/2);
			deltaY = (-1/distance)*(this.y-y)*speed*speed*(speed/2);
		}
		else if (distance > 0) {
			if (this.x > x-16 && this.x < x+32) {
				deltaX = 0;
			}
			else {
				deltaX = (-1/distance)*(this.x-x)*speed*speed*(speed/2);
			}
			if (this.y > y-16 && this.y < y+32) {
				deltaY = 0;
			}
			else {
				deltaY = (-1/distance)*(this.y-y)*speed*speed*(speed/2);
			}
		}
		else {
			deltaX = 0;
			deltaY = 0;
		}
	}

	@Override
	public void tick() {
		if (cafRush) {
			stamina = 100000;
			if (System.currentTimeMillis()-cafTime > CAF_RUSH_LENGTH) {
				cafRush = false;
				stamina = 100;
			}
		}
		downFrames.tick();
		upFrames.tick();
		leftFrames.tick();
		rightFrames.tick();
		if (controls.equals("Keyboard")) {	// Keyboard controls
			getKeyInput();
			masterMove();
			lastMouseX = x;		// Fixes a bug where switching back to click controls forces runner to a previous location
			lastMouseY = y;
		}
		// Click to move controls (still extremely buggy)
		else {
			if (handler.getMouseManager().getLClick()) {
				lastMouseX = (handler.getMouseManager().getMouseX() + handler.getCamera().getxOff()) - width/2;
				lastMouseY = (handler.getMouseManager().getMouseY() + handler.getCamera().getyOff()) - height/2;
			}
			if ((int)lastMouseX != (int)this.x || (int)lastMouseY != (int)this.y) {
				moveToLoc(lastMouseX, lastMouseY);
			}
			else {
				deltaX = 0;
				deltaY = 0;
			}
		}
		handler.getCamera().setFocus(this);
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(getFrame(), (int)(x - handler.getCamera().getxOff()), (int)(y - handler.getCamera().getyOff()), this.width, this.height, null);
		drawSprintBar(g);
		drawHealthBar(g);
		// Collision debug
		//g.setColor(Color.RED);
		//g.drawRect((int)(x+boundBox.x-handler.getCamera().getxOff()), (int)(y+boundBox.y-handler.getCamera().getyOff()), boundBox.width, boundBox.height);
		
	}
	
	public void die() {
		Score.addScore(coins);
		if (!handler.getMute()) {
			handler.getGameState().getPlayer().setFile(Resources.deathSound);
			handler.getGameState().getPlayer().play();
		}
		eActive = false;
		State.setState(handler.getDeathState());
	}
	
	private void drawSprintBar(Graphics g) {
		if (controls.equals("Keyboard")) {
			if (cafRush) {
				g.setColor(Color.RED);
				g.setFont(Resources.alertFont);
				g.drawString("Caffeine Rush!", handler.getWidth()/2-70, 25);
			}
			if (stamina < 100) {
				g.setColor(Color.WHITE);
				g.drawRect(590, 10, 200, 15);
				if (stamina > 0) {g.fillRect(590, 10, stamina*2, 15);}
			}
		}
	}
	
	private void drawHealthBar(Graphics g) {
		if (health < 100) {
			g.setColor(Color.PINK);
			g.drawRect(handler.getWidth()/2-200, 525, 400, 25);
			if (health > 0) {g.fillRect(handler.getWidth()/2-200, 525, (int)health*4, 25);}
		}
	}
	
	@Override
	protected BufferedImage getFrame() {
		if (deltaX > 0) {return rightFrames.getFrame();}
		else if (deltaX < 0) {return leftFrames.getFrame();}
		else if (deltaY > 0) {return downFrames.getFrame();}
		else if (deltaY < 0) {return upFrames.getFrame();}
		else {return idle;}
	}
	
	public void setControls(String c) {
		controls = c;
	}
	
	public String getControls() {
		return controls;
	}
	
	public void pickupCoin() {
		coins++;
		if (!handler.getMute()) {
			handler.getGameState().getPlayer().setFile(Resources.coinSound);
			handler.getGameState().getPlayer().play();
		}
	}
	
	public void drinkCoffee() {
		cafRush = true;
		cafTime = System.currentTimeMillis();
		if (!handler.getMute()) {
			handler.getGameState().getPlayer().setFile(Resources.drinkSound);
			handler.getGameState().getPlayer().play();
		}
	}
	
	public int getCoins() {
		return coins;
	}

}
