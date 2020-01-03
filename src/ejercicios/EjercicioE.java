package ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class EjercicioE {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
				) {

//			long start = System.currentTimeMillis();
			String line = "";
			while ((line = reader.readLine()) != null && !line.equals("")) {
				int base = basePalindromo(line);
				writer.println(base);
				writer.flush();
			}
//			long elapsedTime = System.currentTimeMillis() - start;
//			float elapsedTimeSec = elapsedTime / 1000F;
////			System.out.println(elapsedTimeSec);
//			writer.print(elapsedTimeSec);
//			writer.flush();
		} catch (Exception e) {
		}

	}

	static boolean isPalindromeInBase(int n, int base) {
		int inverso = 0;
		int temp = n;
		while (temp > 0) {
			inverso = inverso * base + temp % base;
			temp /= base;
		}

		return inverso == n;
	}

	public static int basePalindromo(String n) {
		int baseO = 0;

		int maxN = Integer.parseInt(n);
		if(maxN == 1)
			return 2;
		if(maxN == 2)
			return 3;
		int aux = maxN;
		if(maxN > 10) {
			aux = maxN / 2;
			
		}
		
		for (int i = 2; i <= aux; i++) {
			if (isPalindromeInBase(maxN, i)) {
				baseO = i;
				break;
			}

		}
		if (baseO == 0) {
			baseO = maxN - 1;
		}

		return baseO;
	}

}
