package baekjoon;

import java.util.Scanner;

public class Main_1789_수들의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong();
		long sum=0;
		int N=0;
		
		while(true) {
			N++;
			sum+=N;
			if(sum>S) break;
		}
		
		System.out.println(N-1);
	}

}
