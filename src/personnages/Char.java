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
		return super.getEnergie()>=-coutAction;
	}
	
	

	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return coutAction;
	}

	@Override
	public int getCoutDep() {
		return coutDep;
	}

	@Override
	public int getDegat() {
		return degat;
	}

	@Override
	public String getType() {
		return type;
	}



	@Override
	public boolean cibeVide(Cellule cellule) {
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

	@Override
	public void regen() {
		super.setEnergie(Constantes.getEnergieTank());
	}
	
	
	

}