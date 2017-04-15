package personnages;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Essai {

	public static boolean equipe = false;

	public static boolean partiFini() {

		return false;

	}

	public static void configEquipe(Vue equipe, Base base, boolean e) {
		Saisie uneSaisie = new Saisie(" ");
		uneSaisie.configurationJoueur(equipe, base, e);
	}

	public static void sortirRobotBase(Vue equipe, Base base, Plateau unPlateau) {
		Saisie uneSaisie = new Saisie(" ");
		String robotABouger = "";
		if (equipe.getEquipe() == 1) {
			robotABouger = Saisie.choixRobotDebut();
			// tab 0 = tireur tab 1 = piegeur tab 2 = char
			if (base.present(new Tireur(equipe, 1, 0, 0)) && robotABouger.equals("Tireur")) {
				base.supprimerListe(new Tireur(equipe, 1, 0, 0));
				Coord tmp = Saisie.choixCoord();
				Action deplacement = new Deplacement(new Tireur(equipe, 1, 0, 0),
				Plateau.grille[tmp.getPositionX()][tmp.getPositionY()]);
				deplacement.agit();
			} else if (base.present(new Piegeur(equipe, 1, 0, 0)) && robotABouger.equals("Piegeur")) {
				base.supprimerListe(new Piegeur(equipe, 1, 0, 0));
				Coord tmp = Saisie.choixCoord();
				Action deplacement = new Deplacement(new Piegeur(equipe, 1, 0, 0),
				Plateau.grille[tmp.getPositionX()][tmp.getPositionY()]);
				deplacement.agit();
			} else if (base.present(new Char(equipe, 1, 0, 0)) && robotABouger.equals("Char")) {
				base.supprimerListe(new Char(equipe, 1, 0, 0));
				Coord tmp = Saisie.choixCoord();
				Action deplacement = new Deplacement(new Char(equipe, 1, 0, 0),
				Plateau.grille[tmp.getPositionX()][tmp.getPositionY()]);
				deplacement.agit();
			}

		} else {
			// String choixEquipe2 = Saisie.queVoulezVousFaire();
			robotABouger = Saisie.choixRobotDebut();
			if (base.present(new Tireur(equipe, 2,Plateau.grille.length-1, Plateau.grille[0].length-1)) && robotABouger.equals("Tireur")) {
				base.supprimerListe(new Tireur(equipe, 2,Plateau.grille.length-1, Plateau.grille[0].length-1));
				Coord tmp = Saisie.choixCoord();
				Action deplacement = new Deplacement(new Tireur(equipe, 2,Plateau.grille.length-1, Plateau.grille[0].length-1),
				Plateau.grille[tmp.getPositionX()][tmp.getPositionY()]);
				deplacement.agit();
			} else if (base.present(new Piegeur(equipe, 2,Plateau.grille.length-1, Plateau.grille[0].length-1)) && robotABouger.equals("Piegeur")) {
				base.supprimerListe(new Piegeur(equipe, 2,Plateau.grille.length-1, Plateau.grille[0].length-1));
				Coord tmp = Saisie.choixCoord();
				Action deplacement = new Deplacement(new Piegeur(equipe, 2,Plateau.grille.length-1, Plateau.grille[0].length-1),
						Plateau.grille[tmp.getPositionX()][tmp.getPositionY()]);
				deplacement.agit();
			} else if (base.present(new Char(equipe, 2,Plateau.grille.length-1, Plateau.grille[0].length-1)) && robotABouger.equals("Char")) {
				base.supprimerListe(new Char(equipe, 2,Plateau.grille.length-1, Plateau.grille[0].length-1));
				Coord tmp = Saisie.choixCoord();
				Action deplacement = new Deplacement(new Char(equipe, 2,Plateau.grille.length-1, Plateau.grille[0].length-1),
				Plateau.grille[tmp.getPositionX()][tmp.getPositionY()]);
				deplacement.agit();
			}

		}
	}

	public static void main(String[] args) throws Exception {

		final ImageIcon iconS = new ImageIcon("image/iconS.png");
		final ImageIcon iconC = new ImageIcon("image/iconC.png");
		final ImageIcon iconR = new ImageIcon("image/iconR.png");

		Saisie uneSaisie = new Saisie(" ");
		final String rules = "Les pays s'affrontent en faisant combattre des robots sur un plateau. \n Le jeu se déroule tour par tour, une équipe est choisie aléatoirement pour commencer la partie. \n Au départ les robots se trouvent dans leur base respective. \n A chaque tour de jeu, chaque équipe choisit un de ses robots pour réaliser une action (déplacement ou attaque). \n Une équipe ne peut pas passer son tour, tant qu'un de ses robots possède assez d'énergie pour réaliser une action elle doit jouer. \n Au cours de la partie chaque équipe doit conserver au moins un robot hors de sa base. \n La partie se termine dès qu'une des deux équipes ne possède plus de robot vivant.";

		JOptionPane.showMessageDialog(null, "Règles du jeu :\n" + "\n " + rules, "Virtual War", 1, iconR);
		String h;
		String l;
		String o;

		do {

			Object hauteur = JOptionPane.showInputDialog(null, "Plateau : Hauteur ?", "Configuration du plateau",
					JOptionPane.QUESTION_MESSAGE, iconC, null, "10");
			h = hauteur.toString();

			if (h.contains("beaufils")) {
				h = "42";
			}

		} while (h.isEmpty() || !uneSaisie.estInt(h));

		do {
			Object largeur = JOptionPane.showInputDialog(null, "Plateau : Largeur ?", "Configuration du plateau",
					JOptionPane.QUESTION_MESSAGE, iconC, null, "10");
			l = largeur.toString();

			if (l.contains("beaufils")) {
				l = "42";
			}

		} while (l.isEmpty() || !uneSaisie.estInt(l));

		do {
			Object obstacle = JOptionPane.showInputDialog(null, "Obstacles : remplissage % ?",
					"Configuration du plateau", JOptionPane.QUESTION_MESSAGE, iconC, null, "25");
			o = obstacle.toString();

			if (o.contains("beaufils")) {
				o = "42";
			}

		} while (o.isEmpty() || !uneSaisie.estInt(o));

		Plateau unPlateau = new Plateau(Integer.valueOf(h), Integer.valueOf(l), Integer.valueOf(o));
		JOptionPane.showMessageDialog(null,
				"Le plateau a été configurer avec succès ! \n----------- Place au jeu -----------",
				"Configuration du plateau", JOptionPane.INFORMATION_MESSAGE, iconS);

		Base baseA = new Base(0, 0, 1);
		Base baseB = new Base(unPlateau.getHauteur() - 1, unPlateau.getLargeur() - 1, 2);

		unPlateau.addBase(baseA);
		unPlateau.addBase(baseB);

		Vue equipeA = new Vue(1, unPlateau);
		Vue equipeB = new Vue(2, unPlateau);

		configEquipe(equipeA, baseA, false);
		configEquipe(equipeB, baseB, true);
		int cpt = 0;
		unPlateau.afficherParEquipe(1);
		do {
			cpt++;

			String robotADeplacerAuDebut = "";
			// affiche le plateau

			// faire jouer la premiere equipe
			String choixEquipe1 = Saisie.queVoulezVousFaire();

			if (choixEquipe1.equals("Sortir un robot de la base")) {
				sortirRobotBase(equipeA, baseA, unPlateau);
			} else if (choixEquipe1.equals("Bouger un robot")) {
				Coord robot = Saisie.DeplacerDemande();
				Robot tmp = unPlateau.grille[robot.getPositionX()][robot.getPositionY()].getUnRobot();
				Coord objectif = Saisie.choixCoord();
				Action deplacement = new Deplacement(tmp, unPlateau.getCellule(objectif));
				deplacement.agit();
			} else if (choixEquipe1.equals("Tirer/Poser une mine")) {
				Coord tmp = Saisie.DeplacerDemande();
				if (unPlateau.grille[tmp.getPositionX()][tmp.getPositionY()].contienRobot()) {
					Robot robot = unPlateau.grille[tmp.getPositionX()][tmp.getPositionY()].getUnRobot();
					Coord cible = Saisie.choixCoord();
					Action agir = new Attaque(robot, unPlateau.getCellule(cible));
					agir.agit();
				}

			}

			unPlateau.afficherParEquipe(1);
			unPlateau.afficheEnergie();
			// a lequipe 2 de jouer
			String choixEquipe2 = Saisie.queVoulezVousFaire();
			if (choixEquipe2.equals("Sortir un robot de la base")) {
				sortirRobotBase(equipeB, baseB, unPlateau);
			} else if (choixEquipe2.equals("Bouger un robot")) {
				Coord robot = Saisie.choixCoord();
				Robot tmp = unPlateau.grille[robot.getPositionX()][robot.getPositionY()].getUnRobot();
				Coord objectif = Saisie.choixCoord();
				Action deplacement = new Deplacement(tmp,
						unPlateau.grille[objectif.getPositionX()][objectif.getPositionY()]);
				deplacement.agit();
			} else if (choixEquipe2.equals("Tirer/Poser une mine")) {
				Coord tmp = Saisie.DeplacerDemande();
				if (unPlateau.grille[tmp.getPositionX()][tmp.getPositionY()].contienRobot()) {
					Robot robot = unPlateau.grille[tmp.getPositionX()][tmp.getPositionY()].getUnRobot();
					Coord cible = Saisie.choixCoord();
					Action agir = new Attaque(robot, unPlateau.getCellule(cible));
					agir.agit();
				}

			}

			unPlateau.afficherParEquipe(2);
			unPlateau.afficheEnergie();
		} while (// equipeA.getCptMort()!=1 && equipeB.getCptMort()!=1
		cpt < 10);
		unPlateau.afficher();

	}
}