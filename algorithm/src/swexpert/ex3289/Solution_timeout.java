package swexpert.ex3289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_timeout {
	static Map<Integer, List<Integer>> map = new LinkedHashMap<>();
	
	//두개의 집합 내용을 서로 복사
	private static void union(int a, int b) {
		map.get(a).addAll(map.get(b));
		map.get(b).addAll(map.get(a));
	}
	
	//같은 집합인지 확인
	private static int check(int a, int b) {
		if(map.get(a).contains(b)) return 1;
		else return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=1; t<=T; t++) {
			StringBuilder sb = new StringBuilder();	//출력값 저장
			sb.append("#"+t+" ");
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			//arr을 본인값으로 초기화
			List<Integer> tmp;
			for(int i=1; i<=N; i++) {
				tmp = new ArrayList<>();
				tmp.add(i);
				map.put(i, tmp);
			}
			
			int command, a, b;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				
				command = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				if(command==0) {	//합치는 명령어
					union(a, b);
				} else {	//확인하는 명령어
					sb.append(check(a, b));
				}
			}
			
			System.out.println(sb.toString());
			
		}
	}
}
