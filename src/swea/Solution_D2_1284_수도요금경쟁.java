package swea;

import java.util.Scanner;

public class Solution_D2_1284_수도요금경쟁 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int A = P * W;
			int B = 0;
			if(W<=R) B = Q;
			else {
				B = Q + (W-R)*S;
			}
			
			int min = Math.min(A, B);
			System.out.println("#"+t+" "+min);
		}
	}

}
