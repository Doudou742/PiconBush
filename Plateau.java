package Plateaux;


import java.util.ArrayList;

public class Plateau {
	final private int taille = 20; 
	private ArrayList<Robot> listeRobot;
	private ArrayList<Element> listeElement;
	private ArrayList<Mine> listeMine;
	private char[][] plateau;
	
	public Plateau(){
		this.plateau = new char[taille][taille];
		this.listeRobot = new ArrayList<>();
		this.listeElement = new ArrayList<>();
		this.listeMine = new ArrayList<>();//pourquoi t'attribut 2 fois la meme chose au meme atribut 
		this.listeMine = new ArrayList<>(); //Si c'est une listeMine par joueur, faut listeMine1 et listeMine2
	}
	
	public Plateau(int nbLigne, int nbColonne) {
		this.plateau = new char[nbLigne][nbColonne];
		this.listeRobot = new ArrayList<>();
		this.listeElement = new ArrayList<>();
		this.listeMine = new ArrayList<>();
		this.listeMine = new ArrayList<>(); //Idem
	}

	public ArrayList<Robot> getListeRobot() {
		return listeRobot;
	}

	public void setListeRobot(ArrayList<Robot> listeRobot) {
		this.listeRobot = listeRobot;
	}

	public ArrayList<Element> getListeElement() {
		return listeElement;
	}

	public void setListeElement(ArrayList<Element> listeElement) {
		this.listeElement = listeElement;
	}

	public ArrayList<Mine> getListeMine() {
		return listeMine;
	}

	public void setListeMine(ArrayList<Mine> listeMine) {
		this.listeMine = listeMine;
	}

	public char[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(char[][] plateau) {
		this.plateau = plateau;
	}

	public int getTaille() {
		return taille;
	}
	
	
	
}
