package backjoon.ex1644;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//n������ �Ҽ� ã��
		int n = Integer.parseInt(br.readLine());
		
		//�Ҽ��� ������ List
		List<Integer> prime = new ArrayList<>();
		//n������ ���� ������ ������ �迭
		//�迭�� index ��ȣ�� ������ ���ڷ� ����
		//�Ҽ��̸� 0, �ƴϸ� 1�� ����
		int[] primeCheck = new int[n+1];
		
		//0, 1�� �Ҽ��� �ƴϹǷ� 1 ����
		primeCheck[0] = primeCheck[1] = 1;
		for(int i=2; i<=n; i++) {
			if(primeCheck[i] != 1) {	//���� �� üũ�� ����� �ƴ� ������ �Ǹ�ȴٸ�
				prime.add(i);	//�Ҽ� �߰�
				
				for(int j=(i+i); j<=n; j+=i) {	//���� i�� ��� �̹Ƿ� �Ҽ� X
					if(primeCheck[j] != 1) {	//ó�� üũ�ϴ� ���ڶ��
						primeCheck[j] = 1;		//�Ҽ��� �ƴϹǷ� 1����
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