package swea;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution_D2_1983_조교의성적매기기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] score = new int[N+1][3];
			double[] total = new double[N+1];
			double[] total2 = new double[N+1];
			for(int i=1; i<=N; i++) {
				for(int j=0; j<3; j++) {
					score[i][j]=sc.nextInt();
				}
				total[i]=(double)(0.35*score[i][0]+0.45*score[i][1]+0.2*score[i][2]);
				total2[i]=(double)(0.35*score[i][0]+0.45*score[i][1]+0.2*score[i][2]);
			}
			
			Arrays.sort(total);
			int kidx=0;
			for(int i=1; i<=N; i++) {
				if(total[i]==total2[K]) kidx=i;
			}
			
			int a = N/10;
			if(kidx>9*a) System.out.println("#"+t+" A+");
			else if(kidx>8*a) System.out.println("#"+t+" A0");
			else if(kidx>7*a) System.out.println("#"+t+" A-");
			else if(kidx>6*a) System.out.println("#"+t+" B+");
			else if(kidx>5*a) System.out.println("#"+t+" B0");
			else if(kidx>4*a) System.out.println("#"+t+" B-");
			else if(kidx>3*a) System.out.println("#"+t+" C+");
			else if(kidx>2*a) System.out.println("#"+t+" C0");
			else if(kidx>a) System.out.println("#"+t+" C-");
			else System.out.println("#"+t+" D0");
			
		}
	}

}
