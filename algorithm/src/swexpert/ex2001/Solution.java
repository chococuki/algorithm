package swexpert.ex2001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N,M;
	static int max;
	static int[][] arr;
	static int[][] tmp;
	static int[][] result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			String[] str;
			str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			arr = new int[N+1][N+1];
			
			for(int i=0; i<N; i++) {
				str = br.readLine().split(" ");
				for(int j=0; j<N; j++) {
					arr[i][j]=Integer.parseInt(str[j]);
				}
			}
			
			tmp = new int[N][N-M+1];
			int t;
			for(int i=0; i<N; i++) {
				for(int j=0; j<(N-M+1); j++) {
					t=0;
					for(int k=j; k<(j+M); k++) {
						t+=arr[i][k];
					}
					tmp[i][j]=t;
//					System.out.print(t+" ");
				}
//				System.out.println();
			}
			
//			System.out.println("----------");
			max=0;
			result = new int[N-M+1][N-M+1];
			for(int j=0; j<(N-M+1); j++) {
				for(int i=0; i<(N-M+1); i++) {
					t=0;
					for(int k=i; k<(i+M); k++) {
						t += tmp[k][j];
					}
					result[i][j]=t;
					max = Math.max(max, t);
				}
			}
			
/*			for(int i=0; i<(N-M+1); i++) {
				for(int j=0; j<(N-M+1); j++) {
					System.out.print(result[i][j]+" ");
				}
				System.out.println();
			}*/
			
			System.out.println("#"+test_case+" "+max);
		}
	}
}
