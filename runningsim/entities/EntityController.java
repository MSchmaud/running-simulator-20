package us.mschmaud.runningsim.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import us.mschmaud.runningsim.engine.Handler;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class EntityController {

	private Runner user;
	private ArrayList<Entity> entities;
	private Handler handler;
	
	public EntityController(Handler handler) {
		this.handler = handler;
		entities = new ArrayList<Entity>();
	}
	
	public void tick() {
		for (int i=0; i < entities.size(); i++) {
			if (entities.get(i).isActive()) {entities.get(i).tick();}
		}
		entities.sort(null);	// Renders objects based on perception using y-values
	}
	
	public void render(Graphics g) {
		for (int i=0; i < entities.size(); i++) {
			if (entities.get(i).isActive()) {entities.get(i).render(g);}
		}
	}
	
	public void add(Entity e) {
		entities.add(e);
	}
	
	public Handler getHandler() {
		return handler;
	}
	
	public Runner getUser() {
		return user;
	}
	
	public void setUser(Runner r) {
		user = r;
		entities.add(0, user);
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
}
