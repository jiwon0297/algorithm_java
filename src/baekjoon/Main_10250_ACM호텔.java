package baekjoon;

import java.util.Scanner;

public class Main_10250_ACM호텔 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			
			int cnt=0;
			StringBuilder sb = new StringBuilder();
			for(int i=1; i<=W; i++) {
				for(int j=1; j<=H; j++) {
					cnt++;
					if(cnt==N) {
						if(i>=10) {
							sb.append(Integer.toString(j)).append(Integer.toString(i));
						} else sb.append(Integer.toString(j)).append("0").append(Integer.toString(i));
						break;
					}
				}
			}
			
			System.out.println(sb);
		}
	}

}
