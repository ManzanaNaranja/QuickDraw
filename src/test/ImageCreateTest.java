package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageCreateTest {

	public static void main(String[] args) {
		BufferedImage b = new BufferedImage(200,200, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = b.createGraphics();
		g2d.setColor(Color.black);
	    g2d.fillRect(0, 0, 200, 200);
	    g2d.setColor(Color.white);
	    for(int i = 0; i < b.getWidth(); i++) {
	    	for(int j = 0; j < b.getHeight(); j++) {
	    		if(j % 2 != i%2) {
	    			g2d.drawRect(j, i, 0, 0);
	    		}
	    	}
	    }
        
        File file = new File("./images/testimg.png");
        try {
			ImageIO.write(b, "png", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
