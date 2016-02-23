package main;

import java.applet.Applet;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import support.SoundManager;
import model.Enemy;
import model.Player;
import control.KeyController;

public class Game extends Applet {
	private static final long serialVersionUID = -8068845783083215419L;
	Player player;
	Enemy enemy;
	Thread enemyThread;
	SoundManager soundMan;
	int round;
	
	public void init(){
		this.setSize(1000, 1000);
		this.setFocusable(true);
		@SuppressWarnings("unused")
		KeyController control = new KeyController(this);
		player = new Player(this);
		round=0;
		newGame();
	}
	public void newGame(){
		makeEnemy();
	}
	public void gameOver(){
		SoundManager.gameOverSound();
	}
	public void enemyShot(){
		SoundManager.enemyShot();
		makeEnemy();
	}
	public void makeEnemy(){
		enemy = new Enemy(this);
		enemyThread = new Thread(enemy);
		enemyThread.start();
	}
	public void paint(Graphics g){  
		super.paint(g);
//		Graphics2D g2 = (Graphics2D) g;
	}
	
//	Returns true if lane is occupied
	public boolean checkLane(int lane){
		if(enemy.getLane()==lane){
			return true;
		}else{
			return false;
		}
	}
	
	public int getRound(){
		return round;
	}
	public Player getPlayer(){
		return player;
	}
	public Enemy getEnemy(){
		return enemy;
	}
	public SoundManager sound(){
		return soundMan;
	}
}
