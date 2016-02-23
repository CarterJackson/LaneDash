package support;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundManager {
	public static Clip clip;
	public static AudioInputStream audioInputStream;
	public static void pulseLoop(int volume){
		try{
			URL url = new URL("file:///Users/carterf/Desktop/LaneDash_Resources/PulseLoop.wav");
			audioInputStream = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			FloatControl gainControl = 
				    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(-4.0f*(volume));
			clip.start();
		} catch (Exception e){System.out.println(e.toString());}
	}
	public static void shootSound(){
		System.out.println("SHOOT");
	}
	public static void gameOverSound(){
		System.out.println("GAME OVER");
	}
	public static void enemyShot(){
		System.out.println("ENEMY SHOT");
	}
	public static void missedShot(){
		System.out.println("MISSED SHOT");
	}
//	Delete later
	public static void position(int n){
		System.out.println(n);
	}
}
