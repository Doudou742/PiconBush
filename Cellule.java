package personnages;

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
	
	public int contiensMine(){
		return this.mine;
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
	
	public String toString(){
		
		return this.image;
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
		if(mine==0 && base==0 && unRobot==null && !obstacle){
			return true;
		}else {
			return false;
		}
	}

	abstract void deplaceSur(Robot unRobot);
	abstract void ajoute(int equipe);
	abstract void videCase();
		
	
}