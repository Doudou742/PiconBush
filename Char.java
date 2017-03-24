package personnages;

public class Char extends Robot {
	private static int deplacement;
	private static int coutAction;
	private static int coutDep ;
	private static int degat ;
	private static String type = "Char";

	public Char(Vue vue, int x, int y, int equipe) {
		super(vue, x, y, equipe);
		// TODO Auto-generated constructor stub
		super.setEnergie(Constantes.getEnergieTank());
		deplacement=Constantes.getDeplacementTank();
		coutAction=Constantes.getCoutTirTank();
		coutDep=Constantes.getCoutDeplacementTank();
		degat=Constantes.getDegatsTank();
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
	public boolean cibleVide(Cellule cellule) {
		// TODO Auto-generated method stub
		return cellule.estLibre();
	}
	
	
	
	

}
