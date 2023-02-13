package swexpert.ex1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list;
		
		
		for(int test_case=1; test_case<=10; test_case++) {
			list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(str[i]));
			}
			
			N = Integer.parseInt(br.readLine());
			str = br.readLine().split(" ");
			int index = 0;
			for(int i=0; i<N; i++) {
				index++;
	//			System.out.println("start: "+str[index]);
				int start = Integer.parseInt(str[index++]);
	//			System.out.println("cnt: "+str[index]);
				int cnt = Integer.parseInt(str[index++]);
				for(int j=start; j<(start+cnt); j++) {
	//				System.out.println(list);
					list.add(j, Integer.parseInt(str[index++]));
				}
				
			}
			sb.append("#"+test_case+" ");
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
