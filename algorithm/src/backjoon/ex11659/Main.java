package backjoon.ex11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	static int sum;
	
	private static void sum(int start, int end) {
		sum = 0;
		for(int i=start-1; i<=end-1; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str;
		str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		arr = new int[N];
		
		str = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		for(int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			sum(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}
	}
}
