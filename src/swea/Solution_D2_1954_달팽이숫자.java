package swea;

import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int[] dr={0,1,0,-1};
		int[] dc= {1,0,-1,0};
		
		for(int t=1; t<=T; t++) {
			int N=sc.nextInt();
			int[][] snail = new int[N][N];
			
			int r=0;
			int c=0;
			int d=0; //방향 (0,0) 오른쪽으로 시작
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					snail[r][c]=i*N+j+1;
					int nr=r+dr[d];
					int nc=c+dc[d];
					
					if(nr>=N || nr<0 || nc>=N || nc<0 || snail[nr][nc]!=0) {
						d++;
						if(d>3) d=d%4;
					}
					
					r=r+dr[d];
					c=c+dc[d];
					
				}
			}
			
			System.out.println("#"+t);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}

}
