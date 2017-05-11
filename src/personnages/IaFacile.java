package personnages;
import personnages.EssaiIa;
import personnages.Deplacement;

import java.util.Random;

import com.sun.org.apache.xml.internal.security.Init;

public class IaFacile {
	static int tmp;
	static int tmp2;
	static boolean equipe=true;
	static int[] nbRobotDeChaqueType=new int[3];
	static Random rand=new Random();
	static int nbChar;
	static int nbTireur;
	static int nbPiegeur;

	public static int[] init() { //selectionne al�atoirement les robots composants l'�quipe
		while(nbChar==0 || nbPiegeur==0 || nbTireur==0) {
			nbChar=0;
			nbTireur=0;
			nbPiegeur=0;
			for(int i=0;i<5;i++) {
				tmp=rand.nextInt(3);
				if(tmp==0) {
					nbChar++;
				}
				else if(tmp==1) {
					nbTireur++;
				}
				else {
					nbPiegeur++;
				}
			}
		}
		nbRobotDeChaqueType[0]=nbTireur;
		nbRobotDeChaqueType[1]=nbPiegeur;
		nbRobotDeChaqueType[2]=nbChar;
		return nbRobotDeChaqueType;
	}
	public void sortiRandomRobot() { //sort un robot de la base au hasard
		tmp=rand.nextInt(3);
		if(EssaiIa.tableauEquipe2[0]!=0 && tmp==0){
			EssaiIa.tableauEquipe2[0]--;
			if(Plateau.grille[Plateau.grille.length -1][Plateau.grille[0].length - 2].estLibre()){ // l9|c8
				Plateau.grille[Plateau.grille.length -1][Plateau.grille[0].length - 2].addRobot(new Tireur(EssaiIa.equipeB,2,Plateau.grille.length -1,Plateau.grille[0].length -2));
			}
			else if(Plateau.grille[Plateau.grille.length -2][Plateau.grille[0].length -1].estLibre()){ // l8|c9
				Plateau.grille[Plateau.grille.length -2][Plateau.grille[0].length -1].addRobot(new Tireur(EssaiIa.equipeB,2,Plateau.grille.length -2,Plateau.grille[0].length -1));
			}
		}
		else if(EssaiIa.tableauEquipe2[1]!=0 && tmp==1) {
			if(Plateau.grille[Plateau.grille.length -1][Plateau.grille[0].length - 2].estLibre()){ // l9|c8
				Plateau.grille[Plateau.grille.length -1][Plateau.grille[0].length - 2].addRobot(new Tireur(EssaiIa.equipeB,2,Plateau.grille.length -1,Plateau.grille[0].length -2));
			}
			else if(Plateau.grille[Plateau.grille.length -2][Plateau.grille[0].length -1].estLibre()){ // l8|c9
				Plateau.grille[Plateau.grille.length -2][Plateau.grille[0].length -1].addRobot(new Tireur(EssaiIa.equipeB,2,Plateau.grille.length -2,Plateau.grille[0].length -1));
			}	
		}
		else if (EssaiIa.tableauEquipe2[2]!=0 && tmp==2) {
			if(Plateau.grille[Plateau.grille.length -1][Plateau.grille[0].length - 2].estLibre()){ // l9|c8
				Plateau.grille[Plateau.grille.length -1][Plateau.grille[0].length - 2].addRobot(new Tireur(EssaiIa.equipeB,2,Plateau.grille.length -1,Plateau.grille[0].length -2));
			}
			else if(Plateau.grille[Plateau.grille.length -2][Plateau.grille[0].length -1].estLibre()){ // l8|c9
				Plateau.grille[Plateau.grille.length -2][Plateau.grille[0].length -1].addRobot(new Tireur(EssaiIa.equipeB,2,Plateau.grille.length -2,Plateau.grille[0].length -1));
			}
		}
	}
	public void joue() {
		boolean valide;
		if(EssaiIa.infoRobotB.isEmpty()){
			sortiRandomRobot();
		}
		tmp=rand.nextInt(3); //choisis l'action du tour
		if(tmp==0 && EssaiIa.robotSortiB<6) {
			sortiRandomRobot();
		}
		else if (tmp==1) {//bouge un robot au hasard dans un endroit au hasard
			tmp=rand.nextInt(Essai.infoRobotB.size()); //choisi un robot au hasard dans la liste de robot sortie
			if(Essai.infoRobotB.get(tmp) instanceof Char) {
				 
			}
			else {
				valide=false;
					while(!valide) {
					tmp2=rand.nextInt(8);
					switch(tmp2) {
					case 0: if (!Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].celluleValide() && Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].contiensObstacle()) {
						break;
					}
					else {
						if (Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].contiensMine()) {
							Essai.infoRobotB.get(tmp).subitMine();
						}
						Essai.infoRobotB.get(tmp).setCoordonnee(Essai.infoRobotB.get(tmp).getCoordonnee().ajouterCoord(new Coord(-1,0)));
						Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()+1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].viderCellule();
						valide=true;
					}
					//regarde s'il peut se déplacer en haut à gauche
					case 1: if (!Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].celluleValide() && Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()-1].contiensObstacle()) {
						break;
					}
					else {
						if (Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()-1].contiensMine()) {
							Essai.infoRobotB.get(tmp).subitMine();
						}
						Essai.infoRobotB.get(tmp).setCoordonnee(Essai.infoRobotB.get(tmp).getCoordonnee().ajouterCoord(new Coord(-1,-1)));
						Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()+1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()+1].viderCellule();
						valide=true;
					}
					//regarde si l'ia peut se déplacer au dessus
					case 2: if (!Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].celluleValide() && Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()-1].contiensObstacle()) {
						break;
					}
					else {
						if (Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()-1].contiensMine()) {
							Essai.infoRobotB.get(tmp).subitMine();
						}
						Essai.infoRobotB.get(tmp).setCoordonnee(Essai.infoRobotB.get(tmp).getCoordonnee().ajouterCoord(new Coord(0,-1)));
						Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()+1].viderCellule();
						valide=true;
					}
					//regarde si l'ia peut aller en haut à droite
					case 3: if (!Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].celluleValide() && Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()+1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()+1].contiensObstacle()) {
						break;
					}
					else {
						if (Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()+1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()+1].contiensMine()) {
							Essai.infoRobotB.get(tmp).subitMine();
						}
						Essai.infoRobotB.get(tmp).setCoordonnee(Essai.infoRobotB.get(tmp).getCoordonnee().ajouterCoord(new Coord(+1,+1)));
						Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()-1].viderCellule();
						valide=true;
					}
					//regarde si l'ia peut aller à droite
					case 4: if (!Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].celluleValide() && Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()+1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].contiensObstacle()) {
						break;
					}
					else {
						if (Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()+1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].contiensMine()) {
							Essai.infoRobotB.get(tmp).subitMine();
						}
						Essai.infoRobotB.get(tmp).setCoordonnee(Essai.infoRobotB.get(tmp).getCoordonnee().ajouterCoord(new Coord(+1,0)));
						Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].viderCellule();
						valide=true;
					}
					//regarde si l'ia peut se déplacer en bas à droite
					case 5: if (!Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].celluleValide() && Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()+1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()-1].contiensObstacle()) {
						break;
					}
					else {
						if (Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()+1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()-1].contiensMine()) {
							Essai.infoRobotB.get(tmp).subitMine();
						}
						Essai.infoRobotB.get(tmp).setCoordonnee(Essai.infoRobotB.get(tmp).getCoordonnee().ajouterCoord(new Coord(+1,-1)));
						Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()+1].viderCellule();
						valide=true;
					}
					//regarde si l'ia peut se déplacer en bas
					case 6: if (!Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].celluleValide() && Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()+1].contiensObstacle()) {
						break;
					}
					else {
						if (Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()+1].contiensMine()) {
							Essai.infoRobotB.get(tmp).subitMine();
						}
						Essai.infoRobotB.get(tmp).setCoordonnee(Essai.infoRobotB.get(tmp).getCoordonnee().ajouterCoord(new Coord(0,+1)));
						Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()-1].viderCellule();
						valide=true;
					}
					//regarde si l'ia peut aller en bas à gauche
					case 7: if (!Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()].celluleValide() && Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()+1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()-1].contiensObstacle()) {
						break;
					}
					else {
						if (Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()+1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()-1].contiensMine()) {
							Essai.infoRobotB.get(tmp).subitMine();
						}
						Essai.infoRobotB.get(tmp).setCoordonnee(Essai.infoRobotB.get(tmp).getCoordonnee().ajouterCoord(new Coord(+1,-1)));
						Plateau.grille[Essai.infoRobotB.get(tmp).getCoordonnee().getPositionX()-1][Essai.infoRobotB.get(tmp).getCoordonnee().getPositionY()+1].viderCellule();
						valide=true;	
					}
					default: break;
					}
				}	
					
			}
		}
		else {
			//action
			
		}
		
		
	}	
	public static void main(String[] args){
	}
 }
