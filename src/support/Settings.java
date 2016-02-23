package support;

public class Settings {
	static int difficulty;
	static int startDistance = 12;
	
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
