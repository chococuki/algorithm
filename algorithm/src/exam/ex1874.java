package exam;

import java.io.*;

public class ex1874 {
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int count = 0;
	
	public void doPush() throws IOException {
		bw.write("+\n");
		count++;
	}
	
	public void doPop(int i) throws IOException {
		bw.write("-\n");
		count--;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt((String) br.readLine());
		
		int[] sp = new int[n];
		int tmp;
		int i = 1;
		while(true) {
			tmp = Integer.parseInt((String) br.readLine());
			
			
		}
		
		
	}
}
