package personnage;

import java.util.ArrayList;


public class Equipe {

	private ArrayList<Robot> listeRobot;
	private String nom;
	private boolean equipe;
	

	public Equipe(String nom,boolean equipe){
		
		listeRobot = new ArrayList<>();
		this.nom = nom;
		this.equipe=equipe;
		
	}
	
	public ArrayList<Robot> getListeRobot(){
		
		return this.listeRobot;
	}
	

	
	public void ajouterRobot(Robot unRobot){
		
		listeRobot.add(unRobot);
		
	}
	
	public boolean suppRobot(Robot unRobot){
		
		for(Robot testRobot : listeRobot){
			
			if(testRobot.getCoordonnee().equals(unRobot.getCoordonnee())){
			
				listeRobot.remove(testRobot);
				return true;
			}
		
		}
		return false;
		
	}
	
	
	public String getNom(){
		
		return this.nom;
	}

	public boolean isEquipe() {
		return equipe;
	}

	public void setEquipe(boolean equipe) {
		this.equipe = equipe;
	}


	
	
	
}
