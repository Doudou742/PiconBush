package personnages;

import java.util.List;

public class Char extends Robot {
	private static int deplacement;
	private static int coutAction;
	private static int coutDep ;
	private static int degat ;
	private static String type = "Char";

	public Char(Vue vue,int equipe, int x, int y) {
		super(vue, x, y, equipe);
		// TODO Auto-generated constructor stub
		super.setEnergie(Constantes.getEnergieTank());
		deplacement=Constantes.getDeplacementTank();
		coutAction=Constantes.getCoutTirTank();
		coutDep=Constantes.getCoutDeplacementTank();
		degat=Constantes.getDegatsTank();
	}
	
	public boolean tirer(Cellule cellule) {
		if (cellule.estLibre()){
			return false;
		}
		
		else if (cellule.getUnRobot() != null) {
			if (cellule.getUnRobot().getEquipe() == this.getEquipe()) {
				return false;
			}
			else {
				super.setEnergie(super.getEnergie() + coutAction);
				cellule.getUnRobot().setEnergie(cellule.getUnRobot().getEnergie() + this.degat);
				return true;
			}
		}
		return false;
		
		
	}

	@Override
	public boolean peutTirer() {
		// TODO Auto-generated method stub
		return super.getEnergie()>=-coutAction;
	}
	
	

	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return coutAction;
	}

	@Override
	public int getCoutDep() {
		// TODO Auto-generated method stub
		return coutDep;
	}

	@Override
	public int getDegat() {
		// TODO Auto-generated method stub
		return degat;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public List<Coord> getDeplacements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cibeVide(Cellule cellule) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString(){
		if(super.getEquipe() == 1){
			return "c";
		}
		if(super.getEquipe() == 2){
			return "C";
		}
		return "error";
	}
	
	
	

}