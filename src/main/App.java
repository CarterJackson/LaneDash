package main;

import java.awt.FlowLayout;

public class App {
//	Just to make runnable jar file work. Delete when set up to deploy applet directly
	public static void main(String[] args){
		Game f = new Game();
		f.setSize(1000,1000);
		f.setVisible(true);
		f.setLayout(new FlowLayout());
	}
}
