
public abstract class Cellule {
	
	protected int mine = 0;
	protected int base = 0;
	private Robot unRobot;
	private Coord uneCoord;
	private String image;
	
	public Cellule(int positionX,int positionY){
		this.unRobot = null;
		this.uneCoord = new Coord(positionX,positionY);
		
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
	
	abstract void deplaceSur(Robot unRobot);
	abstract void ajoute(int equipe);
	abstract void videCase();
		
	
}