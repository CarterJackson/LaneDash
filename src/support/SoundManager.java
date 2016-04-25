package support;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class SoundManager {
	public static Clip pulseClip,clip;
	public static AudioInputStream audioInputStreamPulse,audioInputStream;
	public static void pulseLoop(int volume,int direction){
		try{
			URL url = null;
			if(direction==0){
				url = SoundManager.class.getResource(Settings.soundURL("loopLeft"));
			}else if(direction==1){
				url = SoundManager.class.getResource(Settings.soundURL("loopUp"));
			}else if(direction==2){
				url = SoundManager.class.getResource(Settings.soundURL("loopRight"));
			}
			audioInputStreamPulse = AudioSystem.getAudioInputStream(url);
			pulseClip = AudioSystem.getClip();
			pulseClip.open(audioInputStreamPulse);
			FloatControl gainControl = 
					(FloatControl) pulseClip.getControl(FloatControl.Type.MASTER_GAIN);
			float vol = -60.0f + 5.0f*volume;
			gainControl.setValue(vol);
			pulseClip.start();
		} catch (Exception e){System.out.println(e.toString());}
	}
	public static void shootSound(){
		sound(Settings.soundURL("shoot"));
	}
	public static void gameOverSound(){
		sound(Settings.soundURL("playerDeath"));
	}
	public static void enemyShot(){
		sound(Settings.soundURL("enemyDeath"));
	}

	private static void sound(String URL){
		stopSound();
		try{
			URL url = SoundManager.class.getResource(URL);
			System.out.println(url);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception e){System.out.println(e.toString());}
	}
	
	public static void stopPulse(){
		if(pulseClip!=null){
			pulseClip.stop();
		}
	}
	public static void stopSound(){
		if(clip!=null){
			clip.stop();
		}
	}

}
