package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.Game;

public class KeyController implements KeyListener{
	Game main;
	public KeyController(Game g){
		main=g;
		main.addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(KeyEvent.VK_SPACE==key){
			main.newGame();
		}
		else if(KeyEvent.VK_LEFT==key){
			main.getPlayer().shoot(0);
		}
		else if(KeyEvent.VK_UP==key){
			main.getPlayer().shoot(1);
		}
		else if(KeyEvent.VK_RIGHT==key){
			main.getPlayer().shoot(2);
		}
		else if(KeyEvent.VK_ESCAPE==key){
			System.exit(0);
		}
//		For testing
//		else if(KeyEvent.VK_T==key){
//			SoundManager.stopPulse();
//		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e){}
}
