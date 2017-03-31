package personnages;


public class Deplacement extends Action {

	public Deplacement(Robot robot, Cellule objectif) {
		super(robot, objectif);
	}

	public void agit() {
		if (super.getRobot() instanceof Char) {
			if (objectif.estLibre() && peutYAllerChar()) {
				if (objectif.contiensMine()) {
					Coord tmp = super.getRobot().getCoordonnee();
					objectif.deplaceSur(super.getRobot());
					Plateau.grille[tmp.getPositionX()][tmp.getPositionY()].videCase();
					super.getRobot().subitMine();
					super.getRobot().setEnergie(super.getRobot().getEnergie() - Constantes.getCoutDeplacementTank());
				} else {
					Coord tmp = super.getRobot().getCoordonnee();
					objectif.deplaceSur(super.getRobot());
					Plateau.grille[tmp.getPositionX()][tmp.getPositionY()].videCase();
					super.getRobot().setEnergie(super.getRobot().getEnergie() - Constantes.getCoutDeplacementTank());
				}

			}

		} else if (super.getRobot() instanceof Tireur || super.getRobot() instanceof Piegeur) {
			
			//permet de verifier la sortie du robot quand il est sur une base en haut a gauche
			if (super.getRobot().getCoordonnee().getPositionX() == 0 && super.getRobot().getCoordonnee().getPositionY() == 0) {
				if (super.objectif.getCoordCell().equals(super.getRobot().getCoordonnee().ajouterCoord(Constantes.bas)) || super.objectif.getCoordCell().equals(super.getRobot().getCoordonnee().ajouterCoord(Constantes.droite)) || super.objectif.getCoordCell().equals(super.getRobot().getCoordonnee().ajouterCoord(Constantes.diagoBasDroite))) {
					if (Plateau.grille[objectif.getCoordCell().getPositionX()][objectif.getCoordCell().getPositionY()].estLibre()){
						Plateau.grille[objectif.getCoordCell().getPositionX()][objectif.getCoordCell().getPositionY()].addRobot(super.getRobot());
					}
				}
			}
			
			//permet de verifier la sortie du robot quand il est sur la base en bas a droite
			else if (super.getRobot().getCoordonnee().getPositionX() == Plateau.grille.length-1 && super.getRobot().getCoordonnee().getPositionY() == Plateau.grille[0].length-1) {
				if (super.objectif.getCoordCell().equals(super.getRobot().getCoordonnee().ajouterCoord(Constantes.haut)) || super.objectif.getCoordCell().equals(super.getRobot().getCoordonnee().ajouterCoord(Constantes.gauche)) || super.objectif.getCoordCell().equals(super.getRobot().getCoordonnee().ajouterCoord(Constantes.diagoHautGauche))) {
					if (Plateau.grille[objectif.getCoordCell().getPositionX()][objectif.getCoordCell().getPositionY()].estLibre()){
						Plateau.grille[objectif.getCoordCell().getPositionX()][objectif.getCoordCell().getPositionY()].addRobot(super.getRobot());
					}
				}
			}
			
			// deplacement de 1
			else if (objectif.estLibre() && peutYAller()) {
				if (!objectif.contiensObstacle()) {
					if (objectif.contiensMine()) {
						Coord tmp = super.getRobot().getCoordonnee();
						objectif.deplaceSur(super.getRobot());
						Plateau.grille[tmp.getPositionX()][tmp.getPositionY()].videCase();
						super.getRobot().subitMine();
						if (super.getRobot() instanceof Tireur) {
							super.getRobot()
									.setEnergie(super.getRobot().getEnergie() - Constantes.getCoutDeplacementTireur());
						} else {
							super.getRobot()
									.setEnergie(super.getRobot().getEnergie() - Constantes.getCoutDeplacementPiegeur());
						}
					}//retour base ??????????? 
					else if (objectif.estBase() == super.getRobot().getEquipe()) {
					super.getRobot().regen();
					} else {
						Coord tmp = super.getRobot().getCoordonnee();
						objectif.deplaceSur(super.getRobot());
						Plateau.grille[tmp.getPositionX()][tmp.getPositionY()].videCase();
						if (super.getRobot() instanceof Tireur) {
							super.getRobot()
									.setEnergie(super.getRobot().getEnergie() - Constantes.getCoutDeplacementTireur());
						} else {
							super.getRobot()
									.setEnergie(super.getRobot().getEnergie() - Constantes.getCoutDeplacementPiegeur());
						}
					}
				}
			}
			
		}
		
	}

	public boolean peutYAller() {
		if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.haut).equals(super.getObjectif().getCoordCell())) {
			return true;
		} else if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.bas)
				.equals(super.getObjectif().getCoordCell())) {
			return true;
		} else if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.droite)
				.equals(super.getObjectif().getCoordCell())) {
			return true;
		} else if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.gauche)
				.equals(super.getObjectif().getCoordCell())) {
			return true;
		} else if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.diagoBasDroite)
				.equals(super.getObjectif().getCoordCell())) {
			return true;
		} else if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.diagoBasGauche)
				.equals(super.getObjectif().getCoordCell())) {
			return true;
		} else if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.diagoHautDroite)
				.equals(super.getObjectif().getCoordCell())) {
			return true;
		} else if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.diagoHautGauche)
				.equals(super.getObjectif().getCoordCell())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean peutYAllerChar() {
		if (!objectif.contiensObstacle()) {
			if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.hautChar)
					.equals(super.getObjectif().getCoordCell())) {
				return true;
			} else if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.basChar)
					.equals(super.getObjectif().getCoordCell())) {
				return true;
			} else if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.droiteChar)
					.equals(super.getObjectif().getCoordCell())) {
				return true;
			} else if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.gaucheChar)
					.equals(super.getObjectif().getCoordCell())) {
				return true;
			}
		} else if (objectif.contiensObstacle()) {
			// a faire le déplacement de 1
		}

		return false;

	}

}