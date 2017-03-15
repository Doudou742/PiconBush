package Plateaux;

import java.util.ArrayList;
import java.util.Random;

public class Plateau {
	private int taille = 20; 
	private char[][] plateau;
	private Equipe equipe1;
	private Equipe equipe2;
	private ArrayList<Obstacle> listeObstacle;
	
	public Plateau(){
		this.plateau = new char[taille][taille];
		equipe1.getListeRobot = new ArrayList<>();
		equipe1.getListeMine = new ArrayList<>();
		equipe2.getListeRobot = new ArrayList<>();
		equipe2.getListeMine = new ArrayList<>();
		plateau[0][0] = 'e';
		plateau[20][20] = 'E';
	}
	
	public Plateau(int nbLigne, int nbColonne) {
		this.plateau = new char[nbLigne][nbColonne];
		equipe1.getListeRobot = new ArrayList<>();
		equipe1.getListeMine = new ArrayList<>();
		equipe2.getListeRobot = new ArrayList<>();
		equipe2.getListeMine = new ArrayList<>();
		plateau[0][0] = 'e';
		plateau[nbLigne][nbColonne] = 'E';
		placeObstacle();
	}
	
	public placeObstacle() {
		for (int ligne = 0; ligne < plateau.length; ligne++) {
			for (int colonne = 0; colonne < plateau[0].length; colonne++) {
				Random random = new Random();
				if (random.nextDouble() < 0.2) {
					Obstacle obstacle = new Obstacle(ligne,colonne);
					plateau[ligne][colonne] = obstacle.getPion();
				}
			}
		}
	}

	public char[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(char[][] plateau) {
		this.plateau = plateau;
	}

	public int getTaille() {
		return taille;
	}
	
	public String toString(){ 
		String rep = "";
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[0].length; j++) {
				rep += plateau[i][j];
			}
			rep += "\n"	;
		}
		System.out.println(rep);
	}
	
	
}
