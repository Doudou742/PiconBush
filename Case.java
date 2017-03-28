package personnages;

public class Case extends Cellule {
	
	public Case(int positionX, int positionY){
		super(positionX,positionY);
		
	}
	
	public void videCase(){
		
		this.base = 0;
		this.mine = 0;
		this.setUnRobot(null);
	}

	@Override
	void deplaceSur(Robot unRobot) {
		// TODO Auto-generated method stub
		super.setUnRobot(unRobot);
		
	}

	@Override
	void ajoute(int equipe) {
		// TODO Auto-generated method stub
		
	}
	
}