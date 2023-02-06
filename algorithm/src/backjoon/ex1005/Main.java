// 미완

package backjoon.ex1005;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int N, K, end;
		String[] str;
		int[] time;
		int[] gotime;
		int[] to = new int[2];
		int[] tmp;
		ArrayList<Integer>[] load;
		
		for(int i=0; i<T; i++) {
			str = br.readLine().split(" ");
			N=Integer.parseInt(str[0]);
			K=Integer.parseInt(str[1]);
			
			str = br.readLine().split(" ");
			time = new int[str.length+1];
			gotime = new int[str.length+1];
			load = new ArrayList[K+2];
			
			for(int k=1; k<=K+1; k++) {
				load[k] = new ArrayList<>();
			}
			for(int k=1; k<=N; k++) {
				time[k] = Integer.parseInt(str[k-1]);
			}
			
			String[] stmp;
			for(int k=1; k<=K; k++) {
				stmp = br.readLine().split(" ");
				load[Integer.parseInt(stmp[0])].add(Integer.parseInt(stmp[1]));
			}
			
			gotime = time.clone();
			
			for(int k=1; k<=K; k++) {
				for(int j:load[k]) {
					if(gotime[j] == 0) {
						System.out.println("time["+j+"]: "+time[j]+" gotime["+k+"]: "+gotime[k]);
						gotime[j] = time[j]+gotime[k];
						System.out.println("gotime["+j+"] "+gotime[j]);
					} else {
						System.out.println("time["+j+"]: "+time[j]+" gotime["+k+"]: "+gotime[k]);
						gotime[j] = Math.max(gotime[j], time[j]+gotime[k]);
						System.out.println("gotime["+j+"] "+gotime[j]);
					}
				}
			}
			
			System.out.print(gotime[Integer.parseInt(br.readLine())]);
		}
	}
}
