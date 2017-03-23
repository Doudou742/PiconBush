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
		return Constantes.getCoutTirTireur();
	}

	@Override
	public int getCoutDep() {
		return Constantes.getCoutDeplacementTireur();
		
	}

	@Override
	public int getDegat() {
		return Constantes.getDegatsTireur();
		
	}

	@Override
	public String getType() {
		return this.type;
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
