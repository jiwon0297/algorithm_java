package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {
	
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v= Integer.parseInt(st.nextToken());
		
			map[u][v]=1;
			map[v][u]=1;
		}

		cnt=0;
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		
		System.out.println(cnt);

	}

	private static void dfs(int start) {
		visited[start]=true;
		
		for(int i=1; i<=N; i++) {
			if(map[start][i]==1 && !visited[i]) dfs(i);
		}
	}

}
