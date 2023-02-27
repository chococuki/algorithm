package swexpert.ex7465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static Set<Integer> set;
	
	private static void union(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		
		if(ap==bp) return;
		else {
			if(ap>bp) arr[bp]=ap;
			else arr[ap]=bp;
		}
	}
	
	private static int find(int n) {
		if(arr[n]==n) return n;
		else return find(arr[n]);
	}
	
	private static void check() {
		set = new LinkedHashSet<>();
		for(int i=N; i>0; i--) {
			if(!visited[i]) {
				checkfind(i);
			}
		}
	}
	
	private static void checkfind(int n) {
		visited[n] = true;
		if(arr[n]==n) {
			set.add(n);
			return;
		}
		else {
			checkfind(arr[n]);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1];
			visited = new boolean[N+1];
			
			//arr 본인 값으로 초기화
			for(int i=1; i<=N; i++) {
				arr[i] = i;
			}
			
			int a, b;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			
			check();
			System.out.printf("#%d %d\n", t, set.size());
			
		}
	}
}
