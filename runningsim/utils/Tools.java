package us.mschmaud.runningsim.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Tools {

	public static BufferedImage loadImage(String loc) {
		try {
			return ImageIO.read(new File(loc));
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public static String fileToString(String loc) {
		StringBuilder sb = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(loc));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static int parseInt(String num) {
		try {
			return Integer.parseInt(num);
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static float getDistance(float x1, float y1, float x2, float y2) {
		return (float)Math.pow(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2), 0.5);
	}
	
}
