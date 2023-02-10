package swexpert.ex1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> que = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=0; t<10; t++) {
			int test_case = Integer.parseInt(br.readLine());
			
			String[] str = br.readLine().split(" ");
			for(int i=0; i<str.length; i++) {
				que.add(Integer.parseInt(str[i]));
			}
			
			int m = 1;
			while(true) {
				if(que.peek()-m>0) {
					que.add(que.poll()-m);
					m++;
					if(m>5) m=1;
				} else {
					que.poll();
					que.add(0);
					break;
				}
//				System.out.println(m+" "+que.toString());
			}
			
			sb.append("#"+test_case+" ");
			while(!que.isEmpty()) {
				sb.append(que.poll()+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
