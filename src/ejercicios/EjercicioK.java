package ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EjercicioK {
	
	static String[] k = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	
	public static void main(String... args) throws UnsupportedEncodingException {
		PrintWriter writer  = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
			
			String line = "";
			while ((line = reader.readLine()) != null && !line.equals("")) {
				String[] data = line.split(" ");
				String r = bulidCombinations(data[0], data[1]);
				writer.println(r);
				writer.flush();
			}

		} catch (Exception e) {
			writer.println("");
			writer.flush();
		}finally {
			writer.close();
		}
	}
	
	static String bulidCombinations(String k, String n) {
		int kn = Integer.parseInt(k);
		int nn = Integer.parseInt(n);
		StringBuilder stringBuilder = new StringBuilder();
		if(kn == 1) {
			for (int i = 0; i < nn; i++) {
				stringBuilder.append(EjercicioK.k[kn-1]);
			}
		}else if (kn == 0 && nn == 0) {
			stringBuilder.append(" ");
		}
		return stringBuilder.toString();
	}

}
