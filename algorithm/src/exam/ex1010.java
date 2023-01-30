package exam;

import java.io.*;

public class ex1010 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt((String) br.readLine());
		
		for(int i=0; i<T; i++) {
			String[] citys = br.readLine().split(" ");
			
			int n = Integer.parseInt(citys[0]);
			int m = Integer.parseInt(citys[1]);

			
			double result = 1.0;
			for(int j=0; j<n; j++) {
				result = result / (1+j);
				result = result * (m-j);
			}

			System.out.println((int)result);
		}
	}
}
