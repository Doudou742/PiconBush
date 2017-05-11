package personnages;

import java.util.List;


abstract public class Robot {

	private int energie;
	private int equipe;
	private Coord coordonnee;
	private Vue vue;
	
	//ToString a faire si besoin
	
	public Robot(Vue vue,int x, int y, int equipe){
		this.vue=vue;
		coordonnee=new Coord(x,y);
		this.equipe=equipe;
	}
	
	abstract public boolean peutTirer();
	
	
	/* A modifier selon la classe vue */
	public boolean estSurBase(){
		if(Plateau.grille[coordonnee.getPositionX()][coordonnee.getPositionY()].estBase()==vue.getEquipe()){
			return true;
		}
		return false;
	}
	
	public void setCoordonnee(Coord coordonnee){
		this.coordonnee.setPositionX(coordonnee.getPositionX());
		this.coordonnee.setPositionY(coordonnee.getPositionY());
	}
	
	public Coord getCoordonnee(){
		return this.coordonnee;
	}

	public int getEquipe() {
		return this.equipe;
	}

	public Vue getVue() {
		return vue;
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}

	public void setVue(Vue vue) {
		this.vue = vue;
	}
	
	abstract public int getCoutAction();
	abstract public int getCoutDep();
	abstract public int getDegat();
	abstract public String getType();
	abstract public boolean cibeVide(Cellule cellule);
	abstract public String toString();
	abstract public void regen();
	public void subitDegat(Robot robotAttack){
		if(robotAttack instanceof Char) {
			this.energie-=6;
			if(this.getEnergie()<=0){
				vue.augmenteCptMort();
			}
		}
		else if(robotAttack instanceof Tireur) {
			this.energie-=3;
			if(this.getEnergie()<=0){
				vue.augmenteCptMort();
			}
		}
		else {
			this.energie-=2;
			if(this.getEnergie()<=0){
				vue.augmenteCptMort();
			}
		}
}
	
	public void subitMine(){
		this.setEnergie(this.getEnergie()-2);
		if(this.getEnergie()<=0){
			this.vue.augmenteCptMort();
		}
	}
	

}