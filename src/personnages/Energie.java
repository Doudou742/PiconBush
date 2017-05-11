/**
 * 
 */
package personnages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Louis
 *
 */
public class Energie extends JPanel {

	JFrame jf = new JFrame();
	public Energie(){
		jf.setTitle("Energie");
		jf.setSize(250,600);
		
		jf.setLocation(10, 10);
		this.setBackground(Color.blue);
		jf.setContentPane(this);
		jf.setDefaultCloseOperation(3);
		jf.setVisible(true);
		jf.toFront();

	}
	
	public void paintComponent(Graphics g) {
		int x = 20;
		int y = 20;
		
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0,0,250,600);
		Font myFont= new Font("Sans Serif",1,17);
		Font myFont2 = new Font("Sans Serif",1,25);
		g.setColor(Color.white);
		g.setFont(myFont2);
		g.drawString("Equipe 1 ", 60, y+10);
		y+=40;
		for(Robot r : Essai.infoRobotA){
			g.setColor(Color.WHITE);
			g.setFont(myFont);
			g.drawString("Energie du "+r.getType() + " " + r.getCoordonnee().toString(), x,y);
			y+=10;
			g.setColor(Color.GREEN);
			g.drawRect(x, y, 200, 20);
			double pourc;
			int vie;
			if(r.getType().equals("Tireur")){
				pourc=r.getEnergie()/40.0;
				vie=(int)(pourc*100);
				
			}else if(r.getType().equals("Piegeur")){
				pourc=r.getEnergie()/50.0;
				vie=(int)(pourc*100);
			}else{
				pourc=r.getEnergie()/60.0;
				vie=(int)(pourc*100);
			}
			g.fillRect(x, y, vie*2, 20);
			g.setColor(Color.BLACK);
			g.drawString(vie+" %",100,y+15);
			
			y+=40;
			
		}
		y+=10;
		g.setColor(Color.white);
		g.setFont(myFont2);
		g.drawString("Equipe 2 ", 60, y);
		y+=25;
		for(Robot r : Essai.infoRobotB){
			
			
			g.setFont(myFont);
			g.setColor(Color.WHITE);
			g.drawString("Energie du "+r.getType() + " " + r.getCoordonnee().toString(), x,y);
			y+=10;
			g.setColor(Color.GREEN);
			g.drawRect(x, y, 200, 20);
			double pourc;
			int vie;
			if(r.getType().equals("Tireur")){
				pourc=r.getEnergie()/40.0;
				vie=(int)(pourc*100);
				
			}else if(r.getType().equals("Piegeur")){
				pourc=r.getEnergie()/50.0;
				vie=(int)(pourc*100);
			}else{
				pourc=r.getEnergie()/60.0;
				vie=(int)(pourc*100);
			}
			g.fillRect(x, y, vie*2, 20);
			g.setColor(Color.BLACK);
			g.drawString(vie+" %",100,y+15);
			
			y+=40;
			
		}
		
		
		
	}
	public void affichage(){
		repaint();
	}
	
}
