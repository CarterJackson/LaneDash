package support;

public class Settings {
	static int difficulty;
	
//	Before changing, must tweak algorithm for sound
	static int startDistance = 15;
	
	static String soundSet = "8bit";
	
	public static String soundURL(String s){
		if(s.equals("start")){
			if(soundSet.equals("8bit")){
				return null;
			}
		}else if(s.equals("shoot")){
			if(soundSet.equals("8bit")){
				return "audio/LaserShoot.wav";
			}
		}else if(s.equals("enemyDeath")){
			if(soundSet.equals("8bit")){
				return "audio/EnemyDeath.wav";
			}
		}else if(s.equals("playerDeath")){
			if(soundSet.equals("8bit")){
				return "audio/PlayerDeath.wav";
			}
		}else if(s.equals("loopUp")){
			if(soundSet.equals("8bit")){
				return "audio/HoveringLoopUp.wav";
			}
		}else if(s.equals("loopLeft")){
			if(soundSet.equals("8bit")){
				return "audio/HoveringLoopLeft.wav";
			}
		}else if(s.equals("loopRight")){
			if(soundSet.equals("8bit")){
				return "audio/HoveringLoopRight.wav";
			}
		}
		return null;
	}
	
	public static int getDifficulty(){
		return difficulty;
	}
	public static void setDifficulty(int d){
		difficulty = d;
	}
	public static int getStartDistance(){
		return startDistance;
	}
	public static void setStartDistance(int d){
		startDistance = d;
	}
}
