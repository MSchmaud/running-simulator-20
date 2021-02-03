package us.mschmaud.runningsim.states;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import javax.swing.JTextField;
import us.mschmaud.runningsim.displayaudio.Resources;
import us.mschmaud.runningsim.engine.Handler;
import us.mschmaud.runningsim.entities.Runner;
import us.mschmaud.runningsim.ui.ClickListener;
import us.mschmaud.runningsim.ui.ImageButton;
import us.mschmaud.runningsim.ui.TextButton;
import us.mschmaud.runningsim.ui.TextToggleButton;
import us.mschmaud.runningsim.ui.UIController;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class SelectionState extends State {
	
	private UIController uiController;
	private TextToggleButton home, custom;
	private Runner selectedRunner;
	private String[] genders, skinColors, tops, shoes;
	private String id, selectedGender, selectedSkinColor, selectedTop, selectedShoes;
	private int genderIndex, skinColorIndex, topIndex, shoesIndex = 0;
	private boolean mapSelected, yell = false;

	public SelectionState(Handler handler) {
		super(handler);
		
		//genders = new String[]{"male", "female"};
		genders = new String[]{"male", "female"};
		skinColors = new String[]{"dark", "light"};
		tops = new String[]{"blue", "pink", "white"};
		shoes = new String[]{"gold", "red", "blue"};
		
		selectedGender = genders[0];
		selectedSkinColor = skinColors[0];
		selectedTop = tops[0];
		selectedShoes = shoes[0];
		
		 JTextField field = new JTextField(10);
		 handler.getDisplay().getFrame().add(field);
		 field.setLocation(400, 400);
		 field.setVisible(true);
		
		id = selectedGender + "_" + selectedSkinColor + "_" + selectedTop + "_" + selectedShoes;
		selectedRunner = new Runner(handler, handler.getWidth()/2-100, handler.getHeight()/2-100, id);
		selectedRunner.setSize(200);
		
		uiController = new UIController(handler);
		
		home = new TextToggleButton(152, 90, 192, 64, 182, 135, "Home", false, new ClickListener() {	// Home map

			@Override
			public void onClick() {
				handler.getGameState().setLevel("assets/levels/home.txt");
				if (mapSelected && !custom.getToggled()) {mapSelected = false;}
				else {mapSelected = true;}
				custom.setToggled(false);
			}
		});
		uiController.add(home);
		
		custom = new TextToggleButton(450, 90, 192, 64, 462, 135, "Custom", false, new ClickListener() {	// Custom map

			@Override
			public void onClick() {
				handler.getGameState().setLevel("C:/maps/custom.txt");
				if (mapSelected && !home.getToggled()) {
					mapSelected = false;
				}
				else if (handler.getCanPlayCustom()) {mapSelected = true;}
				home.setToggled(false);
				handler.getGameState().setLevel("C:/maps/custom.txt");
				
			}
		});
		
		// Only add the option if it is possible (if the file exists)
		File file = new File("C:/maps/custom.txt");
		if (file.exists()) {
			uiController.add(custom);
			handler.setCanPlayCustom(true);
		}
		
		uiController.add(new TextButton(600, 220, 192, 64, 618, 265, "Gender", false, new ClickListener() {	// Gender
			
			@Override
			public void onClick() {
				genderIndex++;
				if (genderIndex > genders.length-1) {genderIndex = 0;}
			}
		}));
		
		uiController.add(new TextButton(600, 290, 192, 64, 650, 335, "Skin", false, new ClickListener() {	// Skin Color
			
			@Override
			public void onClick() {
				skinColorIndex++;
				if (skinColorIndex > skinColors.length-1) {skinColorIndex = 0;}
			}
		}));
		
		uiController.add(new TextButton(600, 360, 192, 64, 640, 405, "Shirt", false, new ClickListener() {	// Top
			
			@Override
			public void onClick() {
				topIndex++;
				if (topIndex > tops.length-1) {topIndex = 0;}
			}
		}));
		
		uiController.add(new TextButton(600, 430, 192, 64, 630, 475, "Shoes", false, new ClickListener() {	// Shoes
			
			@Override
			public void onClick() {
				shoesIndex++;
				if (shoesIndex > shoes.length-1) {shoesIndex = 0;}
			}
		}));
		
		uiController.add(new ImageButton(300, 500, 192, 64, new ClickListener() {	// Play
			
			@Override
			public void onClick() {
				if (mapSelected) {
					handler.getMouseManager().setUIController(null);
					handler.getGameState().setRunner(id);
					State.setState(handler.getGameState());
					handler.getMainMenuState().getPlayer().pause();
				}
				else {
					yell = true;
				}
			}
		}, Resources.play));
		
	}

	@Override
	public void tick() {
		if (State.getTimer() > State.BUFFER_TIME) {
			if (handler.getKeyManager().esc) {
				handler.getMouseManager().setUIController(null);
				State.setState(State.getLastState());
			}
		}
		uiController.tick();
		selectedGender = genders[genderIndex];
		selectedSkinColor = skinColors[skinColorIndex];
		selectedTop = tops[topIndex];
		selectedShoes = shoes[shoesIndex];
		id = selectedGender + "_" + selectedSkinColor + "_" + selectedTop + "_" + selectedShoes;
		selectedRunner.updateID(id);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Resources.backgr, 0, 0, handler.getWidth(), handler.getHeight(), null);
		drawLabels(g);
		uiController.render(g);
		selectedRunner.render(g);
		if (yell) {
			g.setFont(Resources.alertFont);
			g.setColor(Color.RED);
			g.drawString("You must select a map first!", 250, 480);
		}
		if (!handler.getCanPlayCustom()) {
			g.setFont(Resources.alertFont);
			g.setColor(Color.RED);
			g.drawString("Location MUST match: \"C:\\maps\\custom.txt\"!", handler.getWidth()/2-260, 77);
		}
	}

	@Override
	public void preload() {
		handler.getMouseManager().setUIController(uiController);
		home.setToggled(false);
		custom.setToggled(false);
		mapSelected = false;
		yell = false;
		
		genderIndex = 0;
		skinColorIndex = 0;
		topIndex = 0;
		shoesIndex = 0;
		
		handler.getCamera().reset();
	}
	
	private void drawLabels(Graphics g) {
		g.setFont(Resources.infoFont);
		g.setColor(Color.GRAY);
		g.drawString("Maps", 355, 50);
		g.drawString("Customize", 605, 205);
		g.setFont(Resources.txtBtnFont);
		g.setColor(Color.BLACK);
		g.drawString("Custom", 462, 135);
	}
	
}
