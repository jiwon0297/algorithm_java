package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//239888KB 656ms
public class Main_10942_펠린드롬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());		
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][N];
		for(int i=0; i<N; i++) dp[i][i]=1;
		for(int i=0; i<N-1; i++) if(num[i]==num[i+1]) dp[i][i+1]=1;
		for(int i=2; i<N; i++) {
			for(int j=0; j<N-i; j++) {
				if(num[j]==num[j+i] && dp[j+1][j+i-1]==1) dp[j][j+i]=1;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S =Integer.parseInt(st.nextToken())-1;
			int E = Integer.parseInt(st.nextToken())-1;
			sb.append(dp[S][E]).append("\n");
		}
		
		System.out.println(sb);
	}

}
