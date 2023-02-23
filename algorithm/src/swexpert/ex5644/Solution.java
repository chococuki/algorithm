package swexpert.ex5644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] arrA, arrB;
	static List<List<Integer>> bcA, bcB;
	static List<List<List<Integer>>> board;
	static Map<Integer, Integer> bcPower = new LinkedHashMap<Integer, Integer>();;
	static boolean[][] bcset;
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0, 0, 1, 0, -1};
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
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	private static void setBC(Node node, int c, int p) {
		bcset = new boolean[10][10];
		board.get(node.x).get(node.y).add(p);
		bcset[node.x][node.y] = true;
		que.add(node);
		
		Node tmp;
		while(!que.isEmpty()) {
			tmp = que.poll();
			int new_x, new_y;
			for(int i=1; i<=4; i++) {
				new_x = tmp.x+dx[i];
				new_y = tmp.y+dy[i];
				
				if(new_x>=0 && new_x<10 && new_y>=0 && new_y<10 ) {
					if(((Math.abs(new_x-node.x)+Math.abs(new_y-node.y))<=(c))) {
						if(!bcset[new_x][new_y]) {
							bcset[new_x][new_y] = true;
							board.get(new_x).get(new_y).add(p);
							que.add(new Node(new_x, new_y));
						}
					}
				}
			}
		}
	}
	
	private static List<List<Integer>> move(int now_x, int now_y, int[] arr) {
		List<List<Integer>> tmp = new LinkedList<>();
		
		tmp.add(board.get(now_x).get(now_y));
		
		for(int i=0; i<arr.length; i++) {
			now_x = now_x+dx[arr[i]];
			now_y = now_y+dy[arr[i]];
			
			tmp.add(board.get(now_x).get(now_y));
		}
		
		return tmp;
	}
	
	private static int compare(List<List<Integer>> bcA, List<List<Integer>> bcB) {
		int result = 0;
		
		for(int i=0; i<bcA.size(); i++) {
			//둘다 비었을때
			if(bcA.get(i).isEmpty() && bcB.get(i).isEmpty()) {
//				System.out.print(result+" ");
				continue;
			} else if(bcA.get(i).isEmpty()) {	//A가 비었을떄
				result += max(bcB.get(i));
			} else if(bcB.get(i).isEmpty()) {	//B가 비었을때
				result += max(bcA.get(i));
			} else {	//둘다 범위 안에 있을 경우
//				System.out.println(bcA.get(i));
//				System.out.println(bcB.get(i));
				
				int maxdcA = maxdc(bcA.get(i));
				int maxdcB = maxdc(bcB.get(i));
				int maxA = max(bcA.get(i));
				int maxB = max(bcB.get(i));
				
				if(maxdcA==maxdcB) {
					bcA.get(i).remove(bcA.get(i).indexOf(maxdcA));
					int tmpA = max(bcA.get(i));
					bcA.get(i).add(maxdcA);
					
					bcB.get(i).remove(bcB.get(i).indexOf(maxdcB));
					int tmpB = max(bcB.get(i));
					bcB.get(i).add(maxdcB);
					
//					System.out.println(Math.max(maxA+tmpB, tmpA+maxB));
					result += Math.max(maxA+tmpB, tmpA+maxB);
				} else {
					result += (maxA+maxB);
				}
				
			}
//			System.out.print(result+" ");
		}
		
		
		return result;
	}
	
	private static int max(List<Integer> bc) {
		int result = 0;
		
		for(int i=0; i<bc.size(); i++) {
			result = Math.max(result, bcPower.get(bc.get(i)));
		}
		
		return result;
	}
	
	private static int maxdc(List<Integer> bc) {
		int result = 0;
		int index = 0;
		
		for(int i=0; i<bc.size(); i++) {
			if(result < bcPower.get(bc.get(i))) {
				result = bcPower.get(bc.get(i));
				index = i;
			}
		}
		
		return bc.get(index);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
	
		for(int t=1; t<=T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			arrA = new int[M];
			arrB = new int[M];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				arrA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				arrB[i] = Integer.parseInt(st.nextToken());
			}
			
			
			board = new LinkedList<>();
			for(int i=0; i<10; i++) {
				board.add(new LinkedList<>());
				for(int j=0; j<10; j++) {
					board.get(i).add(new LinkedList<>());
				}
			}
			
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				setBC(new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1), Integer.parseInt(st.nextToken()), i+1);
				bcPower.put(i+1, Integer.parseInt(st.nextToken()));
			}
			
			bcset = new boolean[10][10];
			bcA = move(0, 0, arrA);
			bcB = move(9, 9, arrB);
			
//			System.out.println(bcA);
//			System.out.println(bcB);
			
			int result = compare(bcA, bcB);
			
			System.out.printf("#%d %d\n",t , result);
		}
	}
}
