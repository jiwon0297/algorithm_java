package swea.d3;

import java.util.Scanner;

public class Solution_D3_7234_안전기지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for(int i=0; i<B; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				
				map[r-1][c-1]-=1;
			}
			
			int[] dr = {0,1,0,-1};
			int[] dc = {1,0,-1,0};
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]<0) {
						int r=i;
						int c=j;
						for(int k=1; k<=2; k++) {
							for(int l=0; l<4; l++) {
								int nr=r+k*dr[l];
								int nc=c+k*dc[l];
								
								if(nr<0||nr>=N||nc<0||nc>=N||map[nr][nc]==-1) continue;
								else map[nr][nc]-=(map[r][c]);
							}
						}
					}
				}
			}
			
			int max=-1;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>max) max=map[i][j];
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}

}
