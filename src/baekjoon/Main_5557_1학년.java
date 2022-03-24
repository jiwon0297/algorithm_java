package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//11708KB 80ms
public class Main_5557_1학년 {
	
	static int N;
	static int[] num;
	static long[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = new int[N];
		for(int i=0; i<N; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		
		dp=new long[21][100];
		for(int i=0; i<=20; i++) {
			for(int j=0; j<100; j++) {
				dp[i][j]=-1;
			}
		}
		
		System.out.println(recur(num[0],0));
	}

	private static long recur(int sum, int idx) {
		if(sum<0 || sum>20) return 0;
		if(idx==N-2) return (sum==num[N-1])? 1:0;
		if(dp[sum][idx]!=-1) return dp[sum][idx];
		
		dp[sum][idx]=0;		
		return dp[sum][idx]+=recur(sum+num[idx+1], idx+1)+recur(sum-num[idx+1], idx+1);
	}

}
   