package personnages;

import plateau.Plateau;

public class Vue {

	private int equipe;
	//private Plateau plateau;
	
	public Vue(int equipe, Plateau plateau){
		this.equipe=equipe;
		//this.plateau=plateau;
	}

	public int getEquipe() {
		return equipe;
	}

	/*public Plateau getPlateau() {
		return plateau;
	}*/
	
	public void poserRobot(Robot robot, Coord coordonnee){
		Plateau.grille[coordonnee.getPositionX()][coordonnee.getPositionY()].deplaceSur(robot);;
	}
	
	public void viderCase(Robot robot){ 
		Plateau.grille[robot.getCoordonnee().getPositionX()][robot.getCoordonnee().getPositionY()].videCase();
	}
	
	//jvois pas � quoi �a sert  
	public void ajoute(Coord coordonnee,int equipe){ 
		
	}
	
	
	public void subitTir(Coord coordonnee){
		Plateau.grille[coordonnee.getPositionX()][coordonnee.getPositionY()].getUnRobot().subitDegat();
		
	}
	
	//case vide ? 
	public boolean estDisponible(Coord coordonnee){
		return Plateau.grille[coordonnee.getPositionX()][coordonnee.getPositionY()].estLibre();
	}
	
	//jvois pas � quoi �a sert
	public int getContenu(Coord coordonnee){
		return -1;
	}
	
	//si le int de estBase() correspond � son �quipe il est � la base 
	public boolean estBase(Robot robot){
		return Plateau.grille[robot.getCoordonnee().getPositionX()][robot.getCoordonnee().getPositionY()].estBase()==robot.getEquipe();
	}
	
	//savoir si il est vivant ?
	public boolean estOK(Robot robot){
		return robot.getEnergie()!=0;
		//vivant si sn energie est differente de 0 
	}
}