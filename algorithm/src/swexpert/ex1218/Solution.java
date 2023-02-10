package swexpert.ex1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<String> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case=1; test_case<=10; test_case++) {
		
			int len = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split("");
			
			int result = 1;
			for(int i=0; i<len; i++) {
				if(str[i].equals("(")) stack.push(str[i]);
				else if(str[i].equals("{")) stack.push(str[i]);
				else if(str[i].equals("[")) stack.push(str[i]);
				else if(str[i].equals("<")) stack.push(str[i]);
				else if(str[i].equals(")")) {
					if(stack.peek().equals("(")) stack.pop();
					else {
						result = 0;
						break;
					}
				}
				else if(str[i].equals("}")) {
					if(stack.peek().equals("{")) stack.pop();
					else {
						result = 0;
						break;
					}
				}
				else if(str[i].equals("]")) {
					if(stack.peek().equals("[")) stack.pop();
					else {
						result = 0;
						break;
					}
				}
				else if(str[i].equals(">")) {
					if(stack.peek().equals("<")) stack.pop();
					else {
						result = 0;
						break;
					}
				}
				
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}
