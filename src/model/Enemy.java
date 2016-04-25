package model;

import support.Settings;
import support.SoundManager;
import support.ThreadControl;
import main.Game;

public class Enemy implements Runnable{
	Game main;
	boolean alive;
	private int dist,lane;
	String direction;
//	Dist start 12, dead at 0
	public Enemy(Game g){
		main=g;
		dist=Settings.getStartDistance();
		alive=true;
		lane = (int)(Math.random() * 3);
		if(lane==0){
			direction = "Left";
		}else if(lane==1){
			direction = "Up";
		}else if(lane==2){
			direction = "Right";
		}
	}
	
//	Each level of difficulty takes away 1/10 of a second
//	Each round takes away 1/100 of a second
	public void run(){
		while(dist>0 && alive){
			ThreadControl.sleep(1000-100*Settings.getDifficulty()-10*main.getRound());
			move();
		}
		if(alive){
			main.gameOver();
		}
	}
	
	public void shot(){
		alive = false;
		ThreadControl.sleep(dist*50);
		main.enemyShot();
	}
	
	private void move(){
		SoundManager.stopPulse();
		moveSound();
		dist--;
		main.propChange();
	}
	
	private void moveSound(){
		int offset = Settings.getStartDistance()-10;
		int vol = ((Settings.getStartDistance()-offset)-(dist-offset));
		SoundManager.pulseLoop(vol,lane);
	}
	
	public int getDist(){
		return dist;
	}
	public String getDirection(){
		return direction;
	}
	public int getLane(){
		return lane;
	}
}
