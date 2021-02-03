package us.mschmaud.runningsim.display;

import java.awt.image.BufferedImage;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Animate {

	private int imageCycle, speed;
	private BufferedImage[] frames;
	private long oldTime, timer;
	
	public Animate(int speed, int dir, String id) {
		this.imageCycle = 0;
		this.speed = speed;
		this.frames = createFrames(dir, id);
		this.oldTime = System.currentTimeMillis();
		this.timer = 0;
	}

	public void tick() {
		timer += System.currentTimeMillis() - oldTime;
		oldTime = System.currentTimeMillis();
		if (timer > speed) {
			imageCycle++;
			timer = 0;
			if (imageCycle >= frames.length) {imageCycle = 0;}
		}
	}
	
	private BufferedImage[] createFrames(int dir, String id) {
		if (dir == -1) {
			return Resources.titleScreen;
		}
		else {
			// Male
			if (id.substring(0, 4).equals("male")) {
				// Male dark skin
				if (id.substring(5, 9).equals("dark")) {
					// Male dark skin blue top
					if (id.substring(10, 14).equals("blue")) {
						// Male dark skin blue top blue shoes
						if (id.substring(15).equals("blue")) {
							if (dir == 0) {return Resources.jamirbbDown;}		// Down
							else if (dir == 1) {return Resources.jamirbbUp;}	// Up
							else if (dir == 2) {return Resources.jamirbbLeft;}	// Left
							else if (dir == 3) {return Resources.jamirbbRight;}	// Right
						}
						// Male dark skin blue top gold shoes
						else if (id.substring(15).equals("gold")) {
							if (dir == 0) {return Resources.jamirbgDown;}		// Down
							else if (dir == 1) {return Resources.jamirbgUp;}	// Up
							else if (dir == 2) {return Resources.jamirbgLeft;}	// Left
							else if (dir == 3) {return Resources.jamirbgRight;}	// Right
						}
						// Male dark skin blue top red shoes
						else {
							if (dir == 0) {return Resources.jamirbrDown;}		// Down
							else if (dir == 1) {return Resources.jamirbrUp;}	// Up
							else if (dir == 2) {return Resources.jamirbrLeft;}	// Left
							else if (dir == 3) {return Resources.jamirbrRight;}	// Right
						}
					}
					// Male dark skin pink top
					else if (id.substring(10, 14).equals("pink")) {
						// Male dark skin pink top blue shoes
						if (id.substring(15).equals("blue")) {
							if (dir == 0) {return Resources.jamirpbDown;}		// Down
							else if (dir == 1) {return Resources.jamirpbUp;}	// Up
							else if (dir == 2) {return Resources.jamirpbLeft;}	// Left
							else if (dir == 3) {return Resources.jamirpbRight;}	// Right
						}
						// Male dark skin pink top gold shoes
						else if (id.substring(15).equals("gold")) {
							if (dir == 0) {return Resources.jamirpgDown;}		// Down
							else if (dir == 1) {return Resources.jamirpgUp;}	// Up
							else if (dir == 2) {return Resources.jamirpgLeft;}	// Left
							else if (dir == 3) {return Resources.jamirpgRight;}	// Right
						}
						// Male dark skin pink top red shoes
						else {
							if (dir == 0) {return Resources.jamirprDown;}		// Down
							else if (dir == 1) {return Resources.jamirprUp;}	// Up
							else if (dir == 2) {return Resources.jamirprLeft;}	// Left
							else if (dir == 3) {return Resources.jamirprRight;}	// Right
						}
					}
					// Male dark skin white top
					else {
						// Male dark skin white top blue shoes
						if (id.substring(16).equals("blue")) {
							if (dir == 0) {return Resources.jamirwbDown;}		// Down
							else if (dir == 1) {return Resources.jamirwbUp;}	// Up
							else if (dir == 2) {return Resources.jamirwbLeft;}	// Left
							else if (dir == 3) {return Resources.jamirwbRight;}	// Right
						}
						// Male dark skin white top gold shoes
						else if (id.substring(16).equals("gold")) {
							if (dir == 0) {return Resources.jamirwgDown;}		// Down
							else if (dir == 1) {return Resources.jamirwgUp;}	// Up
							else if (dir == 2) {return Resources.jamirwgLeft;}	// Left
							else if (dir == 3) {return Resources.jamirwgRight;}	// Right
						}
						// Male dark skin white top red shoes
						else {
							if (dir == 0) {return Resources.jamirwrDown;}		// Down
							else if (dir == 1) {return Resources.jamirwrUp;}	// Up
							else if (dir == 2) {return Resources.jamirwrLeft;}	// Left
							else if (dir == 3) {return Resources.jamirwrRight;}	// Right
						}
					}
				}
				// Male light skin
				else {
					// Male light skin blue top
					if (id.substring(11, 15).equals("blue")) {
						// Male light skin blue top blue shoes
						if (id.substring(16).equals("blue")) {
							if (dir == 0) {return Resources.joebbDown;}			// Down
							else if (dir == 1) {return Resources.joebbUp;}		// Up
							else if (dir == 2) {return Resources.joebbLeft;}	// Left
							else if (dir == 3) {return Resources.joebbRight;}	// Right
						}
						// Male light skin blue top gold shoes
						else if (id.substring(16).equals("gold")) {
							if (dir == 0) {return Resources.joebgDown;}			// Down
							else if (dir == 1) {return Resources.joebgUp;}		// Up
							else if (dir == 2) {return Resources.joebgLeft;}	// Left
							else if (dir == 3) {return Resources.joebgRight;}	// Right
						}
						// Male light skin blue top red shoes
						else {
							if (dir == 0) {return Resources.joebrDown;}			// Down
							else if (dir == 1) {return Resources.joebrUp;}		// Up
							else if (dir == 2) {return Resources.joebrLeft;}	// Left
							else if (dir == 3) {return Resources.joebrRight;}	// Right
						}
					}
					// Male light skin pink top
					else if (id.substring(11, 15).equals("pink")) {
						// Male light skin pink top blue shoes
						if (id.substring(16).equals("blue")) {
							if (dir == 0) {return Resources.joepbDown;}			// Down
							else if (dir == 1) {return Resources.joepbUp;}		// Up
							else if (dir == 2) {return Resources.joepbLeft;}	// Left
							else if (dir == 3) {return Resources.joepbRight;}	// Right
						}
						// Male light skin pink top gold shoes
						else if (id.substring(16).equals("gold")) {
							if (dir == 0) {return Resources.joepgDown;}			// Down
							else if (dir == 1) {return Resources.joepgUp;}		// Up
							else if (dir == 2) {return Resources.joepgLeft;}	// Left
							else if (dir == 3) {return Resources.joepgRight;}	// Right
						}
						// Male light skin pink top red shoes
						else {
							if (dir == 0) {return Resources.joeprDown;}			// Down
							else if (dir == 1) {return Resources.joeprUp;}		// Up
							else if (dir == 2) {return Resources.joeprLeft;}	// Left
							else if (dir == 3) {return Resources.joeprRight;}	// Right
						}
					}
					// Male light skin white top
					else {
						// Male light skin white top blue shoes
						if (id.substring(17).equals("blue")) {
							if (dir == 0) {return Resources.joewbDown;}			// Down
							else if (dir == 1) {return Resources.joewbUp;}		// Up
							else if (dir == 2) {return Resources.joewbLeft;}	// Left
							else if (dir == 3) {return Resources.joewbRight;}	// Right
						}
						// Male light skin white top gold shoes
						else if (id.substring(17).equals("gold")) {
							if (dir == 0) {return Resources.joewgDown;}			// Down
							else if (dir == 1) {return Resources.joewgUp;}		// Up
							else if (dir == 2) {return Resources.joewgLeft;}	// Left
							else if (dir == 3) {return Resources.joewgRight;}	// Right
						}
						// Male light skin white top red shoes
						else {
							if (dir == 0) {return Resources.joewrDown;}			// Down
							else if (dir == 1) {return Resources.joewrUp;}		// Up
							else if (dir == 2) {return Resources.joewrLeft;}	// Left
							else if (dir == 3) {return Resources.joewrRight;}	// Right
						}
					}
				}
			}
			// Female
			else if (id.substring(0, 6).equals("female")) {
				// Female dark skin
				if (id.substring(7, 11).equals("dark")) {
					// Female dark skin blue top
					if (id.substring(12, 16).equals("blue")) {
						// Female dark skin blue top blue shoes
						if (id.substring(17).equals("blue")) {
							if (dir == 0) {return Resources.jadabbDown;}		// Down
							else if (dir == 1) {return Resources.jadabbUp;}		// Up
							else if (dir == 2) {return Resources.jadabbLeft;}	// Left
							else if (dir == 3) {return Resources.jadabbRight;}	// Right
						}
						// Female dark skin blue top gold shoes
						else if (id.substring(17).equals("gold")) {
							if (dir == 0) {return Resources.jadabgDown;}		// Down
							else if (dir == 1) {return Resources.jadabgUp;}		// Up
							else if (dir == 2) {return Resources.jadabgLeft;}	// Left
							else if (dir == 3) {return Resources.jadabgRight;}	// Right
						}
						// Female dark skin blue top red shoes
						else {
							if (dir == 0) {return Resources.jadabrDown;}		// Down
							else if (dir == 1) {return Resources.jadabrUp;}		// Up
							else if (dir == 2) {return Resources.jadabrLeft;}	// Left
							else if (dir == 3) {return Resources.jadabrRight;}	// Right
						}
					}
					// Female dark skin pink top
					else if (id.substring(12, 16).equals("pink")) {
						// Female dark skin pink top blue shoes
						if (id.substring(17).equals("blue")) {
							if (dir == 0) {return Resources.jadapbDown;}		// Down
							else if (dir == 1) {return Resources.jadapbUp;}		// Up
							else if (dir == 2) {return Resources.jadapbLeft;}	// Left
							else if (dir == 3) {return Resources.jadapbRight;}	// Right
						}
						// Female dark skin pink top gold shoes
						else if (id.substring(17).equals("gold")) {
							if (dir == 0) {return Resources.jadapgDown;}		// Down
							else if (dir == 1) {return Resources.jadapgUp;}		// Up
							else if (dir == 2) {return Resources.jadapgLeft;}	// Left
							else if (dir == 3) {return Resources.jadapgRight;}	// Right
						}
						// Female dark skin pink top red shoes
						else {
							if (dir == 0) {return Resources.jadaprDown;}		// Down
							else if (dir == 1) {return Resources.jadaprUp;}		// Up
							else if (dir == 2) {return Resources.jadaprLeft;}	// Left
							else if (dir == 3) {return Resources.jadaprRight;}	// Right
						}
					}
					// Female dark skin white top
					else {
						// Female dark skin white top blue shoes
						if (id.substring(18).equals("blue")) {
							if (dir == 0) {return Resources.jadawbDown;}		// Down
							else if (dir == 1) {return Resources.jadawbUp;}		// Up
							else if (dir == 2) {return Resources.jadawbLeft;}	// Left
							else if (dir == 3) {return Resources.jadawbRight;}	// Right
						}
						// Female dark skin white top gold shoes
						else if (id.substring(18).equals("gold")) {
							if (dir == 0) {return Resources.jadawgDown;}		// Down
							else if (dir == 1) {return Resources.jadawgUp;}		// Up
							else if (dir == 2) {return Resources.jadawgLeft;}	// Left
							else if (dir == 3) {return Resources.jadawgRight;}	// Right
						}
						// Female dark skin white top red shoes
						else {
							if (dir == 0) {return Resources.jadawrDown;}		// Down
							else if (dir == 1) {return Resources.jadawrUp;}		// Up
							else if (dir == 2) {return Resources.jadawrLeft;}	// Left
							else if (dir == 3) {return Resources.jadawrRight;}	// Right
						}
					}
				}
				// Female light skin
				else {
					// Female light skin blue top
					if (id.substring(13, 17).equals("blue")) {
						// Female light skin blue top blue shoes
						if (id.substring(18).equals("blue")) {
							if (dir == 0) {return Resources.karenbbDown;}		// Down
							else if (dir == 1) {return Resources.karenbbUp;}	// Up
							else if (dir == 2) {return Resources.karenbbLeft;}	// Left
							else if (dir == 3) {return Resources.karenbbRight;}	// Right
						}
						// Female light skin blue top gold shoes
						else if (id.substring(18).equals("gold")) {
							if (dir == 0) {return Resources.karenbgDown;}		// Down
							else if (dir == 1) {return Resources.karenbgUp;}	// Up
							else if (dir == 2) {return Resources.karenbgLeft;}	// Left
							else if (dir == 3) {return Resources.karenbgRight;}	// Right
						}
						// Female light skin blue top red shoes
						else {
							if (dir == 0) {return Resources.karenbrDown;}		// Down
							else if (dir == 1) {return Resources.karenbrUp;}	// Up
							else if (dir == 2) {return Resources.karenbrLeft;}	// Left
							else if (dir == 3) {return Resources.karenbrRight;}	// Right
						}
					}
					// Female light skin gold top
					else if (id.substring(13, 17).equals("pink")) {
						// Female light skin pink top blue shoes
						if (id.substring(18).equals("blue")) {
							if (dir == 0) {return Resources.karenpbDown;}		// Down
							else if (dir == 1) {return Resources.karenpbUp;}	// Up
							else if (dir == 2) {return Resources.karenpbLeft;}	// Left
							else if (dir == 3) {return Resources.karenpbRight;}	// Right
						}
						// Female light skin pink top gold shoes
						else if (id.substring(18).equals("gold")) {
							if (dir == 0) {return Resources.karenpgDown;}		// Down
							else if (dir == 1) {return Resources.karenpgUp;}	// Up
							else if (dir == 2) {return Resources.karenpgLeft;}	// Left
							else if (dir == 3) {return Resources.karenpgRight;}	// Right
						}
						// Female light skin pink top red shoes
						else {
							if (dir == 0) {return Resources.karenprDown;}		// Down
							else if (dir == 1) {return Resources.karenprUp;}	// Up
							else if (dir == 2) {return Resources.karenprLeft;}	// Left
							else if (dir == 3) {return Resources.karenprRight;}	// Right
						}
					}
					// Female light skin white top
					else {
						// Female light skin white top blue shoes
						if (id.substring(19).equals("blue")) {
							if (dir == 0) {return Resources.karenwbDown;}		// Down
							else if (dir == 1) {return Resources.karenwbUp;}	// Up
							else if (dir == 2) {return Resources.karenwbLeft;}	// Left
							else if (dir == 3) {return Resources.karenwbRight;}	// Right
						}
						// Female light skin white top gold shoes
						else if (id.substring(19).equals("gold")) {
							if (dir == 0) {return Resources.karenwgDown;}		// Down
							else if (dir == 1) {return Resources.karenwgUp;}	// Up
							else if (dir == 2) {return Resources.karenwgLeft;}	// Left
							else if (dir == 3) {return Resources.karenwgRight;}	// Right
						}
						// Female light skin white top red shoes
						else {
							if (dir == 0) {return Resources.karenwrDown;}		// Down
							else if (dir == 1) {return Resources.karenwrUp;}	// Up
							else if (dir == 2) {return Resources.karenwrLeft;}	// Left
							else if (dir == 3) {return Resources.karenwrRight;}	// Right
						}
					}
				}
			}
			// Mob
			else {
				// Zombie
				if (id.substring(0, 6).equals("zombie")) {
					// Blue Zombie
					if (id.substring(7).equals("blue")) {
						if (dir == 0) {return Resources.zombiebDown;}
						else if (dir == 1) {return Resources.zombiebUp;}
						else if (dir == 2) {return Resources.zombiebLeft;}
						else if (dir == 3) {return Resources.zombiebRight;}
					}
					// Green Zombie
					else if (id.substring(7).equals("green")) {
						if (dir == 0) {return Resources.zombiegDown;}
						else if (dir == 1) {return Resources.zombiegUp;}
						else if (dir == 2) {return Resources.zombiegLeft;}
						else if (dir == 3) {return Resources.zombiegRight;}
					}
					// Pink Zombie
					else if (id.substring(7).equals("pink")) {
						if (dir == 0) {return Resources.zombiepDown;}
						else if (dir == 1) {return Resources.zombiepUp;}
						else if (dir == 2) {return Resources.zombiepLeft;}
						else if (dir == 3) {return Resources.zombiepRight;}
					}
					// White Zombie
					else {
						if (dir == 0) {return Resources.zombiewDown;}
						else if (dir == 1) {return Resources.zombiewUp;}
						else if (dir == 2) {return Resources.zombiewLeft;}
						else if (dir == 3) {return Resources.zombiewRight;}
					}
				}
				// Fast Zombie
				else {
					if (dir == 0) {return Resources.fastZombieDown;}
					else if (dir == 1) {return Resources.fastZombieUp;}
					else if (dir == 2) {return Resources.fastZombieLeft;}
					else if (dir == 3) {return Resources.fastZombieRight;}
				}
			}
		}
		return null;
	}
	
	public BufferedImage getFrame() {
		return frames[imageCycle];
	}
	
	public BufferedImage getFrameAt(int index) {
		return frames[index];
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
