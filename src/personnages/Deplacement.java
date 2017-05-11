package personnages;
import javax.swing.JOptionPane;
public class Deplacement extends Action {
	// a push dernier push 20/04
	// sert a changer la coord du robot concerné
	private Coord test;
<<<<<<< HEAD
=======

>>>>>>> 635e5a2a1760d42b93a5ae357674f06957c020e6
	
	public Deplacement(Robot robot, Cellule objectif) {
		super(robot, objectif);
	}
<<<<<<< HEAD
=======

>>>>>>> 635e5a2a1760d42b93a5ae357674f06957c020e6
	public void agit() {
		
		// sert a changer la coord du robot concerné 
		Coord recup = super.getRobot().getCoordonnee();
		test = recup;
		
		if (super.getRobot() instanceof Char) {
			
			if (peutYAllerChar() && objectif.estLibre()) {
				if (objectif.contiensMine()) {
					
					Coord save = objectif.getCoordCell();
					objectif.deplaceSur(super.getRobot());
					Plateau.grille[test.getPositionX()][test.getPositionY()].viderCellule();
					super.getRobot().setCoordonnee(save);
					
					super.getRobot().subitMine();
					objectif.mine = 0;
					super.getRobot().setEnergie(super.getRobot().getEnergie() - Constantes.getCoutDeplacementTank());
				} else {
			
					Coord save = objectif.getCoordCell();
					objectif.deplaceSur(super.getRobot());
					Plateau.grille[test.getPositionX()][test.getPositionY()].viderCellule();
					super.getRobot().setCoordonnee(save);
					super.getRobot().setEnergie(super.getRobot().getEnergie() - Constantes.getCoutDeplacementTank());
				}
			}
		} else if (super.getRobot() instanceof Tireur || super.getRobot() instanceof Piegeur) {
			
			//permet de verifier la sortie du robot quand il est sur une base en haut a gauche
			if (super.getRobot().getCoordonnee().getPositionX() == 0 && super.getRobot().getCoordonnee().getPositionY() == 0) {
				if (super.objectif.getCoordCell().equals(super.getRobot().getCoordonnee().ajouterCoord(Constantes.bas)) || super.objectif.getCoordCell().equals(super.getRobot().getCoordonnee().ajouterCoord(Constantes.droite)) || super.objectif.getCoordCell().equals(super.getRobot().getCoordonnee().ajouterCoord(Constantes.diagoBasDroite))) {
					if (Plateau.grille[objectif.getCoordCell().getPositionX()][objectif.getCoordCell().getPositionY()].estLibre()){
						Coord tmp = super.getRobot().getCoordonnee();
						Plateau.grille[objectif.getCoordCell().getPositionX()][objectif.getCoordCell().getPositionY()].addRobot(super.getRobot());
						Plateau.grille[tmp.getPositionX()][tmp.getPositionY()].viderCellule();
						
						
					}
				}
			}
			
			//permet de verifier la sortie du robot quand il est sur la base en bas a droite
			else if (super.getRobot().getCoordonnee().getPositionX() == Plateau.grille.length-1 && super.getRobot().getCoordonnee().getPositionY() == Plateau.grille[0].length-1) {
				if (super.objectif.getCoordCell().equals(super.getRobot().getCoordonnee().ajouterCoord(Constantes.haut)) || super.objectif.getCoordCell().equals(super.getRobot().getCoordonnee().ajouterCoord(Constantes.gauche)) || super.objectif.getCoordCell().equals(super.getRobot().getCoordonnee().ajouterCoord(Constantes.diagoHautGauche))) {
					if (Plateau.grille[objectif.getCoordCell().getPositionX()][objectif.getCoordCell().getPositionY()].estLibre()){
						Coord tmp = super.getRobot().getCoordonnee();
						Plateau.grille[objectif.getCoordCell().getPositionX()][objectif.getCoordCell().getPositionY()].addRobot(super.getRobot());
						Plateau.grille[tmp.getPositionX()][tmp.getPositionY()].viderCellule();
						
						
					}
				}
			}
			
			// regen();
			else if (objectif.estBase() == super.getRobot().getEquipe()){
				
				super.getRobot().regen();
			}
			// deplacement de 1  
			else if (objectif.estLibre() && peutYAller()) {
				if (!objectif.contiensObstacle()) {
					if (objectif.contiensMine()) {
						
						Coord save = objectif.getCoordCell();
						objectif.deplaceSur(super.getRobot());
						Plateau.grille[test.getPositionX()][test.getPositionY()].viderCellule();
						super.getRobot().setCoordonnee(save);
						
						super.getRobot().subitMine();
						objectif.mine =  0;
						
						if (super.getRobot() instanceof Tireur) {
							super.getRobot()
									.setEnergie(super.getRobot().getEnergie() - Constantes.getCoutDeplacementTireur());
						} else {
							super.getRobot()
									.setEnergie(super.getRobot().getEnergie() - Constantes.getCoutDeplacementPiegeur());
						}
					}//retour base ??????????? 
					else if (objectif.estBase() == super.getRobot().getEquipe()) { 
						// obsolet
					super.getRobot().regen();
					} else {
						
						Coord save = objectif.getCoordCell();
						objectif.deplaceSur(super.getRobot());
						Plateau.grille[test.getPositionX()][test.getPositionY()].viderCellule();
						super.getRobot().setCoordonnee(save);
	
						
					
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
			
			//JOptionPane.showMessageDialog(null, "Ce déplacement n'est pas possible","Erreur",JOptionPane.ERROR_MESSAGE);
			return false;
			
		}
	}
	
	
	public boolean peutYAllerChar() {
		Cellule chemin = objectif;
<<<<<<< HEAD
//		Plateau.grille.length <-- x
// 		Plateau.grille[0].length <-- y
		
		// ALLER SUR LES BORDS
		
		
		// RENTRER A LA BASE
		if(super.getRobot().getEquipe() == 1){
			if(objectif.getCoordCell().getPositionX()==0 && objectif.getCoordCell().getPositionY()==0){
				if(	super.getRobot().getCoordonnee().getPositionX() == 1 && super.getRobot().getCoordonnee().getPositionY()==1
						|| super.getRobot().getCoordonnee().getPositionX() == 0 && super.getRobot().getCoordonnee().getPositionY()==1
						|| super.getRobot().getCoordonnee().getPositionX() == 1 && super.getRobot().getCoordonnee().getPositionY()==0){
					return true;
				}
			}
		}else if(super.getRobot().getEquipe() == 2){
			if(objectif.getCoordCell().getPositionX() == Plateau.grille.length-1 && objectif.getCoordCell().getPositionY() == Plateau.grille[0].length-1){
				if(	super.getRobot().getCoordonnee().getPositionX() == Plateau.grille.length-2 && super.getRobot().getCoordonnee().getPositionY() == Plateau.grille[0].length-2
						|| super.getRobot().getCoordonnee().getPositionX() == Plateau.grille.length-2 && super.getRobot().getCoordonnee().getPositionY() == Plateau.grille[0].length-1
						|| super.getRobot().getCoordonnee().getPositionX() == Plateau.grille.length-1 && super.getRobot().getCoordonnee().getPositionY() == Plateau.grille[0].length-2){
					return true;
				}
				
			}
		}
		
		
=======

//		Plateau.grille.length <-- x
// 		Plateau.grille[0].length <-- y
		

		// ALLER SUR LES BORDS
		
		

		// RENTRER A LA BASE
		if(super.getRobot().getEquipe() == 1){

			if(objectif.getCoordCell().getPositionX()==0 && objectif.getCoordCell().getPositionY()==0){

				if(	super.getRobot().getCoordonnee().getPositionX() == 1 && super.getRobot().getCoordonnee().getPositionY()==1
						|| super.getRobot().getCoordonnee().getPositionX() == 0 && super.getRobot().getCoordonnee().getPositionY()==1
						|| super.getRobot().getCoordonnee().getPositionX() == 1 && super.getRobot().getCoordonnee().getPositionY()==0){
					return true;
				}
			}
		}else if(super.getRobot().getEquipe() == 2){

			if(objectif.getCoordCell().getPositionX() == Plateau.grille.length-1 && objectif.getCoordCell().getPositionY() == Plateau.grille[0].length-1){

				if(	super.getRobot().getCoordonnee().getPositionX() == Plateau.grille.length-2 && super.getRobot().getCoordonnee().getPositionY() == Plateau.grille[0].length-2
						|| super.getRobot().getCoordonnee().getPositionX() == Plateau.grille.length-2 && super.getRobot().getCoordonnee().getPositionY() == Plateau.grille[0].length-1
						|| super.getRobot().getCoordonnee().getPositionX() == Plateau.grille.length-1 && super.getRobot().getCoordonnee().getPositionY() == Plateau.grille[0].length-2){
					return true;
				}
				
			}
		}
		
		
>>>>>>> 635e5a2a1760d42b93a5ae357674f06957c020e6
		
		// ON A PARCOURU LE CHEMIN 
		if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.hautChar)
				.equals(super.getObjectif().getCoordCell())) {
			chemin = Plateau.grille	[objectif.getCoordCell().getPositionX()+Constantes.bas.getPositionX()]
									[objectif.getCoordCell().getPositionY()+Constantes.bas.getPositionY()];
		} else if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.basChar)
				.equals(super.getObjectif().getCoordCell())) {
			chemin = Plateau.grille	[objectif.getCoordCell().getPositionX()+Constantes.haut.getPositionX()]
									[objectif.getCoordCell().getPositionY()+Constantes.haut.getPositionY()];
		} else if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.droiteChar)
				.equals(super.getObjectif().getCoordCell())) {
			chemin = Plateau.grille	[objectif.getCoordCell().getPositionX()+Constantes.gauche.getPositionX()]
									[objectif.getCoordCell().getPositionY()+Constantes.gauche.getPositionY()];
		} else if (super.getRobot().getCoordonnee().ajouterCoord(Constantes.gaucheChar)
				.equals(super.getObjectif().getCoordCell())) {
			chemin = Plateau.grille	[objectif.getCoordCell().getPositionX()+Constantes.droite.getPositionX()]
									[objectif.getCoordCell().getPositionY()+Constantes.droite.getPositionY()];
		}
		
		if( !chemin.estLibre()){
			objectif = chemin;
			return false;
		}
		
		
		// SI IL A VA A L'OBJECTIF
		if (objectif.estLibre()) {
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
			
		
		// OBJECTIF BOUCHER MAIS CHEMIN LIBRE
		} else if ( !objectif.estLibre() && chemin.estLibre() ) {
			// a faire le déplacement de 1 TODO
			objectif = chemin;
			return true;
		}
		//JOptionPane.showMessageDialog(null, "Ce déplacement n'est pas possible","Erreur",JOptionPane.ERROR_MESSAGE);
		return false;
	}
}