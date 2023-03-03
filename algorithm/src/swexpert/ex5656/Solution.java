package swexpert.ex5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, W, H, result = Integer.MAX_VALUE;
	static int[][] arr;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static Queue<Node> que = new LinkedList<>();
	
	static class Node {
		int x, y, damage;

		public Node(int x, int y, int damage) {
			super();
			this.x = x;
			this.y = y;
			this.damage = damage;
		}
		
	}
	
	//구슬 위치 정하는 함수
	private static void play(int cnt, int[][] arr) {
		if(cnt==N) {
			result = Math.min(result, count(arr));
			return;
		}
		
		for(int i=0; i<W; i++) {
			play(cnt+1, drop(i, copy(arr)));
		}
	}
	
	//구슬이 떨어지며 제일 위쪽 블럭값 저장
	private static int[][] drop(int i, int[][] arr) {
		int x=0;
		
		while(x != H) {
			if(arr[x][i] != 0) {
				//damage가 1이 아니면 que에 저장
				if(arr[x][i] != 1)
					que.add(new Node(x, i, arr[x][i]));
				arr[x][i]=0;
				break;
			}
			x++;
		}
		//더이상의 폭발이 없을때까지 반복
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			for (int j = 0; j < 4; j++) {
				for (int d = 0; d < now.damage; d++) {
					int new_x = now.x+dx[j]*d;
					int new_y = now.y+dy[j]*d;
					
					if(new_x>=0 && new_x<H && new_y>=0 && new_y<W) {
						if(arr[new_x][new_y] != 1 && arr[new_x][new_y] != 0) {
							que.add(new Node(new_x, new_y, arr[new_x][new_y]));
						}
						arr[new_x][new_y]=0;
					}
				}
			}
		}
		return down(arr);
	}
	
	//블럭이 다 터지고 난뒤 남은 블럭을 아래로 
	private static int[][] down(int[][] arr) {
		Queue<Integer> tmp = new LinkedList<>();
		
		for (int i = 0; i < W; i++) {
			for (int j = H-1; j >= 0; j--) {
				if(arr[j][i] != 0) {
					tmp.add(arr[j][i]);
					arr[j][i]=0;
				}
			}
			int size = tmp.size();
			for (int j = 0; j < size; j++) {
				arr[H-j-1][i] = tmp.poll();
			}
		}
		return arr;
	}
	
	//남은 블럭 카운트 함수
	private static int count(int[][] arr) {
		int cnt=0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(arr[i][j] != 0) cnt++;
			}
		}
		return cnt;
	}
	
	//배열 복사 함수
	private static int[][] copy(int[][] arr){
		int[][] tmp = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		
		return tmp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//구슬 갯수
			W = Integer.parseInt(st.nextToken());	//y
			H = Integer.parseInt(st.nextToken());	//x
			
			arr = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			play(0, arr);
			
			System.out.printf("#%d %d\n", t, result);
		}
	}
}
