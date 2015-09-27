package net.richardsprojects.TheBakery;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;


public class Loader {

	public static Image loadImage(String imageName, JPanel jp) {
		Image image = null;
					
		if (jp != null) {
			// Locate and load the image
			URL fileLocation= jp.getClass().getResource(imageName);
			image = Toolkit.getDefaultToolkit().getImage(fileLocation); 

			System.out.println("Loading: " + imageName);
			
			//System.out.println(jp.getClass().getResource(imageName).getFile());
			
			// Now prepare it to be used
			jp.prepareImage(image, null);
			}
			return image;	
		}



}
