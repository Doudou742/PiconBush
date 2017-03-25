package personnages;

import plateau.Plateau;

public abstract class Cellule {
	
	protected int mine = 0;
	protected int base = 0;
	private Robot unRobot;
	private Coord uneCoord;
	private String image;
	protected boolean obstacle;
	
	public Cellule(int positionX,int positionY){
		this.unRobot = null;
		this.uneCoord = new Coord(positionX,positionY);
		obstacle=false;
		
	}
	
	public void addBase(Base base){
		this.base=base.getEquipe();
	}
	
	public void addRobot(Robot robot){
		unRobot=robot;
	}
	
	public void addMine(int mine){
		this.mine=mine;
	}
	public boolean contiensMine(){
		return mine!=0;
	}
	
	public int estBase(){
		return this.base;
	}
	
	public Coord getCoordCell(){
		return this.uneCoord;
	}
	
	public Robot getContenu(){
		return this.unRobot;
	}
	
	public boolean contiensObstacle(){
		return obstacle;
	}
	
	public Robot getUnRobot() {
		return unRobot;
	}
	

	public void setUnRobot(Robot unRobot) {
		this.unRobot = unRobot;
	}
	
	public boolean estLibre(){
		if(base==0 && unRobot==null && !obstacle){
			return true;
		}else {
			return false;
		}
	}
	public void addObstacle(){
		obstacle=true;
	}


	public boolean celluleValide(){
		if(this.uneCoord.getPositionX()<Plateau.grille.length && this.uneCoord.getPositionY()<Plateau.grille[0].length){
			return true;
		}
		return false;
	}
	abstract void deplaceSur(Robot unRobot);
	abstract void ajoute(int equipe);
	abstract void videCase();
	
	public String toString(){
		if(mine!=0){
			return "X";
		}
		else if (unRobot !=null){
			unRobot.toString();
		}
		else if(obstacle){
			return "O";
		}else if(base==1){
			return "b";
		}else if(base==2){
			return "B";
		}
		return " ";
	}
		
	
}