package swea;

import java.util.Scanner;

public class Solution_D2_1970_쉬운거스름돈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[] money = new int[8];
			
			while(true) {
				if(N>=50000) {
					money[0]=N/50000;
					N=N%50000;
				}
				
				if(N>=10000) {
					money[1]=N/10000;
					N=N%10000;
				}
				
				if(N>=5000) {
					money[2]=N/5000;
					N=N%5000;
				}
				
				if(N>=1000) {
					money[3]=N/1000;
					N=N%1000;
				}
				
				if(N>=500) {
					money[4]=N/500;
					N=N%500;
				}
				
				if(N>=100) {
					money[5]=N/100;
					N=N%100;
				}
				
				if(N>=50) {
					money[6]=N/50;
					N=N%50;
				}
				
				if(N>=10) {
					money[7]=N/10;
					N=N%10;
				}
				
				if(N<10) break;
			}
			
			System.out.println("#"+t);
			for(int i=0; i<8; i++) {
				System.out.print(money[i]+" ");
			}
			System.out.println();
		}
	}

}
