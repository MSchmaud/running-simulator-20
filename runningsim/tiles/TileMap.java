package us.mschmaud.runningsim.tiles;

import java.awt.Graphics;
import java.util.ArrayList;

import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.entities.Coffee;
import us.mschmaud.runningsim.entities.Coin;
import us.mschmaud.runningsim.entities.EntityController;
import us.mschmaud.runningsim.entities.FastZombie;
import us.mschmaud.runningsim.entities.Zombie;
import us.mschmaud.runningsim.entities.Runner;
import us.mschmaud.runningsim.entities.Spawner;
import us.mschmaud.runningsim.utils.Tools;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class TileMap {

	private static int width, height, spawnX, spawnY, numEnemies, numSpawners;
	private int[][] map;
	private Handler handler;
	private EntityController eController;
	
	public TileMap(Handler handler, String loc, String id) {
		this.handler = handler;
		eController = new EntityController(handler);
		loadFromFile(loc);
		eController.setUser(new Runner(handler, spawnX, spawnY, id));
	}
	
	public void tick() {
		eController.tick();
	}
	
	public void render(Graphics g) {
		// Find the currently viewable area of the screen
		int leftX = (int)Math.max(0, handler.getCamera().getxOff()/Tile.TILE_WIDTH); 
		int rightX = (int)Math.min(width, (handler.getCamera().getxOff()+handler.getWidth())/Tile.TILE_WIDTH+1); 
		int topY = (int)Math.max(0, handler.getCamera().getyOff()/Tile.TILE_HEIGHT);
		int bottomY = (int)Math.min(height, (handler.getCamera().getyOff()+handler.getHeight())/Tile.TILE_HEIGHT+1);
		// Render just that area
		for (int y=topY; y < bottomY; y++) {
			for (int x=leftX; x < rightX; x++) {
				getTile(x, y).render(g, (int)(x*Tile.TILE_WIDTH - handler.getCamera().getxOff()), (int)(y*Tile.TILE_HEIGHT - handler.getCamera().getyOff()));
			}
		}
		eController.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= width) {return Tile.grass;}	// Prevents glitching outside map
		Tile t = Tile.tiles[map[x][y]];
		if (t == null) {return Tile.grass;}
		return t;
	}
	
	public void loadFromFile(String loc) {
		String file = Tools.fileToString(loc);
		String[] temp = file.split("\\s+");
		ArrayList<String> vals = new ArrayList<>();
		for (int i=0; i < temp.length; i++) {
			if (!temp[i].contains("//")) {
				vals.add(temp[i]);
			}
		}
		
		width = Tools.parseInt(vals.get(0));
		height = Tools.parseInt(vals.get(1));
		spawnX = Tools.parseInt(vals.get(2));
		spawnY = Tools.parseInt(vals.get(3));
		numEnemies = Tools.parseInt(vals.get(4));
		numSpawners = Tools.parseInt(vals.get(5+numEnemies*2));
		
		// Spawn enemies
		if (numEnemies > 0) {
			for (int i=5; i < 5+(numEnemies*2-1); i+=2) {
				int x = Tools.parseInt(vals.get(i));
				int y = Tools.parseInt(vals.get(i+1));
				if (Math.random() < 0.2) {eController.add(new FastZombie(handler, (float)x, (float)y));}
				else {eController.add(new Zombie(handler, (float)x, (float)y, "random"));}
			}
		}
		
		// Create spawners
		if (numSpawners > 0) {
			for (int i=7+(numEnemies*2-1); i < 7+(numEnemies*2-1)+(numSpawners*2-1); i += 2) {
				int x = Tools.parseInt(vals.get(i));
				int y = Tools.parseInt(vals.get(i+1));
				eController.add(new Spawner(handler, (float)x, (float)y, "random", 1, 10000));
			}
		}
		
		// Create coins
		int numCoins = (int) (Math.random() * 40) + 60;
		int convertedW = width*Tile.TILE_WIDTH;
		int convertedH = height * Tile.TILE_HEIGHT;
		for (int i=0; i < numCoins; i++) {
			int x = (int) (Tile.TILE_WIDTH + ((Math.random()*(convertedW-130))));
			int y = (int) (Tile.TILE_HEIGHT + ((Math.random()*(convertedH-130))));
			if (notSpawnable(x, y)) {continue;}							// Supposed to make it so coins don't spawn in walls, doesn't work
			eController.add(new Coin(handler, (float)x, (float)y));
		}
		
		// Create coffee
		for (int i=0; i < 10; i++) {
			int x = (int) (Tile.TILE_WIDTH + ((Math.random()*(convertedW-130))));
			int y = (int) (Tile.TILE_HEIGHT + ((Math.random()*(convertedH-130))));
			if (notSpawnable(x, y)) {continue;}							// Supposed to make it so coffee doesn't spawn in walls, doesn't work
			eController.add(new Coffee(handler, (float)x, (float)y));
		}
		
		map = new int[width][height];
		for (int y=0; y < height; y++) {
			for (int x=0; x < width; x++) {
				map[x][y] = Tools.parseInt(vals.get((x + (y * width)) + 6 + (numEnemies*2) + (numSpawners*2)));
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getSpawnX() {
		return spawnX;
	}
	
	public int getSpawnY() {
		return spawnY;
	}
	
	public EntityController getEntityController() {
		return eController;
	}
	
	public boolean notSpawnable(int x, int y) {
		while (x % Tile.TILE_WIDTH != 0) {
			x--;
		}
		while (y % Tile.TILE_HEIGHT != 0) {
			y--;
		}
		return getTile(x, y).isWall();
	}
	
}
