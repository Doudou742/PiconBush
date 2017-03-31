package personnages;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class ImagePanel extends JPanel  {
    Image image = null;
    public ImagePanel(Image image) {
    	super();
        this.image = image;
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setBackground(Color.BLACK);
        setVisible(true);
        this.repaint();
        
      
    }
    public ImagePanel() {
    	super();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setBackground(Color.BLACK);
        setVisible(true);
        this.repaint();
        
       
    }
    public void setImage(Image image){
        this.image = image;
    }
    public Image getImage(Image image){
        return image;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //paint background
        if (image != null) { //there is a picture: draw it
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            //g.drawImage(image, 0, 0, this); //use image size          
            g.drawImage(image,0,0, width, height, this);
        }
    }
}
