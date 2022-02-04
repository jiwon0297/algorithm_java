package swea.d2;

import java.util.Scanner;

public class Solution_D2_1940_가랏RC카 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			
			int speed = 0;
			int dist = 0;
			for(int i=0; i<N; i++) {
				int command = sc.nextInt();
				
				if(command == 1) { //가속
					speed+=sc.nextInt();
				} else if(command == 2) { //감속
					speed-=sc.nextInt();
				} else if(command == 0) { //유지
					
				}
				if(speed<0) speed=0;
				dist+=speed;
			}
			
			System.out.println("#"+t+" "+dist);
		}
	}

}
