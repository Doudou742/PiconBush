package personnages;

import plateau.Plateau;

public class essai {
	public static void main(String [] args){
		Plateau p=new Plateau(10,10,10);
		Base e1 = new Base(0,0,1);
		Base e2=new Base (p.getHauteur()-1,p.getLargeur()-1,2);
		Vue equipe1= new Vue(1,p);
		Vue equipe2= new Vue(2,p);
		Robot tireur = new Tireur(equipe1,1,2,2);
		p.addBase(e1);
		p.addBase(e2);
		p.addMine(new Coord(3,3),1);
		p.addRobot(tireur);
		p.placeObstacle(5);
		p.afficher();
		
	}

}
