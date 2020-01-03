package ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class EjercicioD {

	private static int[][] wordl;
	private static int[] posFinal = new int[2];

	public static void main(String[] args) {

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {

			while (true) {
				String n = reader.readLine();
				String x = n.replaceAll("\\s", "");
				if (x.equals("0000")) {
					break;
				}

				startApp(n);

			}

		} catch (Exception e) {
			System.out.println("Kaputt!");
		}

	}

	public static void buildWorld(String c) {
		int pos = 0;
		for (int i = wordl.length - 1; i >= 0; i--) {
			for (int j = 0; j < wordl[i].length; j++) {
				wordl[i][j] = Integer.valueOf(String.valueOf(c.charAt(pos)));
				pos++;
				if (pos == c.length()) {
					posFinal[0] = i;
					posFinal[1] = j;
				}
			}
		}

	}

	private static void setWordl(int n) {
		wordl = new int[n][n];
	}

	private static String convertBinary(BigDecimal n) {
		BigInteger bigInteger = new BigInteger(n.toString());
		return bigInteger.toString(2);
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

	private static boolean isfinal(int i, int j) {
		return posFinal[0] == i && posFinal[1] == j;
	}

	private static void startcourse(int x, int y) {
		try {
			// 0 = N | 1 = E | 2 = O  | S = 3
			int dir = 1;
//			!isfinal(wordl.length - x, y - 1)
			while (true) {
				int i = wordl.length - x;
				int j = y - 1;
				int auxX = x;
				int auxY = y;
				
				/*
				System.out.println("pos i -j :" + i + "-" + j);
				System.out.println("Dirección: " + dir);
				System.out.println("Valor : " + wordl[i][j]);
				System.out.println("Pos final " + posFinal[0] + "-" + posFinal[1]);
				
				*/
				if(isfinal(i, j) && dir == 0) {
					break;
				}
				
				// Inicia viendo al norte y se mueve a la derecha
				if (dir == 0 && wordl[i][j] == 1) {
					wordl[i][j] = 0;
					dir = 1;
					if (isfinal(i, j + 1) && dir == 0)
						break;
					y = auxY + 1;
				}
//				Inicia viendo al norte y se mueve a la izquierda
				else if (dir == 0 && wordl[i][j] == 0) {
					wordl[i][j] = 1;
					if (isfinal(i, j - 1) && dir == 0)
						break;
					y = auxY - 1;
					dir = 2;
				}
//				Inicia viendo al este y se mueve a la derecha
				else if (dir == 1 && wordl[i][j] == 1) {
					wordl[i][j] = 0;
					if (isfinal(i + 1, j) && dir == 0)
						break;
					x = auxX - 1;
					dir = 3;
				}
//				Inicia viendo al este y se mueve a la izquierda
				else if (dir == 1 && wordl[i][j] == 0) {
					wordl[i][j] = 1;
					if (isfinal(i - 1, j) && dir == 0)
						break;
					x = auxX + 1;
					dir = 0;
				}
//				Inicia viendo al oeste y se mueve a la derecha
				else if (dir == 2 && wordl[i][j] == 1) {
					wordl[i][j] = 0;
					if (isfinal(i - 1, j) && dir == 0)
						break;
					x = auxX + 1;
					dir = 0;
				}
//				Inicia viendo al oeste y se mueve a la izquierda
				else if (dir == 2 && wordl[i][j] == 0) {
					wordl[i][j] = 1;
					if (isfinal(i + 1, j) && dir == 0)
						break;
					x = auxX - 1;
					dir = 3;
				}
//				Inicia viendo al sur y se mueve a la derecha
				else if (dir == 3 && wordl[i][j] == 1) {
					wordl[i][j] = 1;
					if (isfinal(i, j - 1) && dir == 0)
						break;
					y = auxY - 1;
					dir = 2;
				}
//				Inicia viendo al sur y se mueve a la izquierda
				else if (dir == 3 && wordl[i][j] == 0) {
					wordl[i][j] = 1;
					if (isfinal(i, j + 1) && dir == 0)
						break; 
					y = auxY + 1;
					dir = 1;
				}
				auxX = 0;
				auxY = 0;

			}
			System.out.println("Yes");
		} catch (Exception e) {
			System.out.println("Kaputt!");
		}
	}

	private static void startApp(String n) {
		try {
			String[] data = n.split(" ");
			ArrayList<BigDecimal> a = new ArrayList<>();
			for (int i = 0; i < data.length; i++) {
				a.add(new BigDecimal(String.valueOf(data[i])));
			}
			int sizeWorld = Integer.valueOf(a.get(0).toString());
			setWordl(sizeWorld);
			String c = convertBinary(a.get(1));
//			System.out.println(c);
			c = completeBinary(c, sizeWorld);
//			System.out.println("Tamaño del binario :" +c.length());
			buildWorld(c);
//			System.out.println("Pos final" + posFinal[0] + "-" + posFinal[1]);
			int x = Integer.valueOf(a.get(2).toString());
			int y = Integer.valueOf(a.get(3).toString());
			startcourse(x, y);
		} catch (Exception e) {
			System.out.println("Kaputt!");
		}

	}

}
