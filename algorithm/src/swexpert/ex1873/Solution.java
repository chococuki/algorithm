package swexpert.ex1873;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
	static String[][] arr;
	static Node now;
	static int H, W;
	static Map<String, String> rotation = new LinkedHashMap<String, String>();
	
	public static class Node {
		int x, y;
		String rot;
		
		public Node(int x, int y, String rot) {
			super();
			this.x = x;
			this.y = y;
			this.rot = rot;
		}
		
	}
	
	private static void command(String input) {
		switch (input) {
		case "U":
			move("U");
			break;
		case "D":
			move("D");
			break;
		case "L":
			move("L");
			break;
		case "R":
			move("R");
			break;
		case "S":
			shoot();
			break;
		default:
			break;
		}
	}
	
	private static void move(String rot) {
		int new_x=now.x, new_y=now.y;
		
		switch(rot) {
		case "U":
			new_x = now.x-1;
			new_y = now.y;
			break;
		case "D":
			new_x = now.x+1;
			new_y = now.y;
			break;
		case "L":
			new_x = now.x;
			new_y = now.y-1;
			break;
		case "R":
			new_x = now.x;
			new_y = now.y+1;
			break;
		}
		
		if(new_x>=0 && new_x<H && new_y>=0 && new_y<W) {
			if(arr[new_x][new_y].equals(".")) {
				arr[now.x][now.y] = ".";
				arr[new_x][new_y] = rotation.get(rot);
				now.rot = rot;
				now.x = new_x;
				now.y = new_y;
			} else {
				arr[now.x][now.y] = rotation.get(rot);
				now.rot = rot;
			}
		} else {
			arr[now.x][now.y] = rotation.get(rot);
				now.rot = rot;
		}
	}
	
	private static void shoot() {
		int now_x = now.x, now_y = now.y;
		int dx=0, dy=0;
		
		switch(now.rot) {
		case "U":
			dx=-1;
			break;
		case "D":
			dx=1;
			break;
		case "L":
			dy=-1;
			break;
		case "R":
			dy=1;
			break;
		}
		
		while(true) {
			int new_x = now_x+dx;
			int new_y = now_y+dy;
			
			if(new_x>=0 && new_x<H && new_y>=0 && new_y<W) {
				if(arr[new_x][new_y].equals("*")) {
					arr[new_x][new_y] = ".";
					break;
				} else if(arr[new_x][new_y].equals("#")) {
					break;
				} else {
					now_x = new_x;
					now_y = new_y;
				}
			} else break;
		}
	}
	
	private static void checkStart(int i, int j) {
		String str = arr[i][j];
		
		switch(str) {
		case "^":
			now = new Node(i, j, "U");
			break;
		case "v":
			now = new Node(i, j, "D");
			break;
		case "<":
			now = new Node(i, j, "L");
			break;
		case ">":
			now = new Node(i, j, "R");
			break;
		}
	}
	
	private static void print() {
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		rotation.put("U", "^");
		rotation.put("D", "v");
		rotation.put("L", "<");
		rotation.put("R", ">");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		String[] str;
		for(int t=1; t<=T; t++) {
			str = br.readLine().split(" ");
			
			H = Integer.parseInt(str[0]);
			W = Integer.parseInt(str[1]);
			
			arr = new String[H][W];
			for(int i=0; i<H; i++) {
				str = br.readLine().split("");
				for(int j=0; j<W; j++) {
					arr[i][j] = str[j];
					
					checkStart(i, j);
				}
			}
			
			str = new String[Integer.parseInt(br.readLine())];
			
			str = br.readLine().split("");
			
			for(int c=0; c<str.length; c++) {
				command(str[c]);
//				System.out.println(str[c]);
//				print();
//				System.out.println();
			}
			
			System.out.printf("#%d ", t);
			print();
			
		}
	}
}
