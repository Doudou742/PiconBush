package personnage;

public class Tank extends Robot {
	private final char tank;
	private int energie;
	private final int porteeDep = 2;
	private final int porteeTir = 10;
	private final int tir = -1;
	private final int avancer = -5;
	private final int degat = -6;

	public Tank(String type, Plateau p, Coord coordonnee, char[][] plateau, Equipe equipe) {
		super(type, coordonnee, plateau, p,equipe);
		energie = 60;
		if (equipe.getId() == 1) {
			tank = 'c'; // equipe 1 en minuscule
		} else {
			tank = 'C'; // equipe 2 en majuscule
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

	public int getPorteeDep() {
		return porteeDep;
	}

	public int getPorteeTir() {
		return porteeTir;
	}

	public int getTir() {
		return tir;
	}

	public int getAvancer() {
		return avancer;
	}

	public int getDegat() {
		return degat;
	}

}
