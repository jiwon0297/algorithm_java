package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	
	static int N,M;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				map[Y][X]=1;
			}
			
			visited = new boolean[N][M];
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						cnt++;
						dfs(i,j);
						//bfs(i,j);
					}
				}
			}
			System.out.println(cnt);
		}
	}

	//bfs
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		visited[r][c]=true;
		q.offer(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr=cur[0];
			int cc=cur[1];
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc)) continue;
				if(map[nr][nc]==1 && !visited[nr][nc]) {
					visited[nr][nc]=true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
	}

	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	private static void dfs(int r, int c) {
		visited[r][c]=true;
		
		for(int i=0; i<4; i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(!chk(nr,nc)) continue;
			
			if(map[nr][nc]==1 && !visited[nr][nc]) dfs(nr,nc);
		}
	}
	
	

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}

}
