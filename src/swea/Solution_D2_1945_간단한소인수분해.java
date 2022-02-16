package swea;

import java.util.Scanner;

public class Solution_D2_1945_간단한소인수분해 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int a2=0,a3=0,a5=0,a7=0,a11=0;
			
			while(N>1) {
				if(N%2==0) {
					N=N/2;
					a2++;
				}
				
				if(N%3==0) {
					N=N/3;
					a3++;
				}
				
				if(N%5==0) {
					N=N/5;
					a5++;
				}
				
				if(N%7==0) {
					N=N/7;
					a7++;
				}
				
				if(N%11==0) {
					N=N/11;
					a11++;
				}
			}
			
			System.out.println("#"+t+" "+a2+" "+a3+" "+a5+" "+a7+" "+a11);
		}
	}

}
