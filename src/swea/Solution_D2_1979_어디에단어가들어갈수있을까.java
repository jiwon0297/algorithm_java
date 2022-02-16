package swea;

import java.util.Scanner;

public class Solution_D2_1979_어디에단어가들어갈수있을까 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] puzzle = new int[N+2][N+2];
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					puzzle[i][j]=sc.nextInt();
				}
			}
			
			int res=0;
			
			//행
			for(int i=0; i<N+2; i++) {
				int cnt=0;
				for(int j=0; j<=N; j++) {
					if(puzzle[i][j]==0) {
						if(puzzle[i][j+1]==1) cnt++;
					} else {
						if(puzzle[i][j+1]==1) cnt++;
						else {
							if(cnt==K) res++;
							cnt=0;
						}
					}
				}
				
				if(cnt==K) res++;
			}
			
			//열
			for(int i=0; i<N+2; i++) {
				int cnt=0;
				for(int j=0; j<=N; j++) {
					if(puzzle[j][i]==0) {
						if(puzzle[j+1][i]==1) cnt++;
					} else {
						if(puzzle[j+1][i]==1) cnt++;
						else {
							if(cnt==K) res++;
							cnt=0;
						}
					}
				}
				
				if(cnt==K) res++;
			}
			
			System.out.println("#"+t+" "+res);
		}
	}

}
