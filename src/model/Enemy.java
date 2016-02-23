package model;

import support.Settings;
import support.SoundManager;
import support.ThreadControl;
import main.Game;

public class Enemy implements Runnable{
	Game main;
	boolean alive;
	private int dist,lane;
//	Dist start 12, dead at 0
	public Enemy(Game g){
		main=g;
		dist=Settings.getStartDistance();
		alive=true;
		lane = (int)(Math.random() * 3);
		System.out.println(lane);
	}
	
//	Each level of difficulty takes away 1/10 of a second
//	Each round takes away 1/100 of a second
	public void run(){
		while(dist>0 && alive){
			SoundManager.position(dist);
			ThreadControl.sleep(1000-100*Settings.getDifficulty()-10*main.getRound());
			move();
		}
		if(alive){
			main.gameOver();
		}
	}
	
	public void shot(){
		alive = false;
		main.enemyShot();
	}
	
	private void move(){
		dist--;
	}
	
	public int getDist(){
		return dist;
	}
	public int getLane(){
		return lane;
	}
}
