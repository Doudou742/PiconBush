package personnages;

public class Base extends Cellule{

	private int equipe;
	
	
	public Base(int largeur, int hauteur, int equipe){
		// R�cup�re le constructeur de la classe abstraite Cellule
		super(largeur, hauteur);
		this.equipe = equipe;
	}
	
	// Getter/Setter
	
	public int getEquipe(){
		return this.equipe;
	}
	
	public void setEquipe(int equipe){
		this.equipe=equipe;
	}
	
	// Methodes 
	
	// R�cup�re methode abstraite
	
	public void ajoute(int equipe){
		this.equipe=equipe;
	}
	
	public void videCase(){
		this.setUnRobot(null);
		this.base=1;
		this.mine=0;
	}
	
	// D�place le robot pass� en param�tre sur la base.
	public void deplaceSur(Robot robot){
		// Change les coordonn�es du robot pour mettre les coordonn�es de la base a la place.
		//this.unRobot.setCoordonnee(this.getCoordonnees());
	}

//	public Robot[] getTableauRobot() {
//		return tableauRobot;
//	}
//
//	public void setTableauRobot(Robot[] tableauRobot) {
//		this.tableauRobot = tableauRobot;
//	}
//	
//	public void addRobotDansTableau(Robot r, int idx){
//		this.tableauRobot[idx] = r;
//	}
	
	
	

	
	
}
