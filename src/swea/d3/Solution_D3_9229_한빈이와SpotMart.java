package swea.d3;

import java.util.Scanner;

public class Solution_D3_9229_한빈이와SpotMart {

	static int N;
	static int M;
	static int max;
	static int[] ai;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			ai = new int[N];
			for(int i=0; i<N; i++) {
				ai[i]=sc.nextInt();
			}
			
			max=-1;
			combi(0,0,0);
			System.out.println("#"+t+" "+max);
		}
	}

	private static void combi(int cnt, int start, int sum) {
		if(cnt==2) {
			if(sum<=M && sum>max) max=sum;
			return ;
		}
		
		for(int i=start; i<N; i++) {
			combi(cnt+1, i+1, sum+ai[i]);
		}
	}

}
