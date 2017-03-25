package plateau;

import java.util.Random;

import personnages.Base;
import personnages.Case;
import personnages.Cellule;
import personnages.Coord;
import personnages.Robot;

public class Plateau {
	private int largeur;
	private int hauteur;
	private int percentObst; // pourcentages d'obstacles max 50
	public static Cellule[][] grille;

	public Plateau(int larg, int haut, int obst) {
		grille = new Cellule[larg][haut];
		this.largeur = larg;
		this.hauteur = haut;
		this.percentObst = (obst <= 50) ? obst : 50; // condition sur une ligne
		initGrille();
	}

	public void initObstacle() {
		int nb_cases = this.hauteur * this.largeur;
		int nb_obstacles = this.percentObst * nb_cases;
		for (int i = 0; i < nb_obstacles; i++) {
		}
	}

	public void placeObstacle(int pourcentage) {
		for (int ligne = 0; ligne < grille.length; ligne++) {
			for (int colonne = 0; colonne < grille[0].length; colonne++) {
				Random random = new Random();
				if (random.nextDouble() * 100 < pourcentage) {
					grille[ligne][colonne].addObstacle();
				}
			}
		}

	}

	public void placementObstacle() {
		this.placeObstacle(percentObst);
		while (!this.bonPlacement()) {
			this.placeObstacle(percentObst);
		}
	}

	private boolean bonPlacement() {
		for (int i = 0; i < grille.length - 1; i++) {
			for (int j = 0; j < grille[0].length - 1; j++) {
				if (i == 0 && j == 0) {
					if (!grille[i + 1][j].estLibre() || !grille[i][j + 1].estLibre()) { // autour
																						// dla
																						// base
																						// en
																						// haut
																						// a
																						// gauche
						return false;
					}
				} else if (i == grille.length && j == grille[0].length) {
					if (!grille[i - 1][j].estLibre() || !grille[i][j - 1].estLibre()) { // autour
																						// dla
																						// base
																						// en
																						// bas
																						// a
																						// droite
						return false;
					}
				} else if (i == 0) {
					if (j == 9 && (!grille[i + 1][j].estLibre() || !grille[i][j - 1].estLibre())) { // coin
																									// en
																									// haut
																									// a
																									// droite
						return false;

					} else if (!grille[i][j - 1].estLibre() || !grille[i][j + 1].estLibre()
							|| !grille[i + 1][j].estLibre()) { // premiere ligne
						return false;
					} else if (j == 0) {
						if (j == 9 && (!grille[i - 1][j].estLibre() || !grille[i][j + 1].estLibre())) { // coin
																										// en
																										// bas
																										// a
																										// gauche
							return false;
						} else if (!grille[i + 1][j].estLibre() || !grille[i][j + 1].estLibre()
								|| !grille[i - 1][j].estLibre()) { // premiere
																	// colonne
							return false;
						}
					} else if (i == grille[0].length) { // derniere ligne
						if (!grille[i][j - 1].estLibre() || !grille[i][j + 1].estLibre()
								|| !grille[i - 1][j].estLibre()) {
							return false;
						}
					} else if (j == grille[0].length) { // derniere colonne
						if (!grille[i + 1][j].estLibre() || !grille[i][j - 1].estLibre()
								|| !grille[i - 1][j].estLibre()) {
							return false;
						}
					} else if (!grille[i][j].estLibre()) {
						if (!grille[i + 1][j].estLibre() || !grille[i - 1][j].estLibre() || !grille[i][j + 1].estLibre()
								|| !grille[i][j - 1].estLibre()) {
							return false;
						}
					}
				}
			}
		}
		return true;
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
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				if (i == 0 && j == 0) {
					grille[i][j] = new Base(i, j, 1);
				} else if (i == 9 && j == 9) {
					grille[i][j] = new Base(i, j, 2);
				} else {
					grille[i][j] = new Case(i, j);

				}
			}
		}
	}

	/*
	 * public void afficher() { String uneChaine=""; String uneChaine2=""; for
	 * (int i=0;i<this.hauteur*2+1;i++) { if(i%2==0) { uneChaine=""; for(int
	 * j=0;j<this.largeur*2+1;j++) { if(j%2==0) { uneChaine=uneChaine+"+"; }
	 * else { uneChaine=uneChaine+"----"; } } System.out.println(uneChaine); }
	 * else { uneChaine2=""; for(int k=0;k<this.largeur*2+1;k++) { if(k%2==0) {
	 * uneChaine2=uneChaine2+"|"; } else {
	 * uneChaine2=uneChaine2+this.grille[i/2][k/2].toString(); } }
	 * System.out.println(uneChaine2); } } }
	 * 
	 */
	public void afficher() {
		String res = "";
		for (int i = 0; i < Plateau.grille.length; i++) {
			for (int k = 0; k < Plateau.grille[0].length; k++) {
				res += "*-";
			}
			res += "*\n";
			for (int j = 0; j < Plateau.grille[0].length; j++) {
				res += "|" + Plateau.grille[i][j].toString();
			}
			res += "|\n";
		}
		for (int k = 0; k < Plateau.grille[0].length; k++) {
			res += "*-";
		}
		res += "*";
		System.out.println(res);
	}

	
	  public void addMine(Coord coord,int mine) {
	  grille[coord.getPositionX()][coord.getPositionY()].addMine(mine);
	  }
	 

	public void addBase(Base b) {
		if (b.getCoordCell().getPositionX() < grille.length && b.getCoordCell().getPositionY() < grille[0].length) {
			grille[b.getCoordCell().getPositionX()][b.getCoordCell().getPositionY()].addBase(b);
		}
	}
	/*
	 * public void addTank(Coord coord) {
	 * grille[coord.getPositionX()][coord.getPositionY()].tank; }
	 */ 
	 public void addRobot(Robot robot) {
	  grille[robot.getCoordonnee().getPositionX()][robot.getCoordonnee().getPositionY()].addRobot(robot);
			   }
	 /* 
	 * public void addPiegeur(Coord coord) {
	 * grille[coord.getPositionX()][coord.getPositionY()].piegeur; }
	 */

}