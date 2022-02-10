package baekjoon;

import java.util.Scanner;

public class Main_2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[101][101];
		
		for(int i=0; i<N; i++) {
			int c = sc.nextInt();
			int r = sc.nextInt();
			
			for(int j=r; j<r+10; j++) {
				for(int k=c; k<c+10; k++) {
					map[j][k]=1;
				}
			}
		}
		
		int res=0;
		for(int i=1; i<=100; i++) {
			for(int j=1; j<=100; j++) {
				if(map[i][j]>0) res++;
			}
		}
		
		System.out.println(res);
	}

}
