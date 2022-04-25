package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14502_연구소 {

	static int N,M,max;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		max=Integer.MIN_VALUE;
		dfs(0);
		System.out.println(max);
	}

	private static void dfs(int cnt) {
		if(cnt==3) {
			visited=new boolean[N][M];
			bfs();
			return ;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]!=0) continue;
				map[i][j]=1;
				dfs(cnt+1);
				map[i][j]=0;
			}
		}
	}
	
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		int[][] copy=new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j]=map[i][j];
				if(copy[i][j]==2 && !visited[i][j]) {
					q.offer(new int[] {i,j});
					visited[i][j]=true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			copy[cr][cc]=2;
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc) || visited[nr][nc] || copy[nr][nc]!=0) continue;
				visited[nr][nc]=true;
				q.offer(new int[] {nr,nc});
			}
		}
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(copy[i][j]==0) cnt++;
			}
		}
		max=Math.max(max, cnt);
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}