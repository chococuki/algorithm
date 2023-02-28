package swexpert.ex1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static Map<Integer, List<Integer>> callList;
	static boolean[] iscall;
	
	//비상 연락망 초기화 함수
	private static void make(int n) {
		callList = new LinkedHashMap<>();
		for(int i=1; i<=n; i++) {
			callList.put(i, new ArrayList<>());
		}
		
		iscall = new boolean[n+1];
	}
	
	//비상연락망 추가 함수
	private static void add(int from, int to) {
		callList.get(from).add(to);
	}
	
	//비상 연락 함수
	private static int call(int start) {
		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> tmp;
		
		que.add(start);
		iscall[start] = true;
		
		int maxnum = start;
		while(!que.isEmpty()) {
			tmp = new LinkedList<>(que);
			que = new LinkedList<>();
			
			int now;
			if(!tmp.isEmpty()) maxnum=tmp.peek();	//다음에 전화할 사람이 있으면 maxnum 새로 시작
//			System.out.println("-------------------");
			while(!tmp.isEmpty()) {
				now = tmp.poll();
				maxnum = Math.max(maxnum, now);
//				System.out.print(now+" -> ");
				for(int i:callList.get(now)) {
					if(!iscall[i]) {
						iscall[i] = true;
						que.add(i);
//						System.out.print(i+" ");
					}
				}
//				System.out.println();
			}
		}
		return maxnum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int length, start;
		for(int t=1; t<=10; t++) {
			make(100);
			
			st = new StringTokenizer(br.readLine());
			
			length = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			int from, to;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<length/2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				
				add(from, to);
			}
			
			int result = call(start);
			
			System.out.printf("#%d %d\n",t , result);
			
		}		
	}
}
