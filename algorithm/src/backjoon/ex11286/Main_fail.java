package backjoon.ex11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_fail {
	static int index;
	static int[] hip = new int[100001];
	static StringBuilder sb = new StringBuilder();
	
	private static void add(int num) {
		hip[++index] = num;
		
		int tindex = index;
		int tmp;
		while(tindex > 1) {
			if(Math.abs(hip[tindex/2]) > Math.abs(hip[tindex])) {
				tmp = hip[tindex/2];
				hip[tindex/2] = hip[tindex];
				hip[tindex] = tmp;
				tindex /= 2;
			} else if(Math.abs(hip[tindex/2]) == Math.abs(hip[tindex])) {
				if(hip[tindex/2] < hip[tindex]) {
					break;
				}
				tmp = hip[tindex/2];
				hip[tindex/2] = hip[tindex];
				hip[tindex] = tmp;
				tindex /= 2;
			} else {
				break;
			}
		}
	}
	
	private static void remove() {
		if(index == 0) {
			sb.append(0+"\n");
			return;
		}
		else sb.append(hip[1]+"\n");
		
		hip[1] = hip[index--];
		hip[index+1] = 0;
		
		int tindex = 1;
		int tmp;
		while (tindex*2 <= index) {
			if(Math.abs(hip[tindex*2]) == Math.abs(hip[tindex*2+1])) {
				if(hip[tindex*2] < hip[tindex]) {
					if(hip[tindex*2] <= hip[tindex*2+1]) {
						tmp = hip[tindex];
						hip[tindex] = hip[tindex*2];
						hip[tindex*2] = tmp;
						tindex = tindex*2;
					} else {
						tmp = hip[tindex];
						hip[tindex] = hip[tindex*2+1];
						hip[tindex*2+1] = tmp;
						tindex = tindex*2+1;
					}
				} else break;
			} else if(Math.abs(hip[tindex*2]) < Math.abs(hip[tindex*2+1]) || hip[tindex*2+1]==0) {
				if((Math.abs(hip[tindex]) > Math.abs(hip[tindex*2])) || (hip[tindex] > hip[tindex*2])) {
					tmp = hip[tindex];
					hip[tindex] = hip[tindex*2];
					hip[tindex*2] = tmp;
					tindex = tindex*2;
				} else break;
			} else {
				if ((Math.abs(hip[tindex]) > Math.abs(hip[tindex*2+1])) || (hip[tindex] > hip[tindex*2+1])) {
					tmp = hip[tindex];
					hip[tindex] = hip[tindex*2+1];
					hip[tindex*2+1] = tmp;
					tindex = tindex*2+1;
				} else break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int cmd;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cmd = Integer.parseInt(st.nextToken());
			
			if(cmd != 0) {
				add(cmd);
			} else {
				remove();
			}

//			for(int j=1; j<=index; j++) {
//				System.out.print(hip[j]+" ");
//			}
//			System.out.println();
		}
		
		System.out.println(sb.toString());
	}
}
