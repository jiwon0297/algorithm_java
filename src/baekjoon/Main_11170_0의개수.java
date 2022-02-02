package baekjoon;

import java.util.Scanner;

public class Main_11170_0의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int cnt=0;
			
			for(int i=N; i<=M; i++) {
				String str = Integer.toString(i);
				for(int j=0; j<str.length(); j++) {
					if(str.charAt(j)=='0') cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}

}
