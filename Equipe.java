package projetS2;

import java.util.ArrayList;


	public class Equipe {

		private ArrayList<Robot> listeRobot;
		private ArrayList<Mine> listeMine;
		private String nom;
		
	
		public Equipe(String nom){
			
			listeRobot = new ArrayList<>();
			listeMine = new ArrayList<>();
			this.nom = nom;
			
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
				
					listeRobot.remove(testRobot)
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
		
		
}
