package baekjoon;

import java.util.Scanner;

public class Main_8320 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int ans=0;
		for(int i=1; i<=N; i++) {
			for(int j=i; j*i<=N; j++) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}
