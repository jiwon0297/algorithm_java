package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회2 {

	static int N;
	static long res;
	static int[][] W;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				W[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		res=Long.MAX_VALUE;
		for(int i=0; i<N; i++) {
			visited=new boolean[N];
			visited[i]=true;
			dfs(i,i,0,0);
		}
		System.out.println(res);
		
	}

	private static void dfs(int start, int dosi, long exp, int cnt) {
		if(cnt==N-1) {
			if(W[dosi][start]!=0) {
				exp+=W[dosi][start];
				res=Math.min(res, exp);
			}
			return ;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i] || W[dosi][i]==0) continue;
			visited[i]=true;
			dfs(start, i, exp+W[dosi][i], cnt+1);
			visited[i]=false;
		}
	}

}
