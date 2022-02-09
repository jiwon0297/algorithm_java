package baekjoon;

import java.util.Scanner;

public class Main_2567_색종이2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] paper = new int[101][101];
		
		for(int i=0; i<N; i++) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			
			for(int j=r; j<r+10; j++) {
				for(int k=c; k<c+10; k++) {
					paper[j][k]=1;
				}
			}
		}
		
		int[] dr= {0,1,0,-1};
		int[] dc= {1,0,-1,0};
		
		int res=0;
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(paper[i][j]==1) {
					int r=i;
					int c=j;
					for(int k=0; k<4; k++) {
						int nr= r+dr[k];
						int nc= c+dc[k];
						
						if(nr<1||nr>100||nc<1||nc>100) res++;
						else if(paper[nr][nc]==0) res++;
					}
				}
			}
		}
		
		System.out.println(res);
	}

}
