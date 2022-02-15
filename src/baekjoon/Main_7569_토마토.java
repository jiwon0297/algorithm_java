package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {

	static int N,M,H;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		int[][][] map = new int[H][N][M];
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					map[i][j][k]=Integer.parseInt(st.nextToken());
					if(map[i][j][k]==1) q.offer(new int[] {i,j,k});
				}
			}
		}
		
		int[] dr= {-1,0,1,0,0,0};
		int[] dc= {0,1,0,-1,0,0};
		int[] dh= {0,0,0,0,1,-1};
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int ch = cur[0];
			int cr = cur[1];
			int cc = cur[2];
			
			for(int i=0; i<6; i++) {
				int nh=ch+dh[i];
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nh,nr,nc)) continue;
				
				if(map[nh][nr][nc]==0) {
					q.offer(new int[] {nh,nr,nc});
					map[nh][nr][nc]=map[ch][cr][cc]+1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(map[i][j][k]==0) {
						System.out.println(-1);
						return ;
					} else {
						if(map[i][j][k]>max) max = map[i][j][k];
					}
				}
			}
		}
		
		System.out.println(max-1);
	}

	private static boolean chk(int h, int r, int c) {
		return r>=0 && r<N && h>=0 && h<H && c>=0 && c<M;
	}

}
