package swea.d3;

import java.util.Scanner;

public class Solution_D3_2805_농작물수확하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			
			for(int i=0; i<N; i++) {
				char[] cs = sc.next().toCharArray();
				for(int j=0; j<N; j++) {
					farm[i][j]=cs[j]-'0';
				}
			}
			
			int sum=0;
			
			for(int i=0; i<N; i++) {
				if(i<=N/2) {
					for(int j=N/2-i; j<=N/2+i; j++) {
						sum+=farm[i][j];
					}
				} else {
					for(int j=i-N/2; j<=N+N/2-i-1; j++) {
						sum+=farm[i][j];
					}
				}
			}
			
			System.out.println("#"+t+" "+sum);
		}
	}

}
