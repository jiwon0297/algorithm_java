package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
	
	static int K,W,H,min;
	static boolean[][][] visited;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		for(int i=0; i<H; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[H][W][K+1];
		min=Integer.MAX_VALUE;
		bfs();
		
		if(min==Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(min);
	}
	
	static int[] hdr= {-2,-2,-1,-1,1,1,2,2};
	static int[] hdc= {-1,1,-2,2,-2,2,-1,1};
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0,0,0});
		visited[0][0][0]=true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr=cur[0];
			int cc=cur[1];
			int ccnt=cur[2];
			int k=cur[3];
			
			if(cr==H-1 && cc==W-1) {
				min=Math.min(ccnt, min);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc) || visited[nr][nc][k] || map[nr][nc]!=0) continue;
				
				visited[nr][nc][k]=true;
				q.offer(new int[] {nr,nc,ccnt+1, k});
			}
			
			if(k>=K) continue;
			for(int i=0; i<8; i++) {
				int nr=cr+hdr[i];
				int nc=cc+hdc[i];
				
				if(!chk(nr,nc) || visited[nr][nc][k+1] || map[nr][nc]!=0) continue;
				
				visited[nr][nc][k+1]=true;
				q.offer(new int[] {nr,nc,ccnt+1, k+1});
			}
		}
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<H && c>=0 && c<W;
	}

}
