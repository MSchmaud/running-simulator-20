package us.mschmaud.runningsim.ui;

import java.awt.Color;
import java.awt.Graphics;

import us.mschmaud.runningsim.displayaudio.Resources;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class TextToggleButton extends Feature {

	private String text;
	private ClickListener cl;
	private boolean toggled, fixSize;
	private float xt, yt;
	
	public TextToggleButton(float xb, float yb, int width, int height, float xt, float yt, String text, boolean fixSize, ClickListener cl) {
		super(xb, yb, width, height);
		this.xt = xt;
		this.yt = yt;
		this.text = text;
		this.fixSize = fixSize;
		this.cl = cl;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Resources.txtBtn, (int)x, (int)y, width, height, null);
		
		if (!toggled) {
			if (focused) {g.setColor(Color.YELLOW);}
			else {g.setColor(Color.BLACK);}
		}
		else {g.setColor(Color.YELLOW);}
		if (fixSize) {g.setFont(Resources.smTxtBtnFont);}
		else {g.setFont(Resources.txtBtnFont);}
		g.drawString(text, (int)xt, (int)yt);
	}

	@Override
	public void onClick() {
		cl.onClick();
		if (toggled) {toggled = false;}
		else {toggled = true;}
	}
	
	public void setToggled(boolean b) {
		toggled = b;
	}
	
	public boolean getToggled() {
		return toggled;
	}
	
	public void setText(String t) {
		text = t;
	}
	
}
