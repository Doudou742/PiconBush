package plateau;

public class Plateau {
	private int largeur;
	private int hauteur;
	private int percentObst; //pourcentages d'obstacles max 50
	private Cellule[][] grille;
	
	public Plateau(int larg, int haut, int obst) {
		this.largeur=larg;
		this.hauteur=haut;
		this.percentObst=(obst<=50) ? obst:50; //condition sur une ligne
		initGrille();
	}

	public void initObstacle() {
		int nb_cases=this.hauteur*this.largeur;
		int nb_obstacles=this.percentObst*nb_cases;
		for(int i=0;i<nb_obstacles;i++) {
			grille[][]=
		}
	}
		
	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getPercentObst() {
		return percentObst;
	}

	public void setPercentObst(int percentObst) {
		this.percentObst = percentObst;
	}
	
	public void initGrille() {
		for(int i=0;i<largeur;i++) {
			for(int j=0;j<hauteur;j++) {
				grille[i][j]=new Case(i,j);
			}
		}
	}
	
	public void addMine(Coord coord) {
		grille[coord.getPositionX()][coord.getPositionY()].mine=true;
	}   
	
	public void addBase(Coord coord) {
		grille[coord.getPositionX()][coord.getPositionY()].base;
	}
	
	public void addTank(Coord coord) {
		grille[coord.getPositionX()][coord.getPositionY()].tank;
	}
	
	public void addTireur(Coord coord) {
		grille[coord.getPositionX()][coord.getPositionY()].tireur;
	}
	
	public void addPiegeur(Coord coord) {
		grille[coord.getPositionX()][coord.getPositionY()].piegeur;
	}

}
	
