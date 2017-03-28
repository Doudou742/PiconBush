package personnages;

public class Attaque extends Action {

	public Attaque(Robot unRobot, Cellule cellule) {
		super(unRobot, cellule);

	}

	public void agit() {
		if (super.getRobot() instanceof Tireur || super.getRobot() instanceof Char) {
			tirer(super.getObjectif());
		}else if(super.getRobot() instanceof Piegeur){
			poserMine(super.getObjectif());
		}
		
	}

	public boolean tirer(Cellule cellule) {
		if (super.getRobot() instanceof Tireur || super.getRobot() instanceof Char) {
			if (cellule.estLibre() || !cellule.celluleValide()) {
				return false;
			}

			else if (cellule.getUnRobot() != null) {
				if (cellule.getUnRobot().getEquipe() == super.getRobot().getEquipe()) {
					return false;
				} else if (super.getRobot().peutTirer()) {
					super.getRobot().setEnergie(super.getRobot().getEnergie() + super.getRobot().getCoutAction());
					cellule.getUnRobot().setEnergie(cellule.getUnRobot().getEnergie() + super.getRobot().getDegat());
					return true;
				}
			}
		}
		return false;

	}

	public boolean poserMine(Cellule cellule) {
		if (super.getRobot() instanceof Piegeur) {
			if (!cellule.estLibre() || !cellule.celluleValide()) {
				return false;
			} else if (super.getRobot().peutTirer()) {
				cellule.addMine(super.getRobot().getEquipe());
				super.getRobot().setEnergie(super.getRobot().getEnergie()+super.getRobot().getCoutAction());
				return true;
			}
		}
		return false;

	}

}
