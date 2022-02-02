package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2693_N번째큰수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int[] A = new int[11];
			for(int i=1; i<=10; i++) A[i]=sc.nextInt();
			
			Arrays.sort(A);
			System.out.println(A[8]);
		}
	}

}
