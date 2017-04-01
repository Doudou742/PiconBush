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
	
	
	
	public boolean tirer(Coord direction){
		Coord coordBoucle= new Coord(this.getCoordonnee().getPositionX(), this.getCoordonnee().getPositionY()); 	// Coordonnées de la cellule courante de la boucle
		boolean peutPasTirer, robotEnnemie; 	// Savoir si : on peut tirer/il y a un robot ennemie sur la case.
		
		// On tourne pour toute la porté d'un tank.
		for(int i = 0 ; i<Constantes.getPorteeTank() ; i++){
			coordBoucle=coordBoucle.ajouterCoord(direction);
			
			// On regarde si on sort du plateau. (Le repère du plateau est orienté chelou)
			if( 
					coordBoucle.getPositionY()+1 > Plateau.grille[0].length		|| 	// Droite
					coordBoucle.getPositionX()+1 > Plateau.grille.length 		||	// Bas
					coordBoucle.getPositionX() < 0								||	// Haut
					coordBoucle.getPositionY() < 0	)								// Gauche
			{
				return false;
			}
			
			// robotEnnemie = Si il y a un robot ennemie sur la case courante.
			robotEnnemie = 	Plateau.grille[coordBoucle.getPositionX()][coordBoucle.getPositionY()].contienRobot() &&
							Plateau.grille[coordBoucle.getPositionX()][coordBoucle.getPositionY()].getUnRobot().getEquipe() != this.getEquipe();
			
			// On regarde si sur la case il y a :
			peutPasTirer = 	Plateau.grille[coordBoucle.getPositionX()][coordBoucle.getPositionY()].contiensObstacle() || 	// Un obstacle
							( Plateau.grille[coordBoucle.getPositionX()][coordBoucle.getPositionY()].contienRobot() && 		// Un robot mais ...
										Plateau.grille[coordBoucle.getPositionX()][coordBoucle.getPositionY()].getUnRobot().getEquipe() == this.getEquipe() ); // ... De notre equipe
			
			
			if( peutPasTirer ){ // Si il y a un obstacle ou un robot allié
				return false;	// On ne tire pas.
			}else if (robotEnnemie && this.peutTirer()){ // Si c'est un robot ennemie et qu'on a assez d'energie
				super.setEnergie(super.getEnergie() + coutAction); 	// On modifie l'energie du robot qui tire  
				Plateau.grille[coordBoucle.getPositionX()][coordBoucle.getPositionY()].getUnRobot().subitDegat(); // Et du robot qui est touché.
				return true; // On a réussi a tirer on sort de la boucle (oui violemment oui)				
			}
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
