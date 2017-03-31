package personnages;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class TestIhm extends JFrame{

	private BufferedImage getImage(String filename) {
		// This time, you can use an InputStream to load
		try {
		        // Grab the InputStream for the image.                    
		        InputStream in = getClass().getResourceAsStream(filename);

		    // Then read it in.
		    return ImageIO.read(in);
		} catch (IOException e) {
		    System.out.println("L'image n'a pu être chargé.");
		    //System.exit(1);
		}
		    return null;
	}
	
	public void def() {
		ImagePanel image =null;
		BufferedImage img = getImage("virtualban.jpg");
		image = new ImagePanel(img);
		if(image != null){
			
			this.add(image);
			image.repaint();
			
		}
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	this.dispose();
	}
	
	public static void main(String[] arg) {
		TestIhm ihm = new TestIhm();
		ihm.def();
	}
	
}
