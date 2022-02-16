package swea;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1984_중간평균값구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int[] num = new int[10];
			for(int i=0; i<10; i++) {
				num[i]=sc.nextInt();
			}
			
			Arrays.sort(num);
			
			int sum=0;
			for(int i=1; i<9; i++) {
				sum+=num[i];
			}
			
			System.out.printf("#%d %.0f\n",t,(1.0)*sum/8);
		}
	}

}
