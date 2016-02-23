package model;
import support.SoundManager;
import main.Game;

public class Player {
	Game main;
	public Player(Game g){
		main = g;
	}
	
	
//	0 = Left
//	1 = Up
//	2 = Right
	public void shoot(int lane){
		SoundManager.shootSound();
		if(main.checkLane(lane)){
			main.getEnemy().shot();
		}else{
			SoundManager.missedShot();
		}
	}
}
