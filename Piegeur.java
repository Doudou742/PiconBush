package personnage;

public class Piegeur extends Robot {
	private final char piegeur;
	private int energie;
	private final int porteeDep = 1;
	private final int porteeTir = 1;
	private final int miner = -2;
	private final int avancer = -2;
	private final int degat = -2;

	public Piegeur(int equip, Plateau p, String type, Coord coordonnee, char[][] plateau) {
		super(type, coordonnee, plateau, p);
		energie = 50;
		if (equip == 1) {
			piegeur = 'p';
		} else {
			piegeur = 'P';
		}
	}

	public boolean deplacement(Coord coordonnee) {
		if (super.getPlateau()[super.getCoordonnee().getPositionX() + coordonnee.getPositionX()][super.getCoordonnee()
				.getPositionY() + coordonnee.getPositionY()] == ' ') {
			return false;
		} else if (super.getCoordonnee().getPositionX() + coordonnee.getPositionX() == 10
				|| super.getCoordonnee().getPositionY() + coordonnee.getPositionY() == 10) {
			return false;
		} else {
			super.getCoordonnee().ajouterCoord(coordonnee);
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

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}

	public char getPiegeur() {
		return piegeur;
	}

	public int getPorteeDep() {
		return porteeDep;
	}

	public int getPorteeTir() {
		return porteeTir;
	}

	public int getMiner() {
		return miner;
	}

	public int getAvancer() {
		return avancer;
	}

	public int getDegat() {
		return degat;
	}

}
