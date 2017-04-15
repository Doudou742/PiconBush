package personnages;

import java.util.ArrayList;

public class Base extends Cellule{

	private int equipe;
	//private Robot[] tableauRobot = new Robot[5];
	private ArrayList<Robot> depart = new ArrayList<>();
	
	public Base(int largeur, int hauteur, int equipe){
		// R�cup�re le constructeur de la classe abstraite Cellule
		super(largeur, hauteur);
		this.equipe = equipe;
	}
	
	// Getter/Setter
	
	
	public int getEquipe(){
		return this.equipe;
	}
	
	public ArrayList<Robot> getDepart() {
		return depart;
	}

	public void setDepart(ArrayList<Robot> depart) {
		this.depart = depart;
	}
	
	public void ajouter(Robot robot){
		depart.add(robot);
	}

	public void setEquipe(int equipe){
		this.equipe=equipe;
	}
	
	
	public boolean present(Robot robot){
		for(int i=0;i<depart.size();i++){
			if(robot.toString().equals(depart.get(i).toString())){
				return true;
			}
		}
		return false;
		
	}
	
	public boolean supprimerListe(Robot robot){
		for(int i=0;i<depart.size();i++){
			if(robot.toString().equals(depart.get(i).toString())){
				depart.remove(i);
				return true;
			}
		}
		return false;
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
