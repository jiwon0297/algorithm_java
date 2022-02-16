package swea;

import java.util.Scanner;

public class Solution_D3_5215_햄버거다이어트 {

	static int[] score;
	static int[] cal;
	static int N;
	static int L;
	static int max;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N=sc.nextInt();
			L=sc.nextInt();
			
			score=new int[N];
			cal=new int[N];
			
			for(int i=0; i<N; i++) {
				score[i]=sc.nextInt();
				cal[i]=sc.nextInt();
			}
			
			max=0;
			select(0,0,0);
			
			System.out.println("#"+t+" "+max);
		}
		
	}


	private static void select(int idx, int sums, int sumc) {
		if(sumc>L) return ;
		if(idx==N) {
			if(sums>max) max=sums;
			return ;
		}
		
		select(idx+1, sums+score[idx], sumc+cal[idx]); //재료 선택
		select(idx+1, sums, sumc); //재료 선택 안함
	}
	


}
