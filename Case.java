
public class Case extends Cellule {
	
	public Case(int positionX, int positionY){
		super(positionX,positionY);
		
	}
	
	public void videCase(){
		
		this.base = 0;
		this.mine = 0;
		this.unRobot = null;
	}
	
}
