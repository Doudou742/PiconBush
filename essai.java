package personnages;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class essai {

	public static boolean equipe = false;

	public static boolean partiFini() {

		return false;
		
	}

	public static void main(String[] args) throws Exception {

		final ImageIcon iconS = new ImageIcon("image/iconS.png");
		final ImageIcon iconC = new ImageIcon("image/iconC.png");
		final ImageIcon iconR = new ImageIcon("image/iconR.png");
		
		Saisie uneSaisie = new Saisie(" ");
		final String rules = "Les pays s'afrontent en faisant combatre des robots sur un plateau. \n Le jeu se déroule tour par tour, une équipe est choisie aléatoirement pour commencer la partie. \n Au départ les robots se trouvent dans leur base respective. \n A chaque tour de jeu, chaque équipe choisit un de ses robots pour réaliser une action (déplacement ou ataque). \n Une équipe ne peut pas passer son tour, tant qu'un de ses robots possède assez d'énergie pour réaliser une action elle doit jouer. \n Au cours de la partie chaque équipe doit conserver au moins un robot hors de sa base. \n La partie se termine dès qu'une des deux équipes ne possède plus de robot vivant.";
		
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

		} while (h.isEmpty() || ! uneSaisie.estInt(h));

		do {
			Object largeur = JOptionPane.showInputDialog(null, "Plateau : Largeur ?", "Configuration du plateau",
					JOptionPane.QUESTION_MESSAGE, iconC, null, "10");
			l = largeur.toString();
			
			if (l.contains("beaufils")) {
				l = "42";
			}
			
		} while (l.isEmpty() || ! uneSaisie.estInt(l));

		do {
			Object obstacle = JOptionPane.showInputDialog(null, "Obstacles : remplissage % ?",
					"Configuration du plateau", JOptionPane.QUESTION_MESSAGE, iconC, null, "25");
			o = obstacle.toString();

			if (o.contains("beaufils")) {
				o = "42";
			}

		} while (o.isEmpty() || !uneSaisie.estInt(o));

		Plateau unPlateau = new Plateau(Integer.valueOf(h), Integer.valueOf(l), Integer.valueOf(o));
		JOptionPane.showMessageDialog(null,"Le plateau a été configurer avec succès ! \n----------- Place au jeu -----------","Configuration du plateau", JOptionPane.INFORMATION_MESSAGE, iconS);

		Base baseA = new Base(0, 0, 1);
		Base baseB = new Base(unPlateau.getHauteur() - 1, unPlateau.getLargeur() - 1, 2);

		unPlateau.addBase(baseA);
		unPlateau.addBase(baseB);

		Vue equipeA = new Vue(1, unPlateau);
		Vue equipeB = new Vue(2, unPlateau);

		uneSaisie.configurationJoueur(equipeA, baseA, false);
		uneSaisie.configurationJoueur(equipeB, baseB, true);
			
		do {

		} while (!partiFini());

		unPlateau.afficher();

	}
}
