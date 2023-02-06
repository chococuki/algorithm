package backjoon.ex17478;

import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static StringBuilder line = new StringBuilder();
	
	static void ans(int n) {
		
		if(n==0) {
			sb.append(line);
			sb.append("\"����Լ��� ������?\"\n");
			sb.append(line);
			sb.append("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n");
			sb.append(line);
			sb.append("��� �亯�Ͽ���.\n");
			return;		
		}
		String tmp = line.toString()+"��� �亯�Ͽ���.\n";
		
		sb.append(line);
		sb.append("\"����Լ��� ������?\"\n");
		sb.append(line);
		sb.append("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n");
		sb.append(line);
		sb.append("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n");
		sb.append(line);
		sb.append("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n");
		line.append("____");
		
		ans(n-1);
		
		sb.append(tmp);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		sb.append("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n");
		ans(sc.nextInt());
		
		System.out.println(sb.toString());
	}
}
