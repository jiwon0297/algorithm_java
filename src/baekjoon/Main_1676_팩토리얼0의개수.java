package baekjoon;

import java.util.Scanner;

public class Main_1676_팩토리얼0의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt2=0;
		int cnt5=0;
		
		for(int i=1; i<=N; i++) {
			int num=i;
			
			while(num%2==0) {
				cnt2++;
				num=num/2;
			}
			
			while(num%5==0) {
				cnt5++;
				num=num/5;
			}
		}
		
		System.out.println(Math.min(cnt2, cnt5));
	}


}
