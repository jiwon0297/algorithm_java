package swea;

import java.util.Scanner;

public class Solution_D2_1285_아름이의돌던지기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int[] loc = new int[N];
			int min=2147000000;
			for(int i=0; i<N; i++) {
				loc[i]=sc.nextInt();
				int diff = Math.abs(loc[i]);
				min=Math.min(diff, min);
			}
			
			int cnt=0;
			for(int i=0; i<N; i++) {
				if(Math.abs(loc[i])==min) {
					cnt++;
				}
			}
			
			System.out.println("#"+t+" "+min+" "+cnt);
		}
	}

}
