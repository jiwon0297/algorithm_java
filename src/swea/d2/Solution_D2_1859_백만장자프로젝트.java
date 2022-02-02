package swea.d2;

import java.util.Scanner;

public class Solution_D2_1859_백만장자프로젝트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[] num = new int[N];
			for(int i=0; i<N; i++) {
				num[i]=sc.nextInt();
			}
			
			int max=num[N-1];
			long res=0;
			
			for(int i=N-2; i>=0; i--) {
				if(num[i]<max) {
					res+=max-num[i];
				} else {
					max=Math.max(num[i], max);
				}
			}
			
			System.out.print("#"+t+" "+res+"\n");
		}
	}

}
