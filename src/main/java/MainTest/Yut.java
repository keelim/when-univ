package MainTest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Yut extends JFrame {
	
	int i;
	BufferedImage img = null;
	public Yut() {
		setTitle("윷");
		
		i = 1+(int)(Math.random()*4);
		if(i==1) {
			try {
				img = ImageIO.read(new File("C:\\Users\\h0033\\Desktop\\Comp2-project\\src\\main\\java\\source\\도.png"));
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		if(i==2) {
			try {
				img = ImageIO.read(new File("C:\\Users\\h0033\\Desktop\\Comp2-project\\src\\main\\java\\source\\개.png"));
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		if(i==3) {
			try {
				img = ImageIO.read(new File("C:\\Users\\h0033\\Desktop\\Comp2-project\\src\\main\\java\\source\\걸.png"));
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		if(i==4) {
			try {
				img = ImageIO.read(new File("C:\\Users\\h0033\\Desktop\\Comp2-project\\src\\main\\java\\source\\윷.png"));
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		if(i==5) {
			try {
				img = ImageIO.read(new File("C:\\Users\\h0033\\Desktop\\Comp2-project\\src\\main\\java\\MainTest4\\Yut.java"));
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		
		add(new Yut_Panel());
		pack();
		setVisible(true);
		

	}
	
	public int getI() {
		return i;
	}
	
	class Yut_Panel extends JPanel{

		public void paintComponent(Graphics g) {
				g.drawImage(img, 0,0,null);
		}
		
		public Dimension getPreferredSize() {
			if (img == null) {
				return new Dimension(100,100);
			} else {
				return new Dimension(img.getWidth(null), img.getHeight(null));
			}
		}
		
	}
	
	public static void main(String [] args) {
		new Yut();
	}
	
}
