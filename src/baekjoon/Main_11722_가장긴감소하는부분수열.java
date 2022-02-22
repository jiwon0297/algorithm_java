package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11722_가장긴감소하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int[] num = new int[A];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<A; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[A];
		dp[0]=1;
		for(int i=1; i<A; i++) {
			dp[i]=1;
			for(int j=0; j<i; j++) {
				if(num[j]>num[i]) dp[i]=Math.max(dp[j]+1, dp[i]);
			}
		}
		
		int max=Integer.MIN_VALUE;
		for(int i=0; i<A; i++) {
			if(max<dp[i]) max=dp[i];
		}
		
		System.out.println(max);
	}

}
