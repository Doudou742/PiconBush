package personnage;
import Plateaux.Plateau;
public class Piegeur extends Robot {
	private final char PIEGEUR;
	private int energie;
	private final int PORTEEDEP = 1;
	private final int PORTEETIR = 1;
	private final int MINER = -2;
	private final int AVANCER = -2;
	private final int DEGAT = -2;
	private int nbMine;

	public Piegeur(String type, Coord coordonnee,Equipe equipe) {
		super(type, coordonnee,equipe);
		energie = 50;
		if (super.getEquipe().isEquipe()== true) {
			PIEGEUR = 'p';
		} else {
			PIEGEUR = 'P';
		}
		nbMine=10;
	}

	public boolean deplacement(Coord coordonnee) {
		if (Plateau.plateau[super.getCoordonnee().getPositionX() + coordonnee.getPositionX()][super.getCoordonnee()
				.getPositionY() + coordonnee.getPositionY()].estLibre()) {
			return false;
		} else if (super.getCoordonnee().getPositionX() + coordonnee.getPositionX() == Plateau.plateau.length|| super.getCoordonnee().getPositionY() + coordonnee.getPositionY() == Plateau.plateau[0].length) {
			return false;
		} else {
			super.getCoordonnee().ajouterCoord(coordonnee);
			energie-=AVANCER;
			return true;
		}
	}

	/*
	 * boolean peutDeplacer(Coord coordonnee){
	 * if(super.getPlateau()[coordonnee.getPositionX()][coordonnee.getPositionY(
	 * )]==' '){ return false; }
	 * if(coordonnee.getPositionX()==super.getCoordonnee().getPositionX()+1 &&
	 * coordonnee.getPositionY()==super.getCoordonnee().getPositionY()){
	 * //deplacement de 1 vers la droite super.setCoordonnee(coordonnee); return
	 * true; } else if
	 * (coordonnee.getPositionY()==super.getCoordonnee().getPositionY()+1 &&
	 * coordonnee.getPositionX()==super.getCoordonnee().getPositionX()){ //
	 * deplacement de 1 vers le bas super.setCoordonnee(coordonnee); return
	 * true; }else
	 * if(coordonnee.getPositionX()==super.getCoordonnee().getPositionX()-1 &&
	 * coordonnee.getPositionY()==super.getCoordonnee().getPositionY()){
	 * //deplacement de 1 vers la gauche super.setCoordonnee(coordonnee); return
	 * true; }else
	 * if(coordonnee.getPositionX()==super.getCoordonnee().getPositionX() &&
	 * coordonnee.getPositionY()==super.getCoordonnee().getPositionY()-1){
	 * //deplacement de 1 vers le haut super.setCoordonnee(coordonnee); return
	 * true; } else
	 * if(coordonnee.getPositionX()==super.getCoordonnee().getPositionX()+1 &&
	 * coordonnee.getPositionY()==super.getCoordonnee().getPositionY()+1){
	 * //deplacement en diagonal de 1 vers le bas
	 * super.setCoordonnee(coordonnee); return true; } else if
	 * (coordonnee.getPositionX()==super.getCoordonnee().getPositionX()-1 &&
	 * coordonnee.getPositionY()==super.getCoordonnee().getPositionY()-1){
	 * //Deplacement en diagnoal de 1 vers le haut
	 * super.setCoordonnee(coordonnee); return true; } return false; }
	 */
	
	public boolean poserMine(Coord coordonnee) {
		Coord tmp = new Coord(super.getCoordonnee().getPositionX(), super.getCoordonnee().getPositionY());
		tmp.ajouterCoord(coordonnee);
		if (tmp.getPositionX() > Plateau.plateau.length || tmp.getPositionY() > Plateau.plateau[0].length) {
			return false;
		}
		if (Plateau.plateau[tmp.getPositionX()][tmp.getPositionY()].estLibre()) {
			Plateau.plateau[tmp.getPositionX()][tmp.getPositionY()].addMine(new Mine(tmp,this));
			return true;
		}
		return false;
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

	public int getNbMine() {
		return nbMine;
	}

	public void setNbMine(int nbMine) {
		this.nbMine = nbMine;
	}

	public char getPIEGEUR() {
		return PIEGEUR;
	}

	public int getPORTEEDEP() {
		return PORTEEDEP;
	}

	public int getPORTEETIR() {
		return PORTEETIR;
	}

	public int getMINER() {
		return MINER;
	}

	public int getAVANCER() {
		return AVANCER;
	}

	public int getDEGAT() {
		return DEGAT;
	}



}
