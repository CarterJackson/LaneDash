package main;

import java.applet.Applet;
import java.awt.Font;
import java.awt.Frame;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import support.SoundManager;
import model.Enemy;
import model.Player;
import control.KeyController;

public class Game 
//extends Applet 
extends Frame
{
	private static final long serialVersionUID = -8068845783083215419L;
	Player player;
	Enemy enemy;
	Thread enemyThread;
	SoundManager soundMan;
	int round;
//	UI components
	LayoutManager layout;
	Font bodyFont = new Font(null,0,60);
	Font titleFont = new Font(null,0,80);
	JLabel roundLabel,distanceLabel,directionLabel,statusLabel;
	
//	public void init(){
	public Game(){
		@SuppressWarnings("unused")
		KeyController control = new KeyController(this);
		player = new Player(this);
		round=0;
		
//		UI creation
		this.setSize(1000, 1000);
		this.setFocusable(true);
		JPanel pan = new JPanel();
		layout = new BoxLayout(pan,BoxLayout.Y_AXIS);
		pan.setLayout(layout);
		pan.setOpaque(false);
		this.add(pan);
		
		JLabel title = new JLabel();
		title.setFont(titleFont);
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setText("LaneDash");
		pan.add(title);
		
		statusLabel = new JLabel();
		statusLabel.setFont(bodyFont);
		statusLabel.setAlignmentX(CENTER_ALIGNMENT);
		pan.add(statusLabel);
		
		roundLabel = new JLabel();
		roundLabel.setFont(bodyFont);
		roundLabel.setAlignmentX(CENTER_ALIGNMENT);
		pan.add(roundLabel);
		
		directionLabel = new JLabel();
		directionLabel.setFont(bodyFont);
		directionLabel.setAlignmentX(CENTER_ALIGNMENT);
		pan.add(directionLabel);
		
		distanceLabel = new JLabel();
		distanceLabel.setFont(bodyFont);
		distanceLabel.setAlignmentX(CENTER_ALIGNMENT);
		pan.add(distanceLabel);
		
		round=0;
		roundLabel.setText("Round: "+String.valueOf(round));
		statusLabel.setText("PRESS SPACE TO START");
	}
	public void newGame(){
		statusLabel.setText(null);
		round=1;
		makeEnemy();
	}
	public void gameOver(){
		enemy.setAlive(false);
		statusLabel.setText("- GAME OVER -");
		SoundManager.stopPulse();
		SoundManager.gameOverSound();
	}
	public void enemyShot(){
		SoundManager.stopPulse();
		SoundManager.enemyShot();
		round++;
		propChange();
		makeEnemy();
	}
	public void makeEnemy(){
		enemy = new Enemy(this);
		enemyThread = new Thread(enemy);
		enemyThread.start();
		propChange();
	}
	
//	Returns true if lane is occupied
	public boolean checkLane(int lane){
		if(round==0){
			return false;
		}
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
	public void propChange(){
		directionLabel.setText("Direction: "+enemy.getDirection());
		distanceLabel.setText("Distance: "+String.valueOf(enemy.getDist()));
		roundLabel.setText("Round: "+String.valueOf(round));
	}
	
}
