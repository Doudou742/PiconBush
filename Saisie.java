package personnages;

import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
	
	public class Saisie {

		private String message;
		private Scanner unScanner;
		
		public Saisie(String message){
			this.message = message;
			unScanner = new Scanner(System.in);
			
		}
		
		public String SaisieString(){			
			System.out.println(message + ": ");
			return unScanner.next();
		}
		
		public int SaisieInt(){
			System.out.println(message + ": ");
			return unScanner.nextInt();
		}
		
		public void setMessage(String message){
			
			this.message = message;
		}
		
		public static boolean estInt(String chaine) {

			for (int idx = 0; idx < chaine.length(); idx++) {

				if (chaine.charAt(idx) < '0' || chaine.charAt(idx) > '9') {
					return false;
				}

			}
			return true;
		}
		
		public void configurationJoueur(Vue uneVue, Base uneBase, boolean equipe){
			
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
					for (int idx = 0; idx < Integer.valueOf(nbT); idx++) {

						uneBase.addRobot(new Tireur(uneVue, 1, 0, 0));
					}
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
						
						
						for (int idx = 0; idx < Integer.valueOf(nbP); idx++) {

							uneBase.addRobot(new Piegeur(uneVue, 1, 0, 0));
						}
					
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
						
						
						for (int idx = 0; idx < Integer.valueOf(nbC); idx++) {

							uneBase.addRobot(new Piegeur(uneVue, 1, 0, 0));
						}
					
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
						for (int idx = 0; idx < Integer.valueOf(nbTB); idx++) {

							uneBase.addRobot(new Tireur(uneVue, 1, Plateau.grille.length -1, Plateau.grille[0].length));
						}
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
							
							
							for (int idx = 0; idx < Integer.valueOf(nbPB); idx++) {

								uneBase.addRobot(new Piegeur(uneVue, 1, Plateau.grille.length -1, Plateau.grille[0].length));
							}
						
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
							
							
							for (int idx = 0; idx < Integer.valueOf(nbCB); idx++) {

								uneBase.addRobot(new Piegeur(uneVue, 1,Plateau.grille.length -1, Plateau.grille[0].length));
							}
						
					} while (nbrobotB > max);
				}
				
				JOptionPane.showMessageDialog(null,"Votre armée a été configurer avec succès !","Configuration de l'armée Equipe 2", JOptionPane.INFORMATION_MESSAGE, iconS);

				
			}
			
			
		}
}
