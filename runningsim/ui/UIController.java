package us.mschmaud.runningsim.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import us.mschmaud.runningsim.engine.Handler;

public class UIController {

	private Handler handler;
	private ArrayList<Feature> features;
	
	public UIController(Handler handler) {
		this.setHandler(handler);
		features = new ArrayList<Feature>();
	}
	
	public void tick() {
		for (int i=0; i < features.size(); i++) {
			if (features.get(i).getFunctional()) {
				features.get(i).tick();
			}
		}
	}
	
	public void render(Graphics g) {
		for (Feature f : features) {
			if (f.getFunctional()) {
				f.render(g);
			}
		}
	}
	
	public void onMouseMoved(MouseEvent e) {
		for (Feature f : features) {
			f.onMouseMoved(e);
		}
	}
	
	public void onMouseReleased(MouseEvent e) {
		for (Feature f : features) {
			f.onMouseReleased(e);
		}
	}
	
	public void add(Feature f) {
		features.add(f);
	}
	
	public void remove(Feature f) {
		features.remove(f);
	}
	
	public void setFunctional(Feature f, boolean b) {
		features.get(features.indexOf(f)).setFunctional(b);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
}
