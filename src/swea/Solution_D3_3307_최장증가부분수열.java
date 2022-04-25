package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3307_최장증가부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] dp = new int[2][N];
			
			st = new StringTokenizer(br.readLine());
			int max=Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				dp[0][i]=Integer.parseInt(st.nextToken());
				dp[1][i]=1;
				for(int j=0; j<i; j++) {
					if(dp[0][j]<dp[0][i] && dp[1][i]<dp[1][j]+1) dp[1][i]=dp[1][j]+1;
				}
				max=Math.max(dp[1][i], max);
			}
			sb.append("#"+t+" "+max+"\n");
		}
		
		System.out.println(sb);
	}
}
