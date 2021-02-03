package us.mschmaud.runningsim.displayaudio;

import java.io.File; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip;  

public class Player { 

	private Clip clip;
	
	public void setFile(String loc) {
		try {
			File file = new File(loc);
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(sound);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void play() {
		if (!clip.isActive()) {
			clip.setFramePosition(0);
			clip.start();
		}
	}
	
	public void pause() {
		if (clip.isActive()) {clip.stop();}
	}
	
	public void resume() {
		if (!clip.isActive()) {clip.start();}
	}
	
	public void stop() {
		clip.stop();
		clip.close();
	}
	
	public void setLooping() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public boolean isFinished() {
		return clip.getMicrosecondPosition() == clip.getMicrosecondLength();
	}
	
	public boolean isPlaying() {
		return clip.isActive();
	}
	
}
