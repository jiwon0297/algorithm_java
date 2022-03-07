package baekjoon;

import java.util.Scanner;

public class Main_1476_날짜계산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		int e=1,s=1,m=1;
		int cnt=1;
		while(true) {
			if(e==E && s==S && m==M) break;
			e++;
			if(e>15) e=1;
			s++;
			if(s>28) s=1;
			m++;
			if(m>19) m=1;
			
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
