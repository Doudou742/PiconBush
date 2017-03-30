package personnages;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;




public class essai {

	public static boolean estInt(String chaine){
		
		for(int idx = 0; idx < chaine.length(); idx ++){
			
			if (chaine.charAt(idx) < '0' || chaine.charAt(idx) > '9'){
				return false;
			}
			return true;
		}
		return false;
	}
	
		public static void main(String[] args) throws Exception {
			
			final ImageIcon iconS = new ImageIcon(new URL("http://files.softicons.com/download/toolbar-icons/mono-general-icons-by-custom-icon-design/png/256x256/success.png"));
		    final ImageIcon iconC = new ImageIcon(new URL("https://image.flaticon.com/icons/png/128/44/44520.png"));
		    String h;
		    String l;
		    String o;
		   
		    do {	
		    	
			Object hauteur = JOptionPane.showInputDialog(null,"Plateau : Hauteur ?","Configuration du plateau",JOptionPane.QUESTION_MESSAGE,iconC,null,"10");
			 h = hauteur.toString();
	
		    } while(h.isEmpty() || !estInt(h));
		     
		    do {
			Object largeur = JOptionPane.showInputDialog(null,"Plateau : Largeur ?","Configuration du plateau",JOptionPane.QUESTION_MESSAGE,iconC,null,"10");
			l = largeur.toString();
		    } while(l.isEmpty() || !estInt(l));
		    
		    do {
			Object obstacle = JOptionPane.showInputDialog(null,"Obstacles : remplissage % ?","Configuration du plateau",JOptionPane.QUESTION_MESSAGE,iconC,null,"25");
			o = obstacle.toString();
			
			if(o.contains("beaufils")){
				o = "42";
			}
			
		    } while(o.isEmpty() || !estInt(o));
			 
			
			
			Plateau unPlateau = new Plateau(Integer.valueOf(h),Integer.valueOf(l),Integer.valueOf(o));
			JOptionPane.showMessageDialog(null, "Le plateau a été configurer avec succès ! \n----------- Place au jeu -----------","Configuration du plateau",JOptionPane.INFORMATION_MESSAGE,iconS);
			
			Base baseA = new Base(0,0,1);
			Base baseB = new Base(unPlateau.getHauteur() -1,unPlateau.getLargeur() -1,2);
			
			unPlateau.addBase(baseA);
			unPlateau.addBase(baseB);
			
			Vue equipeA = new Vue(1,unPlateau);
			Vue equipeB = new Vue(2,unPlateau);
			
			Tireur test = new Tireur(equipeA,1,2,5);
			Char testChar = new Char(equipeB,2,2,6);
			Piegeur testP = new Piegeur(equipeA,1,2,7);
			unPlateau.addRobot(test);
			unPlateau.addRobot(testChar);
			unPlateau.addRobot(testP);
			
			if (! equipeA.estDisponible(new Coord(2,5))){
				System.out.println("Succes 1");
			}
			
			if ( equipeB.estDisponible(new Coord(2,5))){
				System.out.println("Succes 2");
			}
			
			if (! equipeB.estDisponible(new Coord(2,6))){
				System.out.println("Succes 3");
			}

			if (! equipeA.estDisponible(new Coord(2,7))){
				System.out.println("Succes 3");
			}
			
			unPlateau.addMine(new Coord(5,5), 1);
			unPlateau.afficher();
			Action poser = new Attaque(testP,unPlateau.grille[3][7]);
			// System.out.println(equipeA.getContenu(new Coord(5,5)));
			Action bouge= new Deplacement(testP,unPlateau.grille[2][8]);
			
			Action caca = new Deplacement(test,unPlateau.grille[2][4]);
			
			caca.agit();
			poser.agit();
			bouge.agit();
			System.out.println(testP.getEnergie());
			System.out.println("Equipe 1:");
			unPlateau.afficherParEquipe(1);
			System.out.println("Equipe 2:");
			unPlateau.afficherParEquipe(2);
			/*equipeA.poserRobot(testChar, new Coord(6,6));
			unPlateau.afficher();
		*/
			
		}
}
