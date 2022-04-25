package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[][] dp = new int[2][N];
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			dp[0][i]=Integer.parseInt(st.nextToken());
			for(int j=0; j<i; j++) {
				if(dp[0][j]<dp[0][i]) {
					dp[1][i]=Math.max(dp[1][i], dp[1][j]+1);
				}
			}
			max=Math.max(max, dp[1][i]);
		}
		
		System.out.println(max+1);
	}
}
