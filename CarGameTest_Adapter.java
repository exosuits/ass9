package ass9;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {
	BufferedImage img = null;
	int img_x = 0, img_y = 0;
	public MyPanel() {
	try {
		img = ImageIO.read(new File("car.gif"));
	} catch (IOException e) {
		System.out.println("no image");		
		System.exit(1);
	}
	addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
			img_x = e.getX();
			img_y = e.getY();
			repaint();
		}
	});
}

public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(img, img_x, img_y, null);
}
}
public class CarGameTest_Adapter extends JFrame {
public CarGameTest_Adapter() {
	setSize(300, 300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	add(new MyPanel());
	setVisible(true);
}
public static void main(String[] args) {
	CarGameTest_Adapter s = new CarGameTest_Adapter();
}
}

