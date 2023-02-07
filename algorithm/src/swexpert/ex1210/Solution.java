package swexpert.ex1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static String[][] board;
	static boolean[][] visited;
	static int goal;
	static int start;
	static int size = 100;
	static int[] dy = {-1, 1, 0};
	static int[] dx = {0, 0, -1};
	
	private static void run(int x, int y) {
		for(int i=0; i<dx.length; i++) {
			int now_x = x+dx[i];
			int now_y = y+dy[i];
			if(now_x >= 0 && now_x < size && now_y >= 0 && now_y < size && 
					!visited[now_x][now_y] && board[now_x][now_y].equals("1")) {
				visited[now_x][now_y] = true;
				
				if(now_x==0) {
					start = now_y;
					return;
				}
				
				run(now_x, now_y);
				break;
			}
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case;
		String[] str;
		
		for(int t=0; t<10; t++) {
			test_case = Integer.parseInt(br.readLine());
			
			board = new String[size][size];
			for(int i=0; i<size; i++) {
				str = br.readLine().split(" ");
				for(int j=0; j<size; j++) {
					board[i][j] = str[j];
					if(board[i][j].equals("2"))
						goal = j;
				}
			}
			
			visited = new boolean[size][size];
			visited[99][goal] = true;
			run(99, goal);
			
			System.out.println("#"+test_case+" "+start);
		}
	}
}
