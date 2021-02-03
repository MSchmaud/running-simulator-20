package us.mschmaud.runningsim.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile dirt = new Dirt(0);
	public static Tile grass = new Grass(1);
	public static Tile stone = new Stone(2);
	public static Tile border = new Border(3);
	public static Tile wood = new Wood(4);
	public static Tile woodFloor = new WoodFloor(5);
	public static Tile water = new Water(6);
	public static Tile stoneFloor = new StoneFloor(7);
	
	
	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	protected boolean wall = false;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(this.texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean isWall() {
		return this.wall;
	}
	
}
