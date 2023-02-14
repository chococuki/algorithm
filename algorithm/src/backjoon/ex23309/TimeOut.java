package backjoon.ex23309;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class TimeOut {
	static int N, M;
	static Deque<String> que = new LinkedList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static void find(String s) {
		while(!que.peekFirst().equals(s)) {
			que.addLast(que.pollFirst());
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		str = br.readLine().split(" ");
		for(String s:str) {
			que.addLast(s);
		}
		for(int i=0; i<M; i++) {
			str = br.readLine().split(" ");
			find(str[1]);
			switch (str[0]){
			case "BN":
				que.add(que.poll());
				bw.append(que.peek());
				que.add(str[2]);
				break;
			case "BP":
				bw.append(que.peekLast());
				que.add(str[2]);
				break;
			case "CN":
				que.add(que.poll());
				bw.append(que.poll());
				break;
			case "CP":
				bw.append(que.pollLast());
				break;
			}
			bw.append("\n");
		}
		bw.flush();
		bw.close();
	}
}
