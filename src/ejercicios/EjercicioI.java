package ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class EjercicioI {

	public static void main(String[] arg) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));) {

			String line = "";
			while ((line = reader.readLine()) != null && !line.equals("")) {
				String[] data = line.split(" ");
				String r = fibonacci(Long.parseLong(data[0]));
				writer.println(r);
				writer.flush();
			}

		} catch (Exception e) {

		}
	}

	static String fibonacci(long n) {
		long h, i, j, k, aux;
		i = 1;
		h = i;
		k = 0;
		j = k;
		while (n > 0) {
			if (n % 2 != 0) {
				aux = h * j;
				j = h * i + j * k + aux;
				i = i * k + aux;
			}
			aux = h * h;
			h = 2 * h * k + aux;
			k = k * k + aux;
			n = n / 2;
		}
		return String.valueOf(j);
	}

	public static String fibonacci(String n, int j) {
		BigDecimal bigDecimal = new BigDecimal(n);
		long nMax = Long.valueOf(bigDecimal.toString());
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
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

		return "" + a[Integer.valueOf(n)];
	}

}
