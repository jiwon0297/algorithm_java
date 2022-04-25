package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_2407_조합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		if(m==0 || n==0) {
			System.out.println(1);
			return ;
		}
		
		if(n==(m+1)) {
			System.out.println(n);
			return ;
		}
		
		BigInteger[][] dp = new BigInteger[101][101];
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0 || j==i) dp[i][j]=BigInteger.valueOf(1);
				else dp[i][j]=dp[i-1][j-1].add(dp[i-1][j]);
			}
		}
		
		System.out.println(dp[n][m]);
	}

}
