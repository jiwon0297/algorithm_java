package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] t = new int[N+1];
		int[] p = new int[N+1];
		StringTokenizer st = null;
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+2];
		for(int i=0; i<=N; i++) {
			int next = i+t[i];
			if(next<=N+1) dp[next]=Math.max(dp[next], dp[i]+p[i]);
			dp[i+1]=Math.max(dp[i+1], dp[i]);
		}
		
		System.out.println(dp[N+1]);
	}

}
