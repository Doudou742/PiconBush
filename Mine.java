package elements;

public class Mine {
	private	int degats;
	private Coord coordonnee;
	
	
	public Mine(Coord coordonnee, Robot robot){
		this.coordonnee=coordonnee;
		if(robot.getType = 't' || robot.getType ='T'){
			this.degats = -3;
		}else if(robot.getType = 'p' || robot.getType = 'P'){
			this.degats = -2;
		}else if(robot.getType = 'c' || robot.getType = 'C'){
			this.degats = -6;
		}
	}
	
	public Coord getCoordonnee(){
		return coordonnee;
	}
	
	public int getDegats(){
		return degats;
	}
	
}
