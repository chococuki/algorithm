package swexpert.ex3124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static Edge[] edgelist;	//간선 저장 리스트
	static int[] arr;		//부모 저장 리스트
	
	//초기화 함수
	private static void make(int V, int E) {
		edgelist = new Edge[E];
		arr = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			arr[i]=i;
		}
	}
	
	//결합 함수
	private static boolean union(int from, int to) {
		int pfrom = find(from);
		int pto = find(to);
		
		if(pfrom==pto) return false;
		else {
			if(pfrom<pto) arr[pto]=pfrom;
			else arr[pfrom]=pto;
			return true;
		}
	}
	
	//부모 찾는 함수
	private static int find(int n) {
		if(arr[n]==n) return n;
		else return find(arr[n]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int V, E;
		for(int t=1; t<=T; t++) {
			
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			make(V, E);
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				edgelist[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			//가중치로 오름차순 정렬
			Arrays.sort(edgelist);
			
			//정점이 모두 연결될때까지 union
			int cnt=0;
			long result=0;
			for(Edge edge : edgelist) {
				if(union(edge.from, edge.to)) {
					result += edge.weight;
					if(++cnt==V-1) break;
				}
			}
			
			System.out.printf("#%d %d\n", t, result);
			
		}
	}
}
