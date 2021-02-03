package us.mschmaud.runningsim.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public abstract class Feature {

	protected float x, y;
	protected int width, height;
	protected boolean focused = false;
	protected Rectangle boundBox;
	protected boolean functional = true;
	
	public Feature(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.boundBox = new Rectangle((int)x, (int)y, width, height);
		
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void onClick();
	
	public void onMouseMoved(MouseEvent e) {
		if (this.boundBox.contains(e.getX(), e.getY())) {this.focused = true;}
		else {this.focused = false;}
	}
	
	public void onMouseReleased(MouseEvent e) {
		if (this.focused) {
			onClick();
		}
	}

	public float getX() {
		return this.x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return this.y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isFocused() {
		return this.focused;
	}

	public void setFocused(boolean hovering) {
		this.focused = hovering;
	}
	
	public boolean getFunctional() {
		return functional;
	}
	
	public void setFunctional(boolean b) {
		functional = b;
	}
	
}
