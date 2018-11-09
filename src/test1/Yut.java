package test1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Yut extends JFrame {
	BufferedImage img = null;

	public Yut() {
		setTitle("윷");

		int i = 1 + (int) (Math.random() * 4);
		if (i == 1) {
			try {
				img = ImageIO.read(new File("도.png"));
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		if (i == 2) {
			try {
				img = ImageIO.read(new File("개.png"));
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		if (i == 3) {
			try {
				img = ImageIO.read(new File("걸.png"));
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		if (i == 4) {
			try {
				img = ImageIO.read(new File("윷.png"));
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		if (i == 5) {
			try {
				img = ImageIO.read(new File("모.png"));
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}
		JPanel p = new Yut_Panel();
		add(p);
		pack();
		setVisible(true);

	}

	class Yut_Panel extends JPanel {

		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}

		public Dimension getPreferredSize() {
			if (img == null) {
				return new Dimension(100, 100);
			} else {
				return new Dimension(img.getWidth(null), img.getHeight(null));
			}
		}

	}
}
