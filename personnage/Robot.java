package personnage;

public class Robot {
	private String type;
	private Coord coordonnee;
	private Equipe equipe;
	
	public Robot(){
		type="";
		coordonnee= new Coord(0,0);
	}
	
	public Robot(String type,Coord coordonnee,Equipe equipe ){
		this.type=type;
		this.coordonnee=coordonnee;
		this.equipe=equipe;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Coord getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Coord coordonnee) {
		this.coordonnee = coordonnee;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	

}
