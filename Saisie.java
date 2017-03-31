package personnages;

import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Saisie {

	static String message;
	private Scanner unScanner;
	static JOptionPane jop1;

	public Saisie(String message) {
		this.message = message;
		jop1 = new JOptionPane();
		unScanner = new Scanner(System.in);

	}

public static Coord DeplacerDemande(){
		
		ImageIcon iconQ = new ImageIcon("image/iconQ.png");
		String l;
		String c;
		
		do {
		Object ligne = JOptionPane.showInputDialog(null, "Ligne? :", "Choisir un robot",JOptionPane.QUESTION_MESSAGE, iconQ, null,"");
		l = ligne.toString();
		} while(! estInt(l) || Integer.valueOf(l) > Plateau.grille.length);
		
		do {
		Object colonne = JOptionPane.showInputDialog(null, "Colonne? :", "Choisir un robot",JOptionPane.QUESTION_MESSAGE, iconQ, null, "");
		c = colonne.toString();
		
		} while(! estInt(c) || Integer.valueOf(c) > Plateau.grille[0].length);
		
		return new Coord(Integer.valueOf(l),Integer.valueOf(c));
		
	}

	public static String queVoulezVousFaire() {
		String[] choix = { "Bouger un robot","Sortir un robot de la base", "Tirer/Poser une mine"};
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		String nom = (String) jop.showInputDialog(null, "Que voulez-vous faire ?", "Choix action",
				JOptionPane.QUESTION_MESSAGE, null, choix, choix[0]);
		jop2.showMessageDialog(null, "Vous avez choisi de : " + nom, "Action choisie", JOptionPane.INFORMATION_MESSAGE);
		return nom;
	}

	public static void presentation() {
		jop1 = new JOptionPane();
		ImageIcon img = new ImageIcon("image/valiant_hearts-0.jpg");
		jop1.showMessageDialog(null,
				"Bienvenue sur Virtual War \n Codé par Geoffrey, Louis, Gauthier, Raphaël, Alexandre", "Bienvenue",
				JOptionPane.INFORMATION_MESSAGE, img);
	}

	public static Coord choixCoord() {
		JOptionPane jop = new JOptionPane();
		JOptionPane jop1 = new JOptionPane();
		int x = 0;
		int y = 0;
		String b = "";
		do {
			
			b = jop.showInputDialog(null, "Ligne ?", "Choix déplacement", JOptionPane.QUESTION_MESSAGE);

			if (estNum(b)) {
				x = Integer.parseInt(b);
			}
			if (x < 0 || x > 20) {
				jop.showMessageDialog(null, "Votre ligne n'est pas correcte", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		} while (x > 20 || x < 0 || !estNum(b));

		do {
				b=jop.showInputDialog(null, "Quel est sa colonne ?", "Choix déplacement", JOptionPane.QUESTION_MESSAGE);
				if(estNum(b)){
					y=Integer.parseInt(b);
				}
			if (y > 20 || y < 0) {
				jop.showMessageDialog(null, "Votre ordonnée n'est pas correcte", "Erreur", JOptionPane.ERROR_MESSAGE);

			}
		} while (y > 20 || y < 0 || !estNum(b));
		return new Coord(x, y);
		
		
	}

	public static String SaisieString() {
		// System.out.println(message + ": ");
		return jop1.showInputDialog(null, message, "Mettez nous 20 svp");
	}

	public static boolean estNum(String chaine) {
		for (int i = 0; i < chaine.length(); i++) {
			if ((int) chaine.charAt(i) < 48 || (int) chaine.charAt(i) > 57) {
				return false;
			}
		}
		if(chaine.equals("")){
			return false;
		}
		return true;
	}

	public static int SaisieInt() {
		// System.out.println(message + ": ");
		String mess = jop1.showInputDialog(null, message, "42");
		return Integer.parseInt(mess);
	}

	public void setMessage(String message) {

		this.message = message;
	}
	
	
	public static String choixRobotDebut() {
		String tmp = "";
		do {
			JOptionPane jop = new JOptionPane();
			tmp = jop.showInputDialog(null, "Quel type de robot voulez vous bouger ?  ");
		} while (!tmp.equals("Char") && !tmp.equals("Tireur") && !tmp.equals("Piegeur") );
		return tmp;
	}
	
	
	public static boolean estInt(String chaine) {

		for (int idx = 0; idx < chaine.length(); idx++) {

			if (chaine.charAt(idx) < '0' || chaine.charAt(idx) > '9') {
				return false;
			}

		}
		return true;
	}
	//probleme si on choisit 5 tireurs ou 5 piegeurs ou 5 char
	public int[] configurationJoueur(Vue uneVue, Base uneBase, boolean equipe){
		
		final ImageIcon iconS = new ImageIcon("image/iconS.png");
		final ImageIcon iconC = new ImageIcon("image/iconC.png");
		final ImageIcon iconT = new ImageIcon("image/iconT.png");
		final ImageIcon iconP = new ImageIcon("image/iconP.png");
	    final ImageIcon iconCh = new ImageIcon("image/iconCh.png");
		final ImageIcon iconR = new ImageIcon("image/iconR.png");
		
		String nbT;
		String nbC;
		String nbP;
		String nbTB;
		String nbCB;
		String nbPB;
		
		int[] nbRobotDeChaqueType = new int[3];
		int nbrobot = 0;
		int nbrobotB = 0;
		final int max = 5;
		
		if(! equipe){
		do {
			do {
				Object nb = JOptionPane.showInputDialog(null, "Tireur : Nombre ?", "Tireur Equipe 1",JOptionPane.QUESTION_MESSAGE, iconT, null, " ");
				nbT = nb.toString();
			} while (!estInt(nbT));
			if (Integer.valueOf(nbT) <= max && nbrobot <= max) {
				nbrobot += Integer.valueOf(nbT);
				nbRobotDeChaqueType[0] = Integer.valueOf(nbT);
				//for (int idx = 0; idx < Integer.valueOf(nbT); idx++) {

					//uneBase.addRobot(new Tireur(uneVue, 1, 0, 0));
					//uneBase.addRobotDansTableau(new Tireur(uneVue, 1, 0, 0), idx);
					
				//}
			}
		} while (Integer.valueOf(nbT) > max || nbrobot > max);
		

		if (nbrobot < max) {
			int tmp = nbrobot;
			do {
				nbrobot = tmp;
				do {
					Object nb = JOptionPane.showInputDialog(null, "Piegeur : Nombre ?", "Piegeur Equipe 1",JOptionPane.QUESTION_MESSAGE, iconP, null, " ");
					nbP = nb.toString();
				} while (!estInt(nbP));
					nbrobot += Integer.valueOf(nbP);
					nbRobotDeChaqueType[1] = Integer.valueOf(nbP);
					/*
					for (int idx = 0; idx < Integer.valueOf(nbP); idx++) {

						//uneBase.addRobot(new Piegeur(uneVue, 1, 0, 0));
						uneBase.addRobotDansTableau(new Piegeur(uneVue, 1, 0, 0), idx);
					}
					*/
				
			} while (nbrobot > max);
		}
		if (nbrobot < max) {
			int tmp = nbrobot;
			do {
				nbrobot = tmp;
				do {
					Object nb = JOptionPane.showInputDialog(null, "Char : Nombre ?", "Char Equipe 1",JOptionPane.QUESTION_MESSAGE, iconCh, null, " ");
					nbC = nb.toString();
				} while (!estInt(nbC));
					nbrobot += Integer.valueOf(nbC);
					nbRobotDeChaqueType[2] = Integer.valueOf(nbC);
					/*
					for (int idx = 0; idx < Integer.valueOf(nbC); idx++) {

						//uneBase.addRobot(new Piegeur(uneVue, 1, 0, 0));
						uneBase.addRobotDansTableau(new Char(uneVue, 1, 0, 0), idx);
					}
					*/
					
			} while (nbrobot > max);
			
		}
		
		JOptionPane.showMessageDialog(null,"Votre armée a été configurer avec succès !","Configuration de l'armée Equipe 1", JOptionPane.INFORMATION_MESSAGE, iconS);

		}
		else {
			
			do {
				do {
					Object nb = JOptionPane.showInputDialog(null, "Tireur : Nombre ?", "Tireur Equipe 2",
							JOptionPane.QUESTION_MESSAGE, iconT, null, " ");
					nbTB = nb.toString();
				} while (!estInt(nbTB));
				if (Integer.valueOf(nbTB) <= max && nbrobotB <= max) {
					nbrobotB += Integer.valueOf(nbTB);
					nbRobotDeChaqueType[0] = Integer.valueOf(nbTB);
					/*
					for (int idx = 0; idx < Integer.valueOf(nbTB); idx++) {
						//uneBase.addRobot(new Tireur(uneVue, 1, Plateau.grille.length -1, Plateau.grille[0].length));
						uneBase.addRobotDansTableau(new Tireur(uneVue, 2, Plateau.grille.length -1, Plateau.grille[0].length), idx);
					}
					*/
				}
			} while (Integer.valueOf(nbTB) > max || nbrobotB > max);
			

			if (nbrobotB < max) {
				int tmp = nbrobotB;
				do {
					nbrobotB = tmp;
					do {
						Object nb = JOptionPane.showInputDialog(null, "Piegeur : Nombre ?", "Piegeur Equipe 2",JOptionPane.QUESTION_MESSAGE, iconP, null, " ");
						nbPB = nb.toString();
					} while (!estInt(nbPB));
						nbrobotB += Integer.valueOf(nbPB);
						nbRobotDeChaqueType[1] = Integer.valueOf(nbPB);
						
						/*
						for (int idx = 0; idx < Integer.valueOf(nbPB); idx++) {

							//uneBase.addRobot(new Piegeur(uneVue, 1, Plateau.grille.length -1, Plateau.grille[0].length));
							uneBase.addRobotDansTableau(new Piegeur(uneVue, 2, Plateau.grille.length -1, Plateau.grille[0].length), idx);
						}
						*/
					
				} while (nbrobotB > max);
			}
			if (nbrobotB < max) {
				int tmp = nbrobotB;
				do {
					nbrobotB = tmp;
					do {
						Object nb = JOptionPane.showInputDialog(null, "Char : Nombre ?", "Char Equipe 2",JOptionPane.QUESTION_MESSAGE, iconCh, null, " ");
						nbCB = nb.toString();
					} while (!estInt(nbCB));
						nbrobotB += Integer.valueOf(nbCB);
						nbRobotDeChaqueType[2] = Integer.valueOf(nbCB);
						/*
						for (int idx = 0; idx < Integer.valueOf(nbCB); idx++) {

							//uneBase.addRobot(new Piegeur(uneVue, 1,Plateau.grille.length -1, Plateau.grille[0].length));
							uneBase.addRobotDansTableau(new Char(uneVue, 2, Plateau.grille.length -1, Plateau.grille[0].length), idx);
						}
						*/
					
				} while (nbrobotB > max);
			}
			
			JOptionPane.showMessageDialog(null,"Votre armée a été configurer avec succès !","Configuration de l'armée Equipe 2", JOptionPane.INFORMATION_MESSAGE, iconS);

			
		}
		return nbRobotDeChaqueType;
		
		
	}

	public static void main(String[] args) {
		Saisie tank = new Saisie("Quel robot voulez vous bouger ?");
		String a = "";
		queVoulezVousFaire();
		Coord test = choixCoord();
	}
}