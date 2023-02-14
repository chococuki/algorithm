package swexpert.ex1233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static Map<Integer, Node> map = new LinkedHashMap<>();
	static boolean istree;
	
	static class Node {
		int left, right;
		String s;
		public Node(int left, int right, String s) {
			super();
			this.left = left;
			this.right = right;
			this.s = s;
		}
	}
	
	public static int math(int a, String s, int b) {
		if(s.equals("+")) {
			return a+b;
		} else if(s.equals("-")){
			return a-b;
		} else if(s.equals("*")) {
			return a*b;
		} else {
			return 0;
		}
	}
	
	public static boolean check(String s) {
		if(s.equals("+")) {
			return true;
		} else if(s.equals("-")){
			return true;
		} else if(s.equals("*")) {
			return true;
		} else if(s.equals("/")){
			return true;
		}
		
		return false;
	}
	
	public static int dfs(int start) {
		int left, right;
		
		if(map.get(start).left != 0) {
			left = dfs(map.get(start).left);
			right = dfs(map.get(start).right);
		} else {
			if(check(map.get(start).s)) {
				istree=false;
				return 0;
			}
			return Integer.parseInt(map.get(start).s);
		}
		return 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int test_case=1; test_case<=10; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			istree = true;
			for(int i=0; i<N; i++) {
				int left=0;
				int right=0;
				st = new StringTokenizer(br.readLine());
				int key = Integer.parseInt(st.nextToken());
				String s = st.nextToken();
				
				if(st.hasMoreTokens()) {
					left = Integer.parseInt(st.nextToken());
					if(st.hasMoreTokens()) {
						right = Integer.parseInt(st.nextToken());
					} else {
						istree=false;
//						System.out.println("no more tk");
					}
				} else {
					if(check(s)) {
						istree=false;
//						System.out.println("math er");
					}
				}
				
				if(istree) {
					map.put(key, new Node(left, right, s));
				}
				
			}
			
			if(istree) {
				System.out.println("#"+test_case+" "+dfs(1));
			} else {
				System.out.println("#"+test_case+" "+0);
			}
		}
	}
}
