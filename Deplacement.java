package personnages;

public class Deplacement extends Action {

	public Deplacement(Robot robot, Cellule objectif) {
		super(robot, objectif);
	}

	public void bougerRobot() {
		if (super.getRobot() instanceof Char) {
			// deplacement de 2

		} else if (super.getRobot() instanceof Tireur || super.getRobot() instanceof Piegeur) {
			// deplacement de 1
			if (objectif.estLibre()) {
				if (!objectif.contiensObstacle() && objectif.celluleValide()) {
					if (objectif.contiensMine()) {
						Coord tmp = super.getRobot().getCoordonnee();
						objectif.deplaceSur(super.getRobot());
						Plateau.grille[tmp.getPositionX()][tmp.getPositionY()].videCase();
						super.getRobot().subitDegat();
					} else {
						Coord tmp = super.getRobot().getCoordonnee();
						objectif.deplaceSur(super.getRobot());
						Plateau.grille[tmp.getPositionX()][tmp.getPositionY()].videCase();
					}
				}

			}
		}
	}

	public boolean peutBouger() {
		Coord tmp=super.getRobot().getCoordonnee();
		if(tmp.ajouterCoord(Constantes.haut))
	}

	@Override
	public void agit() {

	}

}
