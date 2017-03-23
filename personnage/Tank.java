package personnage;

import Plateaux.Plateau;

public class Tank extends Robot {
	private final char TANK;
	private int energie;
	private final int PORTEEDEP = 2;
	private final int PORTEETIR = 10;
	private final int TIR = -1;
	private final int AVANCER = -5;
	private final int DEGAT = -6;

	public Tank(String type,Coord coordonnee, Equipe equipe) {
		super(type, coordonnee,equipe);
		energie = 60;
		if (super.getEquipe().isEquipe()==true) {
			TANK= 'c'; // equipe 1 en minuscule
		} else {
			TANK = 'C'; // equipe 2 en majuscule
		}
	}

	
	public boolean deplacement(Coord coordonnee) {
		if (Plateau.plateau[super.getCoordonnee().getPositionX() + coordonnee.getPositionX()][super.getCoordonnee().getPositionY() + coordonnee.getPositionY()].estLibre()) {
			return false;
		} else if (super.getCoordonnee().getPositionX() + coordonnee.getPositionX() == Plateau.plateau.length|| super.getCoordonnee().getPositionY() + coordonnee.getPositionY() == Plateau.plateau[0].length) {
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
