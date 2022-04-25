package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638_치즈 {

	static int N,M;
	static int[][] map;
	static int[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	
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
		
		visited = new int[N][M];
		boolean isMelting=false;
		int t=0;
		while(!isMelting) {	
			t++;

			for(int i=0; i<N; i++) {
				Arrays.fill(visited[i], 0);
			}
			
			bfs(0,0);
			
			isMelting=true;
			loop:
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]!=0) {
						isMelting=false;
						break loop;
					}
				}
			}
		}
		
		System.out.println(t);
	}
	
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,-1,0,1};
	
	private static void bfs(int r, int c) {
		q.offer(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr=cur[0];
			int cc=cur[1];
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc)) continue;
				
				if(map[nr][nc]==1) {
					visited[nr][nc]++;
					if(visited[nr][nc]>=2) map[nr][nc]=0;
				}
								
				if(map[nr][nc]==0 && visited[nr][nc]==0) {
					visited[nr][nc]=1;
					q.offer(new int[] {nr,nc});
				}
			}
		}
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
