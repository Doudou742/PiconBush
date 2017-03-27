package personnages;

import java.util.List;

public class Piegeur extends Robot{
	private static int deplacement = 1;
	private static int coutAction = -2;
	private static int coutDeplacement = -2;
	private static int degat = -2;
	private static String type = "Piegeur";
	
	public Piegeur(Vue vue, int abscisse, int ordonnee, int equipe) {
		super(vue, abscisse, ordonnee, equipe);
		super.setEnergie(50);
	}
	
	public boolean peutTirer(){
		return super.getEnergie() >= coutAction;
	}
	
	
	
	public int getDeplacement() {
		return deplacement ;
	}
	
	public void setDeplacement(int deplacement) {
		this.deplacement = deplacement;
	}
	
	public int getCoutAction() {
		return this.coutAction;
	}
	
	public int getCoutDep() {
		return this.coutDeplacement;
	}

	public int getDegat() {
		return this.degat;
	}
	
	public String getType() {
		return this.type;
	}

	

	@Override
	public boolean cibleVide(Cellule cellule) {
		return cellule.estLibre();
	}
	
	@Override
	public String toString(){
		if(super.getEquipe()==1){
			return " p ";
		} else if(super.getEquipe()==2){
			return " P ";
		}else{
			return "   ";
		}
	}
	

	

	
	
}