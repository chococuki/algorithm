package ex1644;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//n까지의 소수 찾기
		int n = Integer.parseInt(br.readLine());
		
		//소수를 저장할 List
		List<Integer> prime = new ArrayList<>();
		//n까지의 숫자 정보를 저장할 배열
		//배열의 index 번호를 검토할 숫자로 간주
		//소수이면 0, 아니면 1을 저장
		int[] primeCheck = new int[n+1];
		
		//0, 1은 소수가 아니므로 1 저장
		primeCheck[0] = primeCheck[1] = 1;
		for(int i=2; i<=n; i++) {
			if(primeCheck[i] != 1) {	//이전 수 체크시 배수가 아닌 것으로 판명된다면
				prime.add(i);	//소수 추가
				
				for(int j=(i+i); j<=n; j+=i) {	//숫자 i의 배수 이므로 소수 X
					if(primeCheck[j] != 1) {	//처음 체크하는 숫자라면
						primeCheck[j] = 1;		//소수가 아니므로 1저장
					}
				}
			}
		}
		
		int count=0;
		for(int i=0; i<prime.size(); i++) {
			int sum = 0;
			for(int j=i; j<prime.size(); j++) {
				sum += prime.get(j);
				if(sum > n) break;
				else if(sum == n) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}