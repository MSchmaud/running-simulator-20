package us.mschmaud.runningsim;

import us.mschmaud.runningsim.engine.BeanEngine;

/**
 * 
 * @author Michael Schmauderer
 *
 */

public class Launcher {

	public static void main(String[] args) {
		BeanEngine engine = new BeanEngine("Running Simulator 2020", 800, 600);
		engine.start();
	}

}
