package us.mschmaud.runningsim.displayaudio;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

import us.mschmaud.runningsim.utils.Tools;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Display {

	private JFrame frame;
	private Canvas canvas;
	private String name;
	private int width, height;
	private BufferedImage img;
	
	public Display(String name, int w, int h) {
		this.name = name;
		this.width = w;
		this.height = h;
		createDisplay();
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	private void createDisplay() {
		frame = new JFrame(this.name);
		frame.setSize(this.width, this.height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLocationRelativeTo(null);	// Centers window
		this.img = Tools.loadImage("assets/jamir.png");
		frame.setIconImage(this.img);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setFocusable(false);
		canvas.setPreferredSize(new Dimension(this.width, this.height));
		canvas.setMaximumSize(new Dimension(this.width, this.height));
		canvas.setMinimumSize(new Dimension(this.width, this.height));
		
		frame.add(canvas);
		frame.pack();
	}
	
}