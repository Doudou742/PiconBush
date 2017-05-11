package personnages;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu {

	int haut, larg, pourcentObstacle;
	
	public Menu() throws IOException {
		bienvenu();
	}
	
	public void bienvenu() throws IOException {
		
		JOptionPane jop = new JOptionPane();
		jop.showMessageDialog(null, "Bienvenu sur Virtual War");
		jop.showMessageDialog(null, "vous avez le droit de choisir 5 robots au maximum");
		String hauteur = jop.showInputDialog("Configuration du plateau, hauteur: ", 12);
		String largeur = jop.showInputDialog("configuration plateau, largeur: ", 12);
		String pourcentO = jop.showInputDialog("Configuration du plateau, pourcentage d'obstacle: ", 12);
		haut = Integer.parseInt(hauteur);
		larg = Integer.parseInt(largeur);
		pourcentObstacle = Integer.parseInt(pourcentO);
	}
	
	
	
	
	public int getHaut() {
		return haut;
	}

	public void setHaut(int haut) {
		this.haut = haut;
	}

	public int getLarg() {
		return larg;
	}

	public void setLarg(int larg) {
		this.larg = larg;
	}

	public int getPourcentObstacle() {
		return pourcentObstacle;
	}

	public void setPourcentObstacle(int pourcentObstacle) {
		this.pourcentObstacle = pourcentObstacle;
	}

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu();
	}
}
