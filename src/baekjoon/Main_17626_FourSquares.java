package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17626_FourSquares {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[1]=1;
		
		for(int i=2; i<=n; i++) {
			int min=Integer.MAX_VALUE;
			for(int j=1; j*j<=i; j++) {
				int mod = i-j*j;
				min=Math.min(min, dp[mod]);
			}
			dp[i]=min+1;
		}
		
		System.out.println(dp[n]);
	}
}
