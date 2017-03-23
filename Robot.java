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
		if(vue.getPlateau[coordonnee.getPositionX()][coordonnee.getPositionY()].estBase()==vue.getEquipe()){
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
		return equipe;
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
	

	public void subitDegat(){
		if(this instanceof Char){
			energie-=6;
		}else if(this instanceof Piegeur){
			energie-=2;
		}else if(this instanceof Tireur){
			energie-=3;
		}
	}
	

}
