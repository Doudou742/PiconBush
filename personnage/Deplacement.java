package personnage;


public class Deplacement {
	public final static Coord haut=new Coord(0,-1);;
	public final static Coord bas=new Coord(0,1); 
	public final static Coord gauche=new Coord(-1,0);
	public final static Coord droite=new Coord(1,0);
	public final static Coord diagoBasDroite=new Coord(1,1);
	public final static Coord diagoHautGauche=new Coord(-1,-1);
	public final static Coord diagoBasGauche=new Coord(1,-1);
	public final static Coord diagoHautDroite=new Coord(-1,1);
	
	public final static Coord hautT=new Coord(0,-2);;
	public final static Coord basT=new Coord(0,2);
	public final static Coord gaucheT=new Coord(-2,0);
	public final static Coord droiteT=new Coord(2,0);

}
