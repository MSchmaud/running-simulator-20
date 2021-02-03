package us.mschmaud.runningsim.states;

import java.awt.Graphics;

import us.mschmaud.runningsim.engine.Handler;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public abstract class State {

	// Manage states
	private static State currentState = null;
	private static State lastState = null;
	private static long oldTime;
	protected static final long BUFFER_TIME = 200;	// Wait this long between switching states
	
	public static void setState(State state) {
		lastState = currentState;
		currentState = state;
		currentState.preload();
		oldTime = System.currentTimeMillis();	// Smooths out transitions
	}
	
	public static State getState() {
		return currentState;
	}
	
	public static State getLastState() {
		return lastState;
	}
	
	public static long getTimer() {
		return System.currentTimeMillis() - oldTime;
	}

	public static void resetTimer() {
		oldTime = System.currentTimeMillis();
	}
	
	// Actual state stuff
	
	protected Handler handler;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void preload();
	
}
