package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1974_스도쿠검증 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int[][] sdoku = new int[10][10];
			for(int i=1; i<=9; i++) {
				for(int j=1; j<=9; j++) {
					sdoku[i][j]=sc.nextInt();
				}
			}
			
			//가로 검증
			int[] chk = new int[10];
			int check=0;
			for(int i=1; i<=9; i++) {
				Arrays.fill(chk, 0);
				for(int j=1; j<=9; j++) {
					chk[sdoku[i][j]]++;
				}
				
				for(int j=1; j<=9; j++) {
					if(chk[j]==1) check++;
				}
			}
			
			//세로검증
			for(int i=1; i<=9; i++) {
				Arrays.fill(chk, 0);
				for(int j=1; j<=9; j++) {
					chk[sdoku[j][i]]++;
				}
				
				for(int j=1; j<=9; j++) {
					if(chk[j]==1) check++;
				}
			}
			
			for(int k=1; k<=7; k+=3) {
				for(int i=k; i<=k+2; i++) {
					for(int j=k; j<=k+2; j++) {
						chk[sdoku[j][i]]++;
					}
					
					for(int j=1; j<=9; j++) {
						if(chk[j]==1) check++;
					}
				}
			}
			
			if(check==171) System.out.println("#"+t+" 1");
			else System.out.println("#"+t+" 0");
		}
	}

}
