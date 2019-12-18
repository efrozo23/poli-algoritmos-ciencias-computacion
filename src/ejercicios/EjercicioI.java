package ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class EjercicioI {

	public static void main(String[] arg) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {

			while (true) {
				String n = reader.readLine();
				if (n == null || n.isEmpty())
					break;
				String r = fibonacci(n, 2);
				System.out.println("Valor final");
				System.out.println("--->" + r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String fibonacci(String n, int j) {
		BigDecimal bigDecimal = new BigDecimal(n);
		long nMax = Long.valueOf(bigDecimal.toString()) % 1000000009L;
		ArrayList<BigDecimal> tabla = new ArrayList<>();
		tabla.add(BigDecimal.ZERO);
		tabla.add(BigDecimal.ONE);
		tabla.add(BigDecimal.ONE);
		BigInteger sum = new BigInteger("0");
		double v = 0;

		int pivot = j;
		int x = 0;
		int[] a = new int[Integer.valueOf(n) + 1];
		a[0] = 0;
		a[1] = 1;
		for (int i = 1; i <= nMax; i++) {
			for (int k = 0; k <= j; k++) {
				if ((i - k) < 0) {
					break;
				}
				x += a[i - k];
			}
			a[i] = (x % 1000000009);
			x = 0;
		}
		for (int i = 1; i < a.length; i++) {
			System.out.println("Valor ok: " + a[i]);

		}

		return "" + a[Integer.valueOf(n)];
	}

}
