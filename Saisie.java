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

	public static String queVoulezVousFaire() {
		String[] choix = { "Bouger un robot", "Tirer/Poser une mine", "Poser un robot" };
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		String nom = (String) jop.showInputDialog(null, "Que voulez-vous faire ?", "Choix action",
				JOptionPane.QUESTION_MESSAGE, null, choix, choix[0]);
		jop2.showMessageDialog(null, "Vous avez choisi de : " + nom, "Action choisie", JOptionPane.INFORMATION_MESSAGE);
		return nom;
	}

	public static void presentation() {
		jop1 = new JOptionPane();
		ImageIcon img = new ImageIcon("image/virtualwar.jpg");
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
			
			b = jop.showInputDialog(null, "Quel est son abscisse ?", "Choix X", JOptionPane.QUESTION_MESSAGE);

			if (estNum(b)) {
				x = Integer.parseInt(b);
			}
			if (x < 0 || x > 20) {
				jop.showMessageDialog(null, "Votre abscisse n'est pas correcte", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		} while (x > 20 || x < 0 || !estNum(b));

		do {
				b=jop.showInputDialog(null, "Quel est son ordonnée ?", "Choix Y", JOptionPane.QUESTION_MESSAGE);
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

	public static void main(String[] args) {
		Saisie tank = new Saisie("Quel robot voulez vous bouger ?");
		String a = "";
		presentation();
		Coord test = choixCoord();
	}
}