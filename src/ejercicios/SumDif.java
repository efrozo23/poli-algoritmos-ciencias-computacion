package ejercicios;

import java.io.*;
import java.util.*;

public class SumDif
{
   public static void main(String[] args) throws IOException
   {
      new SumDif().run();
   }

   StreamTokenizer in;
   PrintWriter out;

   int nextInt() throws IOException
   {
      in.nextToken();
      return (int)in.nval;
   }

   void run() throws IOException
   {
      in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
      out = new PrintWriter(System.out);
      solve();
      out.flush();
   }

   void solve() throws IOException
   {
      int a = nextInt();
      int b = nextInt();
      out.print(a + b);
      out.print(" ");
      out.println(a - b);
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

	public static int basePalindromo(int n) {
		int baseO = 0;

		int maxN = n;
		if(maxN == 1)
			return 2;
		int aux = maxN / 2;
		for (int i = 2; i < maxN; i++) {
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
