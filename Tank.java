package personnage;

public class Tank extends Robot {
	private final char TANK;
	private int energie;
	private final int PORTEEDEP = 2;
	private final int PORTEETIR = 10;
	private final int TIR = -1;
	private final int AVANCER = -5;
	private final int DEGAT = -6;

	public Tank(String type, Plateau p, Coord coordonnee, char[][] plateau, Equipe equipe) {
		super(type, coordonnee, plateau, p,equipe);
		energie = 60;
		if (super.getEquipe().isEquipe()==true) {
			TANK= 'c'; // equipe 1 en minuscule
		} else {
			TANK = 'C'; // equipe 2 en majuscule
		}
	}

	/*boolean deplacement(Coord coordonnee) {
		if (super.getPlateau()[coordonnee.getPositionX()][coordonnee.getPositionY()] == ' ') {
			return false;
		}
		if (coordonnee.getPositionX() == this.coordonnee.getPositionX() + 2
				&& coordonnee.getPositionY() == this.coordonnee.getPositionY()) {
			// deplacement vers la droite
			this.coordonnee = coordonnee;
			return true;
		} else if (coordonnee.getPositionY() == this.coordonnee.getPositionY() + 2
				&& coordonnee.getPositionX() == this.coordonnee.getPositionX()) {
			// deplacement vers le bas
			this.coordonnee = coordonnee;
			return true;
		} else if (coordonnee.getPositionX() == this.coordonnee.getPositionX() - 2
				&& coordonnee.getPositionY() == this.coordonnee.getPositionY()) {
			// deplacement vers la gauche
			this.coordonnee = coordonnee;
			return true;
		} else if (coordonnee.getPositionY() == this.coordonnee.getPositionY() - 2
				&& coordonnee.getPositionX() == this.coordonnee.getPositionX()) {
			// deplacement vers le haut
			this.coordonnee = coordonnee;
			return true;
		}
		return false;
	}*/
	
	public boolean deplacement(Coord coordonnee) {
		if (super.getPlateau()[super.getCoordonnee().getPositionX() + coordonnee.getPositionX()][super.getCoordonnee().getPositionY() + coordonnee.getPositionY()] != ' ') {
			return false;
		} else if (super.getCoordonnee().getPositionX() + coordonnee.getPositionX() == 10|| super.getCoordonnee().getPositionY() + coordonnee.getPositionY() == 10) {
			return false;
		} else {
			super.getCoordonnee().ajouterCoord(coordonnee);
			energie-=AVANCER;
			return true;
		}
	}

	
	public Coord getCoordonnee(){
		return super.getCoordonnee();
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}

	public char getTANK() {
		return TANK;
	}

	public int getPORTEEDEP() {
		return PORTEEDEP;
	}

	public int getPORTEETIR() {
		return PORTEETIR;
	}

	public int getTIR() {
		return TIR;
	}

	public int getAVANCER() {
		return AVANCER;
	}

	public int getDEGAT() {
		return DEGAT;
	}

	

}
