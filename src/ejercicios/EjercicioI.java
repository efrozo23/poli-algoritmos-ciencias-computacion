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
				String r = fibonacci(n,2);
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
		BigInteger sum = new BigInteger("0");
		double v = 0;
		for (int i = j; i <= nMax; i++) {
			for (int k = i; k > 0 ; k--) {
				v += tabla.get(k-1).doubleValue();
				sum.add(tabla.get(k).toBigInteger());
				System.out.println("Valor v" + v);
				System.out.println("Valor big" + sum);
			}
			tabla.add(i, new BigDecimal(v));
			sum = new BigInteger("0");
			v = 0;
		}
		tabla.forEach(System.out::print);
		return tabla.get((int) nMax).toString();
	}

}
