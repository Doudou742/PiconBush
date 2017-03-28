package personnages;

import plateau.Plateau;

public class essai {

		public static void main(String[] args){
			
			Saisie uneSaisie = new Saisie("Hauteur ?");
			System.out.println("Configuration du plateau de jeu");
			int hauteur = uneSaisie.SaisieInt();
			uneSaisie.setMessage("Largeur ?");
			int largeur = uneSaisie.SaisieInt();
			uneSaisie.setMessage("% d'obstacles ?");
			int obstacle = uneSaisie.SaisieInt();
			Plateau unPlateau = new Plateau(hauteur,largeur,obstacle);
			
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
			poser.agit();
			bouge.agit();
			System.out.println(testP.getEnergie());
			unPlateau.afficher();
			/*equipeA.poserRobot(testChar, new Coord(6,6));
			unPlateau.afficher();
		*/
		}
}
