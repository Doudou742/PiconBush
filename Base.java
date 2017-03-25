package personnages;

public class Base extends Cellule{

	private int equipe;
	
	public Base(int largeur, int hauteur, int equipe){
		// Récupère le constructeur de la classe abstraite Cellule
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
	
	// Récupère methode abstraite
	
	public void ajoute(int equipe){
		this.equipe=equipe;
	}
	
	public void videCase(){
		this.setUnRobot(null);
		this.base=1;
		this.mine=0;
	}
	
	// Déplace le robot passé en paramètre sur la base.
	public void deplaceSur(Robot robot){
		// Change les coordonnées du robot pour mettre les coordonnées de la base a la place.
		//this.unRobot.setCoordonnee(this.getCoordonnees());
	}
	

	
	
}
