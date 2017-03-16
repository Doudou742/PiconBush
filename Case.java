
public class Case {

	private Coord coordonnee;
	private Robot unRobot;
	private Mine uneMine;
	private Obstacle unObstacle;
	
	
	public Case(int x, int y){
		coordonnee = new Coord(coordonnee.setPositionX(x),coordonnee.setPositionY(y));
		unRobot = null;
		uneMine = null;
		unObstacle = null;
		
	}
	
	public boolean addRobot(Robot unRobot){
		
		if(this.estLibre()){
			
			this.unRobot = unRobot;
			
			return true;
			
		}
	
		return false;
			
	}
	
	public boolean addMine(Mine uneMine){
		
		if(this.estLibre()){
			
			this.uneMine = uneMine;
			
			return true;
		}
		
		return false;
		
	}
	
	public boolean addObstacle(Obstacle unObstacle){
		
		if(this.estLibre()){
			
			this.unObstacle = unObstacle;
		}
	}
	
	public boolean viderCase(){
		
		if(! this.estLibre){
		
		this.uneMine = null;
		this.unRobot = null;
		this.unObstacle = null;
		return true;
		}
		
		return false;
		
	}
	
	public Coord getCoord(){
		
		return this.coordonnee;
	}
	
	
	
	
	
	
	
	
}
