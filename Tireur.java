package personnages;

import java.util.List;

public class Tireur extends Robot {

	private static int deplacement = 1;
	private static int coutAction = -2;
	private static int coutDep = -1;
	private static int degat = -3;
	private static String type = "Tireur";

	public Tireur(Vue vue, int equipe, int x, int y) {
		super(vue, x, y, equipe);
		super.setEnergie(Constantes.getEnergieTireur());
	}
	
	public boolean tirer(int direction) { //return true si la direction est valide (entre 1 et 4)
		if(direction <5 && direction >0) {
			Coord[] tab_direction= new Coord[]{Constantes.haut,Constantes.gauche,Constantes.bas,Constantes.droite};		
			Robot unRobot;
			Coord tmp=this.getCoordonnee().ajouterCoord(tab_direction[direction]);
				if(Plateau.getCellule(tmp).estLibre()) {
					tmp=tmp.ajouterCoord(tab_direction[direction]);
					if(Plateau.getCellule(tmp).contienRobot()) {
						unRobot = Plateau.getCellule(tmp).getUnRobot();
						Plateau.getCellule(tmp).getUnRobot().subitDegat(unRobot);
						this.setEnergie(getEnergie()-getCoutAction());
						return true;
					}
				}
				else if(Plateau.getCellule(tmp).contienRobot()) {
					unRobot = Plateau.getCellule(tmp).getUnRobot();
					Plateau.getCellule(tmp).getUnRobot().subitDegat(unRobot);
					this.setEnergie(getEnergie()-getCoutAction());
				}
				return true;
		}
		return false;
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
			return "t";
		} else if(super.getEquipe()==2){
			return "T";
		}else{
			return "ERROR";
		}
	}
	
	public boolean tirer(Cellule cellule) {
		if (cellule.estLibre()){
			return false;
		}
		
		else if (cellule.getUnRobot() != null) {
			if (cellule.getUnRobot().getEquipe() == this.getEquipe()) {
				return false;
			}
			else {
				super.setEnergie(super.getEnergie() + coutAction);
				cellule.getUnRobot().setEnergie(cellule.getUnRobot().getEnergie() + this.degat);
				return true;
			}
		}
		return false;
		
		
	}

	@Override
	public boolean cibeVide(Cellule cellule) {
		if (cellule.estLibre()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void regen() {
		// TODO Auto-generated method stub
		super.setEnergie(Constantes.getDegatsTireur());
	}


}
