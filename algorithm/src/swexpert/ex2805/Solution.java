package swexpert.ex2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int sum;
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	
	private static void find(int x, int y, int size) {
		if(size<0) return;
		
		for(int i=y-size; i<=y+size; i++) {
			visited[x][i] = true;
		}
		
		find(x+1, y, size-1);
		find(x-1, y, size-1);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			String[] str;
			board = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				str = br.readLine().split("");
				for(int j=0; j<N; j++) {
					board[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			int mid = (N-1)/2;
			visited[mid][mid] = true;
			sum = 0;
			find(mid, mid, mid);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j])
						sum += board[i][j];
						
				}
			}
			
			System.out.println("#"+test_case+" "+sum);
		}
	}
}
