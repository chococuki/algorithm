package swexpert.ex9229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] arr;
	static int maxkg;
	
	public static void find(int start, int kg, int cnt) {
		if(kg > M) return;
		else {
			if(cnt==2) {
				maxkg = Math.max(maxkg, kg);
				return;
			}
		}
		
		for(int i=start; i<N; i++) {
			find(i+1, kg+arr[i], cnt+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int t=1; t<=T; t++) {
			maxkg = -1;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			find(0, 0, 0);
			
			System.out.println("#"+t+" "+maxkg);
		}
	}
}
