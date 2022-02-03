package swea.d2;

import java.util.Scanner;

public class Solution_D2_1959_두개의숫자열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] A = new int[N+1];
			int[] B = new int[M+1];
			
			for(int i=1; i<=N; i++) {
				A[i]=sc.nextInt();
			}
			
			for(int i=1; i<=M; i++) {
				B[i]=sc.nextInt();
			}
			
			int max=-2147000000;
			if(N<M) {
				for(int i=1; i<=M-N+1; i++) {
					int sum=0;
					for(int j=0; j<N; j++) {
						sum+=A[j+1]*B[i+j];
					}
					if(sum>max) max=sum;
				}
			} else if(N>M) {
				for(int i=1; i<=N-M+1; i++) {
					int sum=0;
					for(int j=0; j<M; j++) {
						sum+=A[i+j]*B[j+1];
					}
					if(sum>max) max=sum;
				}
			} else {
				int sum=0;
				for(int i=1; i<=N; i++) {
					sum+=A[i]*B[i];
				}
				if(sum>max) max=sum;
			}
			
			System.out.println("#"+t+" "+max);
		}
	}

}
