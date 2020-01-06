package ejercicios;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Langton extends JFrame {
	private JPanel planePanel;
	private static final int ZOOM = 20;

	public Langton(final boolean[][] plane) {
		planePanel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				for (int y = 0; y < plane.length; y++) {
					for (int x = 0; x < plane[0].length; x++) {
						g.setColor(plane[y][x] ? Color.BLACK : Color.WHITE);
						g.fillRect(x * ZOOM, y * ZOOM, ZOOM, ZOOM);
					}
				}
				// mark the starting point
				g.setColor(Color.GREEN);
				g.fillRect(plane[0].length / 2 * ZOOM, plane.length / 2 * ZOOM, ZOOM / 2, ZOOM / 2);
			}
		};
		planePanel.setSize(plane[0].length - 1, plane.length - 1);
		add(planePanel);
		setSize(ZOOM * plane[0].length, ZOOM * plane.length + 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
//		new Langton(runAnt(10, 10));
		runAnt(2, 2, 0, 1,2);
		
	}

	private static void runAnt(int height, int width, int x, int y,int binary) {
		boolean[][] plane = new boolean[height][width];
		int antX = x, antY = y;// start in the middle-ish
		int xChange = 0, yChange = -1; // start moving up
		String xbin = Integer.toBinaryString(binary);
		xbin = completeBinary(xbin, height);
		System.out.println(xbin);
		int pos = 0;
		for (int i = plane.length - 1; i >= 0; i--) {
			for (int j = 0; j < plane[i].length; j++) {
				plane[i][j] = Integer.valueOf(String.valueOf(xbin.charAt(pos))) == 1 ;
				pos++;
			}
		}
		while (true) {
			System.out.println("pos:" + antX+ "-" + antY);
			if (plane[antX][antY]) {
				// turn left
				if (xChange == 0) { // if moving up or down
					xChange = yChange;
					yChange = 0;
				} else { // if moving left or right
					yChange = -xChange;
					xChange = 0;
				}
			} else {
				// turn right
				if (xChange == 0) { // if moving up or down
					xChange = -yChange;
					yChange = 0;
				} else { // if moving left or right
					yChange = xChange;
					xChange = 0;
				}
			}
			plane[antX][antY] = !plane[antX][antY];
			antX += yChange;
			antY += xChange;
		}
	}
	
	private static String completeBinary(String c, int n) {
		StringBuilder stringBuilder = new StringBuilder(c);
		n = (n * n);
		int pos = 0;
		while (stringBuilder.length() != n) {
			stringBuilder.insert(pos, 0);
			pos++;
		}
		return stringBuilder.toString();
	}
}
