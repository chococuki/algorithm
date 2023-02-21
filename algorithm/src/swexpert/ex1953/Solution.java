package swexpert.ex1953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int N, M, R, C, L;
	static String[] str;
	static String[][] arr;
	static boolean[][] visited;
	static Queue<Node> que = new LinkedList<>();
	
	public static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
	}
	
	private static void tunnel(int cnt) {
		if(cnt == L) return;
		else {
			Queue<Node> tmp = new LinkedList<>(que);
			que = new LinkedList<>();
			
			int x = 0, y=0;
			Node node = null;
//			System.out.println(cnt);
			while(!tmp.isEmpty()) {
				node = tmp.poll();
//				System.out.println(node);
				x = node.x;
				y = node.y;
				
				switch(arr[x][y]) {
				
				case "1":
					check(x, y, "up");
					check(x, y, "down");
					check(x, y, "right");
					check(x, y, "left");
					break;
				case "2":
					check(x, y, "up");
					check(x, y, "down");
					break;
				case "3":
					check(x, y, "right");
					check(x, y, "left");
					break;
				case "4":
					check(x, y, "up");
					check(x, y, "right");
					break;
				case "5":
					check(x, y, "right");
					check(x, y, "down");
					break;
				case "6":
					check(x, y, "left");
					check(x, y, "down");
					break;
				case "7":
					check(x, y, "up");
					check(x, y, "left");
					break;
				}
				arr[x][y] = "0";
			}
//			System.out.println();
			tunnel(cnt+1);
		}
		
	}
	

	public static void check(int x, int y, String rot) {
		
		String tmp=null;
		Node node;
		try {
			if(rot.equals("up")) {
				tmp = arr[x-1][y];
				if(visited[x-1][y] || tmp.equals("0") || tmp.equals("3") || tmp.equals("4") || tmp.equals("7")) {
					return;
				}
				node = new Node(x-1, y);
				if(!visited[x-1][y]) {
					visited[x-1][y] = true;
					que.add(node);
				}
			} else if(rot.equals("down")) {
				tmp = arr[x+1][y];
				if(visited[x+1][y] || tmp.equals("0") || tmp.equals("3") || tmp.equals("5") || tmp.equals("6")) {
					return;
				}
				node = new Node(x+1, y);
				if(!visited[x+1][y]) {
					visited[x+1][y] = true;
					que.add(node);
				}
			} else if(rot.equals("right")) {
				tmp = arr[x][y+1];
				if(visited[x][y+1] || tmp.equals("0") || tmp.equals("2") || tmp.equals("4") || tmp.equals("5")) {
					return;
				}
				node = new Node(x, y+1);
				if(!visited[x][y+1]) {
					visited[x][y+1] = true;
					que.add(node);
				}
			} else {
				tmp = arr[x][y-1];
				if(visited[x][y-1] || tmp.equals("0") || tmp.equals("2") || tmp.equals("6") || tmp.equals("7")) {
					return;
				}
				node = new Node(x, y-1);
				if(!visited[x][y-1]) {
					visited[x][y-1] = true;
					que.add(node);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			return;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			str = br.readLine().split(" ");
			
			N = Integer.parseInt(str[0]);
			M = Integer.parseInt(str[1]);
			R = Integer.parseInt(str[2]);
			C = Integer.parseInt(str[3]);
			L = Integer.parseInt(str[4]);
			
			que = new LinkedList<>();
			arr = new String[N][M];
			visited = new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine().split(" ");
			}
			
			visited[R][C] = true;
			que.offer(new Node(R, C));
			tunnel(1);
			
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j]) cnt++;
				}
			}
			
			System.out.printf("#%d %d\n", t, cnt);
		}
	}
}
