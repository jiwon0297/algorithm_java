package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	
	static int N,M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		Queue<int[]> q = new LinkedList<>();

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					q.offer(new int[] {i, j});
				}
			}
		}
		
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for(int i=0; i<4; i++) {
				int nr= cr+dr[i];
				int nc= cc+dc[i];
				
				if(!chk(nr,nc)) continue;
				if(map[nr][nc]==0) {
					q.offer(new int[] {nr,nc});
					map[nr][nc]=map[cr][cc]+1;
				}
			}
		}
		
		int max=Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					System.out.println(-1);
					return ;
				} else {
					if(map[i][j]>max) max=map[i][j];
				}
			}
		}
		
		System.out.println(max-1);
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
