package personnages;

public class Attaque extends Action {

	public Attaque(Robot unRobot, Cellule cellule) {
		super(unRobot, cellule);

	}

	public void agit() {
		if (super.getRobot() instanceof Tireur) {
			tirer(super.getObjectif());
		}else if(super.getRobot() instanceof Piegeur){
			if(super.getRobot().getVue().nbMine > 0){
			poserMine(super.getObjectif());
			super.getRobot().getVue().nbMine --;
			}
		}else if(super.getRobot() instanceof Char){
			tirerTank(super.getObjectif());
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
					super.getRobot().setEnergie(super.getRobot().getEnergie() - super.getRobot().getCoutAction());
					cellule.getUnRobot().setEnergie(cellule.getUnRobot().getEnergie() - super.getRobot().getDegat());
					return true;
				}
			}
		}
		return false;

	}
	
	public boolean tirerTank(Cellule cellule){
		// Position (x ou y) de la cible et du char.
		int x = super.getRobot().getCoordonnee().getPositionX();
		int y = super.getRobot().getCoordonnee().getPositionY();
		
		boolean MmLigne = cellule.getCoordCell().getPositionX() == super.getRobot().getCoordonnee().getPositionX(),
				MmColonne = cellule.getCoordCell().getPositionY() == super.getRobot().getCoordonnee().getPositionY();
		
		// Si la cellule est vide on ne peux tirer
		if (cellule.estLibre() ||  cellule.getUnRobot() == null   ){
			return false;
		}
		
		// Si il y a un robot
		else if (cellule.getUnRobot() != null) {
			// Si c'est un robot de son equipe on ne peux tirer
			if (cellule.getUnRobot().getEquipe() == super.getRobot().getEquipe()) {
				return false;
			}
			// Si c'est un robot ennemi
			else {
				// Si il est sur la mm ligne
				
				// Soit x ou y, soit sur la m�me ligne soit sur la m�me colonne.
				if(MmLigne){	
					// Tant qu'on n'a pas regard� entre les deux.
					while(x != cellule.getCoordCell().getPositionX()){
							
						//Si tireur a gauche (ou au dessus) de cible on incr�mente sinon on d�cr�mente.
						if(x < cellule.getCoordCell().getPositionX()){
							x++;
						}else{
							x--;
						}
						// Si il y a qqch entre le tireur et la cible, on quitte.
						if(! (Plateau.grille[x][ super.getRobot().getCoordonnee().getPositionY()].estLibre()) ){
							return false;
						}
					}
				}
					
				// if mm colonne
				if(MmColonne){
					// Tant qu'on est entre le tireur et la cible
					while(y != cellule.getCoordCell().getPositionY()){			
						
						//Si tireur au dessus cible on incr�mente sinon on d�cr�mente.
						if(y < cellule.getCoordCell().getPositionY()){
							y++;
						}else{
							y--;
						}
						// Si il y a qqch entre le tireur et la cible, on quitte.
						// R�cup�rer la cellule par une coordonn� 
						// a refaire 
						if(! (Plateau.grille[y][ super.getRobot().getCoordonnee().getPositionX()].estLibre() ) ){
							return false;
						}
					}
				
				}
					
				// On modifie l'energie du robot qui tire 
				super.getRobot().setEnergie( super.getRobot().getEnergie() -  super.getRobot().getCoutAction());
				// Et du robot qui est touch�.
				cellule.getUnRobot().setEnergie(cellule.getUnRobot().getEnergie() -  super.getRobot().getDegat());
				return true;
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
