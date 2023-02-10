package backjoon.ex2023;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int n;
	static boolean[] numbers;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static void findprime(int end) throws IOException {
		for(int i=2; i<end; i++) {
			if(!numbers[i]) {
				if(i<Math.pow(10, n) && i>=Math.pow(10, n-1)) {
					check(i);
				}
				for(int k=(i+i); k<end; k+=i) {
					numbers[k]=true;
				}
			}
		}
	}
	
	private static void check(int prime) throws IOException {
		int tmp = prime;
		while(((int)(tmp/10))>=1) {
			tmp = ((int)(tmp/10));
			if(numbers[tmp]) return;
		}
		System.out.println(prime);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		numbers = new boolean[(int) Math.pow(10, n)+1];
		numbers[1] = true;
		
		findprime((int) Math.pow(10, n));
		

//		System.out.println("-----");
//		bw.flush();
//		bw.close();
	}
}
