package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙_dfs {
	
	static int N,M,ans;
	static int[][] map;
	static boolean[] visited;
	static int[] bacon;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map[A][B]=map[B][A]=1;
		}
		
		bacon = new int[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				ans=Integer.MAX_VALUE;
				visited=new boolean[N+1];
				dfs(i,j,0);
				bacon[i]+=ans;
			}
		}
		
		int min=Integer.MAX_VALUE;
		int idx=0;
		for(int i=1; i<=N; i++) {
			if(min>bacon[i]) {
				min=bacon[i];
				idx=i;
			}
		}
		
		System.out.println(idx);
	}

	private static void dfs(int start, int end, int cnt) {
		if(start==end) {
			ans=Math.min(ans, cnt);
			return ;
		}
		
		visited[start]=true;
		for(int i=1; i<=N; i++) {
			if(!visited[i] && map[start][i]==1) dfs(i, end, cnt+1);
		}
		visited[start]=false;
	}

}
