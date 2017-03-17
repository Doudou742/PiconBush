package personnage;

import java.util.ArrayList;
import java.util.Random;

public class Plateau {
	private int taille = 20;
	public static Case[][] plateau;
	private Equipe equipe1;
	private Equipe equipe2;
	private ArrayList<Obstacle> listeObstacle;

	public Plateau() {
		this.plateau = new Case[taille][taille];
		equipe1 = new Equipe("Les minuscules", true);
		equipe2 = new Equipe("Les majuscules", false);
		plateau[0][0]= new Base(0,0,equipe1);
		plateau[20][20] = new Base(20,20,equipe2);
	}

	public Plateau(int nbLigne, int nbColonne) {
		this.plateau = new Case[nbLigne][nbColonne];
		equipe1 = new Equipe("Les minuscules", true);
		equipe2 = new Equipe("Les majuscules", false);
		plateau[0][0] = 'b';
		plateau[nbLigne][nbColonne] = 'B';
		placeObstacle();
	}

	private void placeObstacle() {
		for (int ligne = 0; ligne < plateau.length; ligne++) {
			for (int colonne = 0; colonne < plateau[0].length; colonne++) {
				Random random = new Random();
				if (random.nextDouble() < 0.2) {
					Obstacle obstacle = new Obstacle(ligne, colonne);
					plateau[ligne][colonne].addObstacle(obstacle);
				}
			}
		}

	}

	public Case[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(Case[][] plateau) {
		this.plateau = plateau;
	}

	public int getTaille() {
		return taille;
	}

	public String toString() {
		String rep = "";
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[0].length; j++) {
				rep += plateau[i][j];
			}
			rep += "\n";
		}
		return rep;
	}

	public void placementObstacle(){
		this.placeObstacle();
		while(!this.bonPlacement()){
			this.placeObstacle();
		}
	}

	private boolean bonPlacement(){  
		for(int i=0;i<plateau.length;i++){
			for(int j=0;j<plateau[0].length;j++){
				if(i==0 && j==0){
					if(!plateau[i+1][j].estLibre() || !plateau[i][j+1].estLibre()){ //autour dla base en haut a gauche 
						return false;
					} 
				}else if(i==plateau.length && j==plateau[0].length){
					if(!plateau[i-1][j].estLibre() || !plateau[i][j-1].estLibre()){ //autour dla base en bas a droite
						return false;
					}
				}else if (i==0){ 
					if(j==9 && (!plateau[i+1][j].estLibre() || !plateau[i][j-1].estLibre())){ //coin en haut a droite
						return false;
						
					}else if(!plateau[i][j-1].estLibre() ||  !plateau[i][j+1].estLibre() || !plateau[i+1][j].estLibre()){ //premiere ligne
						return false; 
					}
					else if (j==0){
						if(j==9 && (!plateau[i-1][j].estLibre() ||!plateau[i][j+1].estLibre())){ // coin en bas a gauche
								return false;
						}
						else if(!plateau[i+1][j].estLibre() ||  !plateau[i][j+1].estLibre() || !plateau[i-1][j].estLibre()){ //premiere colonne
							return false;
						}
					}
					else if( i==plateau[0].length){ // derniere ligne 
						if(!plateau[i][j-1].estLibre() ||  !plateau[i][j+1].estLibre() || !plateau[i-1][j].estLibre()){
							return false;
						}
					}
					else if(j==plateau[0].length){ //derniere colonne
						if(!plateau[i+1][j].estLibre() ||  !plateau[i][j-1].estLibre() || !plateau[i-1][j].estLibre()){
							return false;
						}
					}
				else if(!plateau[i][j].estLibre()){
					if(!plateau[i+1][j].estLibre() || !plateau[i-1][j].estLibre() || 
							!plateau[i][j+1].estLibre() || !plateau[i][j-1].estLibre()){
						return false;
					}
				}
			}
		}
	}
		return true;
}
}
