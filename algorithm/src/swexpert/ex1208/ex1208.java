package swexpert.ex1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1208 {
	static int dump;
	static int[] arr;
	
	private static void move(int count) {
		if(dump==count) return;
		int max=0, min=100;
		int maxI=0, minI=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<min) {
				min=arr[i];
				minI=i;
			}
			if(arr[i]>max) {
				max=arr[i];
				maxI=i;
			}
		}
		
		arr[maxI]--;
		arr[minI]++;
		
		move(count+1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case=1; test_case<=10; test_case++) {
			dump = Integer.parseInt(br.readLine());
			
			String[] str = br.readLine().split(" ");
			
			arr = new int[str.length];
			for(int i=0; i<str.length; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			
			move(0);
			
			
			int max=0, min=100;
			for(int i=0; i<arr.length; i++) {
				if(arr[i]<min) {
					min=arr[i];
				}
				if(arr[i]>max) {
					max=arr[i];
				}
			}
			
			System.out.println("#"+test_case+" "+(max-min));
		}
	}
}
