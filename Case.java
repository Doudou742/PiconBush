package personnage;
import elements.*;
import Plateaux.*;

public class Case {

	private Coord coordonnee;
	private Robot unRobot;
	private Mine uneMine;
	private Obstacle unObstacle;
	private Base base;
	
	
	public Case(int x, int y){
		coordonnee = new Coord(x,y);
		unRobot = null;
		uneMine = null;
		unObstacle = null;
		base = null;
		
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
			return true;
		}
		return false;
	}
	
	public boolean viderCase(){
		
		if(! this.estLibre()){
		
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
	
	public boolean estLibre(){
		// Si c'est ni un robot, ni une mine , ni un obstacle;
		return unRobot.equals(null) && uneMine.equals(null) && unObstacle.equals(null);
	}
	public Coord getCoordonnee(){
		return coordonnee;
	}
	public boolean estRobot(){
		
		return uneMine.equals(null) && unObstacle.equals(null) && ! this.estLibre();
	
	 }
	
	public boolean estMine(){
		return unRobot.equals(null) && unObstacle.equals(null) && ! this.estLibre();
	}
	
	public boolean estObstacle(){
		return unRobot.equals(null) && uneMine.equals(null) && ! this.estLibre();
	}
	
	public String toString(){
		return "";
		
	}
	
	public Object contient(){
		if(this.estRobot()){
			return this.getRobot();
		}
		if(this.estMine()){
			return this.getMine();
		}
		if(this.estObstacle()){
			return this.getObstacle();
		}
		return null;
	}
	
	
	
	public Robot getRobot(){
		return this.unRobot;
	}
	
	public Obstacle getObstacle(){
		return this.unObstacle;
	}
	
	public Mine getMine(){
		return this.uneMine;
	}
}