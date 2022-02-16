package swea;

import java.util.Scanner;

public class Solution_D2_1926_369게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] num = new int[N+1];
		for(int i=1; i<=N; i++) {
			if((i%10==3)||(i%10==6)||(i%10)==9) num[i]++;
			if((i/10==3)||(i/10==6)||(i/10==9)) num[i]++;
		}
		
		for(int i=1; i<=N; i++) {
			switch(num[i]){
				case 1:
					System.out.print("- ");
					break;
				case 2:
					System.out.print("-- ");
					break;
				case 3:
					System.out.print("--- ");
					break;
				default:
					System.out.print(i+" ");
					break;
			}
		}
		
		
	}

}
