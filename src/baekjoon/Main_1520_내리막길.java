package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520_내리막길 {
	
	static int N,M;
	static int[][] map, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		dp=new int[M][N];
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}
		
		System.out.println(dfs(0,0));
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	private static int dfs(int r, int c) {
		if(r==M-1 && c==N-1) return 1;
		if(dp[r][c]!=-1) return dp[r][c];
		
		dp[r][c]=0;
		for(int i=0; i<4; i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(!chk(nr,nc) || map[nr][nc]>=map[r][c]) continue;
			dp[r][c]+=dfs(nr,nc);
		}
		return dp[r][c];
	}

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<M && nc>=0 && nc<N;
	}

}
