package backjoon.ex13414;

import java.io.*;
import java.util.*;

public class timeout_list {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		
		int maxStudent = Integer.parseInt(str[0]);
		int inputStudent = Integer.parseInt(str[1]);
		
		List<String> load = new ArrayList<>();
		String tmp = "";
		for(int i=0; i<inputStudent; i++) {
			tmp = br.readLine();
			if(load.contains(tmp)) {
				load.remove(tmp);
			}
			load.add(tmp);
		}
		
		if(maxStudent > load.size()) {
			maxStudent = load.size();
		}
		
		for(int i=0; i<maxStudent; i++) {
			bw.write(load.get(i)+"\n");
		}
		bw.flush();
		bw.close();
	}
}