package MainTest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

//어차피 클라이언트 안에서 게임을 실행 하는 것이여서 그렇게 서버 측에서는 신경을 쓸 필요가 없다.
// 그냥 끊기면 끊긴 것을 확인하고 오류만 수정을 하면 된다.
public class Yut extends JFrame {
	BufferedImage img = null;
	private int send_Yut_num;

	public Yut() {
		setTitle("윷");
		setResizable(false);
		int yut_num = (int) (Math.random() * 16);
		if (yut_num < 4) { 
			try {
				img = ImageIO.read(new File("source/도.png"));
				this.send_Yut_num = 1;
			} catch (IOException e) {
				System.out.println(e.getMessage());
				
				System.exit(0);
			}
		} else if (yut_num < 10) {
			try {
				img = ImageIO.read(new File("source/개.png"));
				this.send_Yut_num = 2;
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		} else if (yut_num < 14) {
			try {
				this.send_Yut_num = 3;
				img = ImageIO.read(new File("source/걸.png"));
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		} else if (yut_num < 15) {
			try {
				img = ImageIO.read(new File("source/윷.png"));
				this.send_Yut_num = 4;
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		} else if (yut_num < 16) {
			try {
				img = ImageIO.read(new File("source/모.png"));
				this.send_Yut_num = 5;
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
			if (img == null)
				return new Dimension(100, 100);
			else
				return new Dimension(img.getWidth(null), img.getHeight(null));
		}
	}
}
