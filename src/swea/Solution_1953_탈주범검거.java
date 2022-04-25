package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	
	static int N,M,R,C,L;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			st=new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}

			visited=new boolean[N][M];
			sb.append(bfs()+"\n");
		}
		System.out.println(sb);
	}

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] tunnel = {
			{0,0,0,0},
			{1,1,1,1},
			{1,0,1,0},
			{0,1,0,1},
			{1,1,0,0},
			{0,1,1,0},
			{0,0,1,1},
			{1,0,0,1}
	};
	
	private static int bfs() {
		int time=0;
		int cnt=1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {R,C});
		visited[R][C]=true;
		
		while(!q.isEmpty()) {
			if(time==L-1) break;
			
			int size=q.size();
			while(size-->0) {
				int[] cur = q.poll();
				int cr=cur[0];
				int cc=cur[1];

				int[] dir = tunnel[map[cr][cc]];
				for(int d=0; d<dir.length; d++) {
					if(dir[d]==0) continue;
					int nr=cr+dr[d];
					int nc=cc+dc[d];
					
					if(!chk(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
					if(tunnel[map[nr][nc]][(d+2)%4]==1) {
						visited[nr][nc]=true;
						q.offer(new int[] {nr,nc});
						cnt++;
					}
				}
			}
			time++;
		}
		return cnt;
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
