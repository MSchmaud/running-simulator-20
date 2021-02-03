package us.mschmaud.runningsim.ui;

import java.awt.Color;
import java.awt.Graphics;

import us.mschmaud.runningsim.displayaudio.Resources;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class TextButton extends Feature {

	private ClickListener cl;
	private String text;
	private float xt, yt;
	private boolean fixSize;
	
	public TextButton(float xb, float yb, int width, int height, float xt, float yt, String text, boolean fixSize, ClickListener cl) {
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
		
		if (focused) {g.setColor(Color.YELLOW);}
		else {g.setColor(Color.BLACK);}
		if (fixSize) {g.setFont(Resources.smTxtBtnFont);}
		else {g.setFont(Resources.txtBtnFont);}
		g.drawString(text, (int)xt, (int)yt);
	}

	@Override
	public void onClick() {
		cl.onClick();
	}
	
	public void setText(String t) {
		text = t;
	}
	
	public String getText() {
		return text;
	}
	
	public void setTextPos(float x, float y) {
		xt = x;
		yt = y;
	}

	
	
}
