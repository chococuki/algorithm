package backjoon.ex17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class TimeOut {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> que = new LinkedList<Integer>();
		Queue<Integer> tmp;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String[] str = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			que.add(Integer.parseInt(str[i]));
		}
		
		int max=0;
		int now;
		while(!que.isEmpty()) {
			now = que.poll();
			if(now==max) {
				max=0;
			}
			tmp = new LinkedList<>(que);
			
			int result = -1;
			if(max==0) {
				while(!tmp.isEmpty()) {
					int t = tmp.poll();
					if(t>now) {
						max = t;
						result = t;
						break;
					}
				}
			} else {
				result = max;
			}
			sb.append(result+" ");
		}
		System.out.println(sb.toString());
			
	}
}
