package swexpert;

import java.util.Scanner;

public class ex1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		String[] str;
		int result, tmp;
		
		for(int test_case=1; test_case<=T; test_case++) {
			result = 0;
			tmp = 0;
			str = sc.nextLine().split("");
			
			for(int i=0; i<str.length; i++) {
				int now = Integer.parseInt(str[i]);
				if(now != tmp) {
					result++;
					tmp = now;
				}
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
}
