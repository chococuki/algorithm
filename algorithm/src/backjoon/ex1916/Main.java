package baekjoon.ex1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, M, min=Integer.MAX_VALUE;
	static boolean[] visited;
	static Map<Integer, List<Edge>> bus = new LinkedHashMap<>();
	
	static class Edge {
		int to, price;

		public Edge(int to, int price) {
			super();
			this.to = to;
			this.price = price;
		}
		
		
	}
	
	private static void make() {
		for(int i=1; i<=N; i++) {
			bus.put(i, new ArrayList<>());
		}
		visited = new boolean[N+1];
	}
	
	private static void find(int now, int end, int price) {
		if(now==end) {
			min = Math.min(min, price);
		}
		
		for(Edge edge:bus.get(now)) {
			if(!visited[edge.to]) {
				visited[edge.to]=true;
				find(edge.to, end, price+edge.price);
				visited[edge.to] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		make();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			bus.get(Integer.parseInt(st.nextToken())).add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		find(start, end, 0);
		
		System.out.println(min);
	}
}
