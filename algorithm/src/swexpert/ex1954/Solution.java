package swexpert.ex1954;

import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] arr;
	static boolean[][] full;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	private static void make(int x, int y, int count, int type) {
		if(count == N*N+1) {
			return;
		}
		
		int now_x = x+dx[type];
		int now_y = y+dy[type];
		
		if(now_x<0 || now_x>=N || now_y<0 || now_y>=N || arr[now_y][now_x] != 0) {
			type += 1;
			if(type == 4) type = 0;
			now_x = x+dx[type];
			now_y = y+dy[type];
		}
		
		arr[now_y][now_x] = count;
		make(now_x, now_y, count+1, type);
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int test_case=1; test_case<=T; test_case++) {
			
			N = sc.nextInt();
			
			arr = new int[N][N];
			arr[0][0] = 1;
			full = new boolean[N][N];
			
			make(0, 0, 2, 0);

			System.out.println("#"+test_case);
			for(int[] i:arr) {
				for(int j:i) {
					System.out.print(j+ " ");
				}
				System.out.println();
			}
			
		}
	}
}
