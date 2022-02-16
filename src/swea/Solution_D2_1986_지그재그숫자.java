package swea;

import java.util.Scanner;

public class Solution_D2_1986_지그재그숫자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int res=0;
			
			for(int i=1; i<=N; i++) {
				if(i%2==1) res+=i;
				else res-=i;
			}
			
			System.out.println("#"+t+" "+res);
		}
	}

}
