package personnage;

public class Robot {
	private String type;
	private Coord coordonnee;
	private char [][] plateau;
	private Plateau p;
	private Equipe equipe;
	
	public Robot(){
		type="";
		coordonnee= new Coord(0,0);
		plateau=new char[10][10];
		p= new Plateau();
	}
	
	public Robot(String type,Coord coordonnee, char [][] plateau,Plateau p,Equipe equipe ){
		this.type=type;
		this.coordonnee=coordonnee;
		this.plateau=plateau;
		this.p=p;
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

	public char[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(char[][] plateau) {
		this.plateau = plateau;
	}

	public Plateau getP() {
		return p;
	}

	public void setP(Plateau p) {
		this.p = p;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}
	
	

}
