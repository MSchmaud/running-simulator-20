package us.mschmaud.runningsim.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class ImageButton extends Feature {

	private ClickListener cl;
	private BufferedImage[] frames;
	
	public ImageButton(float x, float y, int width, int height, ClickListener cl, BufferedImage[] frames) {
		super(x, y, width, height);
		this.cl = cl;
		this.frames = frames;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics g) {
		if (focused) {
			g.drawImage(frames[1], (int)x, (int)y, width, height, null);
		}
		else {
			g.drawImage(frames[0], (int)x, (int)y, width, height, null);
		}
	}

	@Override
	public void onClick() {
		cl.onClick();
	}

}
