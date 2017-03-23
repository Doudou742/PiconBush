package personnage;

public class Mine {
	private	int degats;
	private Coord coordonnee;
	
	
	public Mine(Coord coordonnee, Robot robot){
		this.coordonnee=coordonnee;
		if(robot.getType().equals('t') || robot.getType().equals('T')){
			this.degats = -3;
		}else if(robot.getType().equals('p') || robot.getType().equals('P')){
			this.degats = -2;
		}else if(robot.getType().equals('c') || robot.getType().equals('C')){
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
