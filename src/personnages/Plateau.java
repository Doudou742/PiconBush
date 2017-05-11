package personnages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import personnages.Base;
import personnages.Case;
import personnages.Cellule;
import personnages.Coord;
import personnages.Robot;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Plateau extends JPanel{
	// dernier push 20/04 a push
	
	private int largeur;
	private int hauteur;
	private int percentObst; // pourcentages d'obstacles max 50
	public static Cellule[][] grille;
	private ImageIcon[] images;
	private int dimImage;
	
	/**
	 * permet de creer un plateau avec des dimensions et un pourcentage d
	 * obstacle
	 * 
	 * @param larg
	 * @param haut
	 * @param obst
	 */
	public Plateau(int larg, int haut, int obst) {
		grille = new Cellule[larg][haut];
		this.largeur = larg;
		this.hauteur = haut;
		if(obst > 82){
			obst = 80;
		}
		this.percentObst = obst;
	
		
		initGrille();
		initObstacle();
JFrame plateau = new JFrame();
		

		images = new ImageIcon[15];
		images[0]=new ImageIcon("image/herbe.png");
		images[1]=new ImageIcon("image/b1.png");
		images[2]=new ImageIcon("image/b2.png");
		images[3]=new ImageIcon("image/char1.jpg");
		images[4]=new ImageIcon("image/char2.jpg");
		images[5]=new ImageIcon("image/obstacle1.png");
		images[6]=new ImageIcon("image/t1.png");
		images[7]=new ImageIcon("image/t2.png");
		images[8]=new ImageIcon("image/p1.png");
		images[9]=new ImageIcon("image/p2.png");
		images[10]=new ImageIcon("image/o2.png");
		images[11]=new ImageIcon("image/m1.png");

		dimImage = (images[0].getIconHeight() + 2);
		plateau.setTitle("Virtual Wars");
		plateau.setSize(Plateau.grille.length * dimImage + 100, Plateau.grille[0].length * dimImage + 100);
		
		
		plateau.setLocation(50, 50);
		plateau.setLayout(new FlowLayout());
		plateau.setDefaultCloseOperation(3);

		setPreferredSize(new Dimension(Plateau.grille.length * dimImage, Plateau.grille[0].length * dimImage));
		setBackground(Color.LIGHT_GRAY);
		plateau.getContentPane().add(this);
		plateau.setVisible(true);

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Dimension taille = getSize();
		int x = 2;
		int y = 1;
		int lg = 0;
		int col = 0;
		
		g.setColor(Color.white);
		for(int i=0;i<Plateau.grille.length;i++){
			for(int j=0;j<Plateau.grille[0].length;j++){
				 if (Plateau.grille[i][j].contiensMine() && !Essai.equipe && Plateau.grille[i][j].getMine()==1){
					g.drawImage(images[11].getImage(), x, y, null);
					x+=dimImage;
				}else if (Plateau.grille[i][j].contiensMine() && Essai.equipe && Plateau.grille[i][j].getMine()==2){
					g.drawImage(images[11].getImage(), x, y, null);
					x+=dimImage;
				}
				 else if(Plateau.grille[i][j].estBase()==1){
					g.drawImage(images[1].getImage(), x, y, null);
					x+=dimImage;
				}else if(Plateau.grille[i][j].estBase()==2){
					g.drawImage(images[2].getImage(), x, y, null);
					x+=dimImage;
				}else if(Plateau.grille[i][j].contienRobot()){
					if(Plateau.grille[i][j].getUnRobot().getType().equals("Char")){
						if(Plateau.grille[i][j].getUnRobot().getEquipe()==1){
							g.drawImage(images[3].getImage(), x, y, null);
							x+=dimImage;
						}else{
							g.drawImage(images[4].getImage(), x, y, null);
							x+=dimImage;
						}
					}
					if(Plateau.grille[i][j].getUnRobot().getType().equals("Tireur")){
						if(Plateau.grille[i][j].getUnRobot().getEquipe()==1){
							g.drawImage(images[6].getImage(), x, y, null);
							x+=dimImage;
						}else if(Plateau.grille[i][j].getUnRobot().getEquipe()==2){
							g.drawImage(images[7].getImage(), x, y, null);
							x+=dimImage;
						}
					}
					if(Plateau.grille[i][j].getUnRobot().getType().equals("Piegeur")){
						if(Plateau.grille[i][j].getUnRobot().getEquipe()==1){
							g.drawImage(images[8].getImage(), x, y, null);
							x+=dimImage;
						}else if(Plateau.grille[i][j].getUnRobot().getEquipe()==2){
							g.drawImage(images[9].getImage(), x, y, null);
							x+=dimImage;
						}
					}
					
				} 
				else if(Plateau.grille[i][j].contiensObstacle()){
					Random r = new Random();
					if(r.nextInt(101)<50){
					g.drawImage(images[5].getImage(), x, y, null);
					x+=dimImage;
					}else{
						g.drawImage(images[10].getImage(), x, y, null);
						x+=dimImage;
					}
				}
				else {
				g.drawImage(images[0].getImage(), x, y, null);
				x+=dimImage;
				}
			}
			x=2;
			y+=dimImage;
		}
	}
	public void affichage() {
		
		repaint();
	}

	public Cellule getCellule(Coord coord) {
		return Plateau.grille[coord.getPositionX()][coord.getPositionY()];
	}

	public void initObstacle() {
	
		Random rand = new Random();
		ArrayList<Coord> chemin = new ArrayList<Coord>();
		ArrayList<Coord> obstacles = new ArrayList<Coord>();
		
		// base 1
		
		chemin.add(new Coord(0,1));
		chemin.add(new Coord(1,1));
		chemin.add(new Coord(0,0));
		Coord c = new Coord(2,2);
		chemin.add(c);
		chemin.add(new Coord(1,2));
		chemin.add(new Coord(2,1));
		
		// base 2
		chemin.add(new Coord(largeur,hauteur));
		chemin.add(new Coord(largeur -1, hauteur));
		chemin.add(new Coord(largeur, hauteur -1));
		
		while (c.getPositionX() != largeur - 1 || c.getPositionY() != hauteur - 1) {
			Coord init = c;
			if (rand.nextBoolean()) {
				if (c.getPositionX() + 1 <= largeur - 1) {
					c = new Coord(c.getPositionX() + 1, c.getPositionY());
				} else {
					if (c.getPositionY() + 1 <= hauteur - 1) {
						c = new Coord(c.getPositionX(), c.getPositionY() + 1);
					}
				}
			} else {
				if (c.getPositionY() + 1 <= hauteur - 1) {
					c = new Coord(c.getPositionX(), c.getPositionY() + 1);
				} else {
					if (c.getPositionX() + 1 <= largeur - 1) {
						c = new Coord(c.getPositionX() + 1, c.getPositionY());
					}
				}
			}
			
			if (!contient(chemin, c)) {
				chemin.add(new Coord(c.getPositionX(), c.getPositionY()));
			} else {
				c = init;
			}
		}
		
		int nbObstacle = (int) (getSurface() * (percentObst / 100.0));
		
		
		do {
			do {
				c = new Coord(rand.nextInt(largeur), rand.nextInt(hauteur)); //+1 //+1
 			} while(contient(obstacles,c) || contient(chemin,(c)));
			
			grille[c.getPositionX()][c.getPositionY()].addObstacle();
			obstacles.add(new Coord(c.getPositionX(),c.getPositionY()));
			nbObstacle --;
			
		} while(nbObstacle > 0);
		
	}
		
			private boolean contient(List<Coord> liste, Coord c) {
				for (Coord pos : liste) {
					if (pos.getPositionX() == c.getPositionX() && pos.getPositionY()  == c.getPositionY()) {
						return true;
					}
				}
				return false;
			}
			

	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	public int getPercentObst() {
		return percentObst;
	}

	public void setPercentObst(int percentObst) {
		this.percentObst = percentObst;
	}
	
	public int getSurface() {
		return largeur * hauteur;
	}

	public void initGrille() {
		for (int i = 0; i < largeur; i++) {
			for (int j = 0; j < hauteur; j++) {
				if (i == 0 && j == 0) {
					grille[i][j] = new Base(i, j, 1);
				} else if (i == 9 && j == 9) {
					grille[i][j] = new Base(i, j, 2);
				} else {
					grille[i][j] = new Case(i, j);

				}
			}
		}
	}

	

	public void afficherParEquipe(int equipe) {
		if(equipe == 1){
			System.out.println("\t=== Equipe A ===\n");
			
			
		}
		else {
			System.out.println("\t=== Equipe B ===\n");
			
		}
		String res = "\t";

		for (int haut = 0; haut < hauteur; haut++) {
			res += "    " + haut + " ";
		}

		res += "\n";

		

		for (int i = 0; i < hauteur; i++) {
			res += "\t";
			for (int k = 0; k < largeur; k++) {
				res += "+-----";
			}

			

			res += "+" + "\n" + i + "\t";
			for (int j = 0; j < largeur; j++) {

				if (Plateau.grille[i][j].getMine() != 0) {
					if (equipe == 1 && Plateau.grille[i][j].getMine() % 2 != 0) {

						res += "|  " + Plateau.grille[i][j].toString() + "  ";
					}
					else if (equipe == 1 && Plateau.grille[i][j].getMine() % 2 == 0) {
						res += "|     ";
					}
					if (equipe == 2 && Plateau.grille[i][j].getMine() % 2 == 0) {

						res += "|  " + Plateau.grille[i][j].toString() + "  ";
					}
					else if(equipe == 2 && Plateau.grille[i][j].getMine() %2 != 0){
						// sinon ça décalle tout...
						res += "|     ";
					}
				}
				if (Plateau.grille[i][j].getMine() == 0) {
					res += "|  " + Plateau.grille[i][j].toString() + "  ";
				}
			}
			res += "|\n";
		}
		res += "\t";

		for (int k = 0; k < largeur; k++) {
			res += "+-----";
		}
		res += "+";
		System.out.println(res);

	}

	public void addMine(Coord coord, int mine) {
		grille[coord.getPositionX()][coord.getPositionY()].addMine(mine);
	}

	/*
	 * public void sortRobotBase(){
	 * grille[robot.getCoordonnee().getPositionX()][robot.getCoordonnee().
	 * getPositionY()].setUnRobot(robot);
	 * 
	 * }
	 */

	public void addBase(Base b) {
		if (b.getCoordCell().getPositionX() < grille.length && b.getCoordCell().getPositionY() < grille[0].length) {
			grille[b.getCoordCell().getPositionX()][b.getCoordCell().getPositionY()].addBase(b);
		}
	}

	/*
	 * public void addTank(Coord coord) {
	 * grille[coord.getPositionX()][coord.getPositionY()].tank; }
	 */
	public void addRobot(Robot robot) {
		grille[robot.getCoordonnee().getPositionX()][robot.getCoordonnee().getPositionY()].setUnRobot(robot);
	}
	/*
	 * public void addPiegeur(Coord coord) {
	 * grille[coord.getPositionX()][coord.getPositionY()].piegeur; }
	 */

	public void energieJ1() {
		
		System.out.println("\tEquipe A voici l'état de vos robots: \n");

		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille.length; j++) {

				if (grille[i][j].contienRobot() && grille[i][j].getUnRobot().getEquipe() == 1) {
					
					// calcul du % de vie
					int percent = 0;
					if (grille[i][j].getUnRobot() instanceof Tireur) {
						percent = (grille[i][j].getUnRobot().getEnergie() * 100) / Constantes.getEnergieTireur();
					} else if (grille[i][j].getUnRobot() instanceof Piegeur) {
						percent = (grille[i][j].getUnRobot().getEnergie() * 100) / Constantes.getEnergiePiegeur();
					} else {
						percent = (grille[i][j].getUnRobot().getEnergie() * 100) / Constantes.getEnergieTank();
					}

					// Dessin vie [|||||]
					String nrj = "\t[";
					int max = grille[i][j].getUnRobot().getEnergie() / 2;
					for (int k = 0; k < max; k++) {
						nrj += "•";
					}
					nrj += "] ";

					System.out.println("\t[ " + i + "," + j + " ] " + grille[i][j].getUnRobot().getType() + nrj + "~ "
							+ percent + "%" + "\n");

				}
				
			}
		}
	}

	public void energieJ2() {
		System.out.println("\tEquipe B voici l'état de vos robots: \n");
		
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille.length; j++) {

				if (grille[i][j].contienRobot() && grille[i][j].getUnRobot().getEquipe() == 2) {
					
					// calcul du % de vie
					int percent = 0;
					if (grille[i][j].getUnRobot() instanceof Tireur) {
						percent = (grille[i][j].getUnRobot().getEnergie() * 100) / Constantes.getEnergieTireur();
					} else if (grille[i][j].getUnRobot() instanceof Piegeur) {
						percent = (grille[i][j].getUnRobot().getEnergie() * 100) / Constantes.getEnergiePiegeur();
					} else {
						percent = (grille[i][j].getUnRobot().getEnergie() * 100) / Constantes.getEnergieTank();
					}

					// Dessin vie [|||||]
					String nrj = "\t[";
					int max = grille[i][j].getUnRobot().getEnergie() / 2;
					for (int k = 0; k < max; k++) {
						nrj += "•";
					}
					nrj += "] ";

					System.out.println("\t[ " + i + "," + j + " ] " + grille[i][j].getUnRobot().getType() + nrj + "~ "
							+ percent + "%" + "\n");

				}
				
			}
		}
		
	}

}
