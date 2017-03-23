package personnages;


public class Tireur extends Robot {

	private static int deplacement = 1;
	private static int coutAction = -2;
	private static int coutDep = -1;
	private static int degat = -3;
	private static String type = "Tireur";

	public Tireur(Vue vue, int energie, int equipe, int x, int y) {
		super(vue, x, y, equipe);
		super.setEnergie(energie);
	}

	public int getDeplacement() {
		return deplacement;
	}

	@Override
	public boolean peutTirer() { // 
		// TODO Auto-generated method stub
		if(super.getEnergie()>=-coutAction){
			return true;
		}
		return false;
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

	public String toString(){
		if(super.getEquipe()==1){
			return " t ";
		} else if(super.getEquipe()==2){
			return " T ";
		}else{
			return "   ";
		}
	}

}
