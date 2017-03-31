package personnages;

import personnages.Coord;

public class Constantes {
	

	// CONSTANTES DE DEGAT	
	
	private static final int DEGATS_TANK = 6;
	private static final  int DEGATS_TIREUR = 3;
	private static final int DEGATS_PIEGEUR = 2;
	
	// CONSTANTES COUT DEPLACEMENT 
	
	private static final int COUT_DEPLACEMENT_TANK = 5;
	private static final int COUT_DEPLACEMENT_TIREUR = 1;
	private static final int COUT_DEPLACEMENT_PIEGEUR = 2;
	
	// CONSTANTES PORTEE
	
	private static final int PORTEE_TIREUR = 3;
	private static final int PORTEE_PIEGEUR = 1;
	private static final int PORTEE_TANK = 10;
	
	// CONSTANTES  DEPLACEMENT
	
	private static final int DEPLACEMENT_TANK = 2;
	private static final int DEPLACEMENT_TIREUR = 1;
	private static final int DEPLACEMENT_PIEGEUR = 1;
	
	// CONSTANTES ACTION
	
	private static final int COUT_TIR_TANK = 1;
	private static final int COUT_TIR_TIREUR = 2;
	private static final int COUT_MINE = 2;
	
	// CONSTANTES ENERGIE INITIAL
	
	private static final int ENERGIE_TANK = 60;
	private static final int ENERGIE_TIREUR = 40;
	private static final int ENERGIE_PIEGEUR = 50;
	
	//déplacement
	
	public final static Coord gauche=new Coord(0,-1);;
	public final static Coord droite=new Coord(0,1); 
	public final static Coord haut=new Coord(-1,0);
	public final static Coord bas=new Coord(1,0);
	public final static Coord diagoBasDroite=new Coord(1,1);
	public final static Coord diagoHautGauche=new Coord(-1,-1);
	public final static Coord diagoBasGauche=new Coord(1,-1);
	public final static Coord diagoHautDroite=new Coord(-1,1);
	
	public final static Coord hautChar = new Coord(-2,0);
	public final static Coord basChar = new Coord(2,0);
	public final static Coord gaucheChar = new Coord(0,-2);
	public final static Coord droiteChar = new Coord(0,2);
	
	// RECHARGE ROBOT DANS UNE BASE
	
	private static final int RECHARGE = 2;
	
	// MINE INITIAL
	
	private static final int MINE_INITIAL = 10;
	
	// GETTERS

	public static int getDegatsTank() {
		return DEGATS_TANK;
	}

	public static int getDegatsTireur() {
		return DEGATS_TIREUR;
	}

	public static int getDegatsPiegeur() {
		return DEGATS_PIEGEUR;
	}

	public static int getCoutDeplacementTank() {
		return COUT_DEPLACEMENT_TANK;
	}

	public static int getCoutDeplacementTireur() {
		return COUT_DEPLACEMENT_TIREUR;
	}

	public static int getCoutDeplacementPiegeur() {
		return COUT_DEPLACEMENT_PIEGEUR;
	}

	public static int getPorteeTireur() {
		return PORTEE_TIREUR;
	}

	public static int getPorteePiegeur() {
		return PORTEE_PIEGEUR;
	}

	public static int getPorteeTank() {
		return PORTEE_TANK;
	}

	public static int getDeplacementTank() {
		return DEPLACEMENT_TANK;
	}

	public static int getDeplacementTireur() {
		return DEPLACEMENT_TIREUR;
	}

	public static int getDeplacementPiegeur() {
		return DEPLACEMENT_PIEGEUR;
	}

	public static int getCoutTirTank() {
		return COUT_TIR_TANK;
	}

	public static int getCoutTirTireur() {
		return COUT_TIR_TIREUR;
	}

	public static int getCoutMine() {
		return COUT_MINE;
	}

	public static int getEnergieTank() {
		return ENERGIE_TANK;
	}

	public static int getEnergieTireur() {
		return ENERGIE_TIREUR;
	}

	public static int getEnergiePiegeur() {
		return ENERGIE_PIEGEUR;
	}

	public static int getRecharge() {
		return RECHARGE;
	}

	public static int getMineInitial() {
		return MINE_INITIAL;
	}
	
	
	// GETTERS
	
	
		
	
}