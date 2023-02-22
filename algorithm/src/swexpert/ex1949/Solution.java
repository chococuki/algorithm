package swexpert.ex1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int max, N, K;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static boolean[][] visited;
	
	public static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	private static void find(Node node, int[][] arr, int cnt, boolean isK) {
		max = Math.max(max, cnt);
		int x = node.x;
		int y = node.y;
		int high = arr[x][y];
		
		int new_x, new_y;
		for(int i=0; i<4; i++) {
			new_x = x+dx[i];
			new_y = y+dy[i];
			
			if(new_x>=0 && new_x<N && new_y>=0 && new_y<N && !visited[new_x][new_y]) {
				
				//현재 위치보다 낮으면 이동
				if(arr[new_x][new_y] < high) {
					visited[new_x][new_y] = true;
					find(new Node(new_x, new_y), arr, cnt+1, isK);
					visited[new_x][new_y] = false;
				} else if(!isK) {	//현재 위치와 같거나 높을때 깎은적 없으면
					if(arr[new_x][new_y]-high < K) {	//최소값으로 깎음
						int tmp = arr[new_x][new_y]-high+1;
						arr[new_x][new_y] -= tmp;
						visited[new_x][new_y] = true;
						find(new Node(new_x, new_y), arr, cnt+1, true);
						visited[new_x][new_y] = false;
						arr[new_x][new_y] += tmp;
					}
				}

			}
		}
	}
	
//	private static void print(int[][] arr) {
//		for(int[] ar : arr) System.out.println(Arrays.toString(ar));
//		System.out.println();
//	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			visited = new boolean[N][N];
			
			int tmp=0, max=0;
			List<Node> top = new ArrayList<>();	//고점 저장 리스트
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					tmp = Integer.parseInt(st.nextToken());
					arr[i][j] = tmp;
					if(tmp>max) {
						max = tmp;
						top = new ArrayList<>();
						top.add(new Node(i, j));
					} else if(tmp==max) {
						top.add(new Node(i, j));
					}
				}
			}
			
			int result = Integer.MIN_VALUE;
			Solution.max = 0;
			//고점에서 시작
			for(Node n : top) {
//				System.out.println("--------------------");
//				System.out.println(n);
				visited[n.x][n.y] = true;
				find(n, arr, 1, false);
				visited[n.x][n.y] = false;
				result = Math.max(result, Solution.max);
			}
			
			System.out.printf("#%d %d\n", t, result);
		}
	}
}
