package swea;

import java.util.Scanner;

public class Solution_D3_1217_거듭제곱 {

	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			int T = sc.nextInt();
			N=sc.nextInt();
			M=sc.nextInt();
			long res=recur(1, 0);
			System.out.println("#"+t+" "+res);
		}
	}

	private static int recur(int res, int cnt) {
		if(cnt==M) {
			return res;
		} else {
			return recur(res*N, cnt+1);
		}
	}

}
