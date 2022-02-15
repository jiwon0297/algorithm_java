package baekjoon;

import java.util.Scanner;

public class Main_1978_소수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			int A = sc.nextInt();
			if(isPrimeNumber(A)) cnt++;
		}
		
		System.out.println(cnt);
	}

	private static boolean isPrimeNumber(int a) {
		if(a<2) return false;
		if(a==2) return true;
		
		for(int i=2; i<=Math.sqrt(a); i++) {
			if(a%i==0) return false;
		}
		return true;
	}

}
