package ex9095;

import java.io.*;

public class Main {	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] arr = new int[11];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for(int i=4; i<=10; i++) {
			arr[i] = arr[i-1]+arr[i-2]+arr[i-3];
		}
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(arr[n]);
		}
	}
}
