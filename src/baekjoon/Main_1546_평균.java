package baekjoon;

import java.util.Scanner;

public class Main_1546_평균 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] score = new double[N];

		double max=-2147000000;
		for(int i=0; i<N; i++) {
			double num =sc.nextInt();
			score[i]=num;
			max=Math.max(max, num);
		}
		
		double total=0;
		for(int i=0; i<N; i++) {
			score[i]=score[i]/max*100;
			total += score[i];
		}
		
		System.out.println(total/N);
		
		
	}

}
