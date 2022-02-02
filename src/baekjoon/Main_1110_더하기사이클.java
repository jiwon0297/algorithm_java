package baekjoon;

import java.util.Scanner;

public class Main_1110_더하기사이클 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int origin=N;
		int sum=0;
		
		int a1=0;
		int a2=0;
		int cnt=0;
		
		while(true) {
			cnt++;
			if(N<10) {
				a1=0;
				a2=N;
				sum=a1+a2;
				if(sum>=10) {
					N=a2*10+(sum%10);
				} else {
					N=a2*10+sum;
				}
				if(origin==N) break;
			} else {
				a1=N/10;
				a2=N%10;
				sum=a1+a2;
				if(sum>=10) {
					N=a2*10+(sum%10);
				} else {
					N=a2*10+sum;
				}
				if(origin==N) break;
			}
		}
		
		System.out.println(cnt);
		
	}

}
