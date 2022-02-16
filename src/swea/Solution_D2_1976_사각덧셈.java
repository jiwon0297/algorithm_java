package swea;

import java.util.Scanner;

public class Solution_D2_1976_사각덧셈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int hour1 = sc.nextInt();
			int min1 = sc.nextInt();
			
			int hour2 = sc.nextInt();
			int min2 = sc.nextInt();
			
			int hourres = hour1 + hour2;
			int minres = min1+min2;
			if(minres>60) {
				hourres++;
				minres-=60;
			}
			
			if(hourres>12) hourres=hourres-12;
			
			System.out.println("#"+t+" "+hourres+" "+minres);
		}
	}

}
