package personnages;

import java.util.List;

import plateaux.Plateau;

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
	/*
	 * Verifier qu'il n'y ai pas d'obstacle entre les deux (obs, qqun d'autre etc)
	 */
//	public boolean tirer(Cellule cellule) {
//		
//		// Position (x ou y) de la cible et du char.
//		int x = this.getCoordonnee().getPositionX(),
//			y = this.getCoordonnee().getPositionY();
//		
//		boolean MmLigne = cellule.getCoordCell().getPositionX() == this.getCoordonnee().getPositionX(),
//				MmColonne = cellule.getCoordCell().getPositionY() == this.getCoordonnee().getPositionY();
//		
//		// Si la cellule est vide on ne peux tirer
//		if (cellule.estLibre() ||  cellule.getUnRobot() == null   ){
//			return false;
//		}
//		
//		// Si il y a un robot
//		else if (cellule.getUnRobot() != null) {
//			// Si c'est un robot de son equipe on ne peux tirer
//			if (cellule.getUnRobot().getEquipe() == this.getEquipe()) {
//				return false;
//			}
//			// Si c'est un robot ennemi
//			else {
//				// Si il est sur la mm ligne
//				
//				// Soit x ou y, soit sur la même ligne soit sur la même colonne.
//				if(MmLigne){	
//					// Tant qu'on n'a pas regardé entre les deux.
//					while(x != cellule.getCoordCell().getPositionX()){
//							
//						//Si tireur a gauche (ou au dessus) de cible on incrémente sinon on décrémente.
//						if(x < cellule.getCoordCell().getPositionX()){
//							x++;
//						}else{
//							x--;
//						}
//						// Si il y a qqch entre le tireur et la cible, on quitte.
//						if(! (Plateau.grille[x][this.getCoordonnee().getPositionY()].estLibre()) ){
//							return false;
//						}
//					}
//				}
//					
//				// if mm colonne
//				if(MmColonne){
//					// Tant qu'on est entre le tireur et la cible
//					while(y != cellule.getCoordCell().getPositionY()){			
//						
//						//Si tireur au dessus cible on incrémente sinon on décrémente.
//						if(y < cellule.getCoordCell().getPositionY()){
//							y++;
//						}else{
//							y--;
//						}
//						// Si il y a qqch entre le tireur et la cible, on quitte.
//						// Récupérer la cellule par une coordonné 
//						// a refaire 
//						if(! (Plateau.grille[y][this.getCoordonnee().getPositionX()].estLibre() ) ){
//							return false;
//						}
//					}
//				
//				}
//					
//				// On modifie l'energie du robot qui tire 
//				super.setEnergie(super.getEnergie() + coutAction);
//				// Et du robot qui est touché.
//				cellule.getUnRobot().setEnergie(cellule.getUnRobot().getEnergie() + this.degat);
//				return true;
//			}
//		}
//		
//	}
	
	
	/* Prend en paramètre une direction de la classe Constante.
	 * haut bas gauche droite
	 */
	public boolean tirer(Coord direction){
		// Coordonnées de la cellule courante de la boucle
		Coord coordBoucle= new Coord(this.getCoordonnee().getPositionX(), this.getCoordonnee().getPositionY());
		boolean peutPasTirer, robotEnnemie;
		
		// Il tire a 10 cases de distance donc une boucle de 10
		for(int i = 0 ; i<Constantes.getPorteeTank() ; i++){
			coordBoucle=coordBoucle.ajouterCoord(direction);
			
			System.out.println(Plateau.grille[coordBoucle.getPositionX()][coordBoucle.getPositionY()]);
			
			
			// robotEnnemie = Si il y a un robot ennemie sur la case courante.
			robotEnnemie = 	Plateau.grille[coordBoucle.getPositionX()][coordBoucle.getPositionY()].contienRobot() &&
							Plateau.grille[coordBoucle.getPositionX()][coordBoucle.getPositionY()].getUnRobot().getEquipe() != this.getEnergie();
			
			peutPasTirer = 	Plateau.grille[coordBoucle.getPositionX()][coordBoucle.getPositionY()].contiensObstacle() || // Un obstacle
							( Plateau.grille[coordBoucle.getPositionX()][coordBoucle.getPositionY()].contienRobot() && // Un robot mais ...
										Plateau.grille[coordBoucle.getPositionX()][coordBoucle.getPositionY()].getUnRobot().getEquipe() == this.getEquipe() ); // ... De notre equipe
			
			
			
			if( peutPasTirer ){ // Si il y a un obstacle ou un robot allié
				return false;
			}else if (robotEnnemie && this.peutTirer()){ // Si c'est un robot ennemie et qu'on a assez d'energie
				// On modifie l'energie du robot qui tire 
				super.setEnergie(super.getEnergie() + coutAction);
				// Et du robot qui est touché.
				Plateau.grille[coordBoucle.getPositionX()][coordBoucle.getPositionY()].getUnRobot().subitDegat();
				return true;				
			}
			
			
			// Ici regarder si a la prochaine itération on sort du tableau
			
			
		}
		// Si jamais on est sorti de la porté et qu'on a tiré sur rien (tt les cases étaient vide) Alors on ne peux pas tirer
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