package com.ssafy.backjoon;

import java.io.*;

public class ex1001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		
		System.out.println(Integer.parseInt(s[0]) - Integer.parseInt(s[1]));
	}
}
