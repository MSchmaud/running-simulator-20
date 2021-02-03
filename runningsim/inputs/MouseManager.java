package us.mschmaud.runningsim.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import us.mschmaud.runningsim.ui.UIController;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class MouseManager implements MouseListener, MouseMotionListener {
	
	private boolean lClick, rClick;
	private int mouseX, mouseY;
	private UIController uiController;
	
	public MouseManager() {
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if (uiController != null) {uiController.onMouseMoved(e);}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {lClick = true;}
		else if (e.getButton() == MouseEvent.BUTTON3) {rClick = true;}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {lClick = false;}
		else if (e.getButton() == MouseEvent.BUTTON3) {rClick = false;}
		
		if (uiController != null && e.getButton() == MouseEvent.BUTTON1) {uiController.onMouseReleased(e);}
		
	}
	
	public boolean getLClick() {
		return lClick;
	}
	
	public boolean getRClick() {
		return rClick;
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
	public void setUIController(UIController uiController) {
		this.uiController = uiController;
	}
	
	public UIController getUIController() {
		return this.uiController;
	}
	
}
