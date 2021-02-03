package us.mschmaud.runningsim.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean left, right, up, down, sprint, esc;
	
	public KeyManager() {
		keys = new boolean[256];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	public void tick() {
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		sprint = keys[KeyEvent.VK_SHIFT];
		esc = keys[KeyEvent.VK_ESCAPE];
	}

}
