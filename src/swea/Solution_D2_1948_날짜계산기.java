package swea;

import java.util.Scanner;

public class Solution_D2_1948_날짜계산기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] mon = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for (int t = 1; t <= T; t++) {
			int mon1 = sc.nextInt();
			int day1 = sc.nextInt();
			int mon2 = sc.nextInt();
			int day2 = sc.nextInt();

			int sum=0;
			int sum2=0;
			
			for(int i=1; i<mon1; i++) {
				sum+=mon[i];
			}
			sum+=day1;
			
			for(int i=1; i<mon2; i++) {
				sum2+=mon[i];
			}
			sum2+=day2;
			
			int res = sum2-sum+1;
			
			System.out.println("#"+t+" "+res);
			
		}
	}

}
