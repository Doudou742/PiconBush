package personnage;

import java.util.ArrayList;


public class Equipe {

	private ArrayList<Robot> listeRobot;
	private ArrayList<Mine> listeMine;
	private String nom;
	private boolean equipe;
	

	public Equipe(String nom,boolean equipe){
		
		listeRobot = new ArrayList<>();
		listeMine = new ArrayList<>();
		this.nom = nom;
		this.equipe=equipe;
		
	}
	
	public ArrayList getListeRobot(){
		
		return this.listeRobot;
	}
	
	public ArrayList getListeMine(){
		
		return this.listeMine;
	}
	
	public void ajouterRobot(Robot unRobot){
		
		listeRobot.add(unRobot);
		
	}
	
	public void ajouterMine(Mine uneMine){
		
		listeMine.add(uneMine);
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
	
	public boolean suppMine(Mine uneMine){
		
		for(Mine testMine : listMine){
			
			if(testMine.getCoordonnee().equals(uneMine.getCoordonnee())){
				
				listeMine.remove(testMine);
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
