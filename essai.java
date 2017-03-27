package personnages;

import plateau.Plateau;

public class essai {
	public static void main(String [] args){
		Plateau p=new Plateau(10,10,10);
		Base e1 = new Base(0,0,1);
		Base e2=new Base (p.getHauteur()-1,p.getLargeur()-1,2);
		Vue equipe1= new Vue(1,p);
		Vue equipe2= new Vue(2,p);
		
		p.addBase(e1);
		p.addBase(e2);
		p.addMine(new Coord(3,3),1);
		
		p.placeObstacle(10);
		Robot tireur = new Tireur(equipe1,1,2,2);
		Robot piegeur = new Piegeur(equipe1,1,1,1);
		p.addRobot(tireur);
		p.addRobot(piegeur);
		Action poser= new Attaque(piegeur,p.grille[1][2]);
		p.afficher();
		
	}

}
