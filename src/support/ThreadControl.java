package support;

import java.util.concurrent.TimeUnit;

public class ThreadControl {
	
//	if time = 1000-diff*100
//	Every unit of diff takes off 1/10 of a second
	public static void sleep(int time){
		try{
			TimeUnit.MILLISECONDS.sleep(time);
		}catch(InterruptedException e5){System.out.println("Interrupted");}
	}
	
}
