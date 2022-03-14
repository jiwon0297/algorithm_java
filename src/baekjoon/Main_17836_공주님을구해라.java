package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Knight{
	int r,c,sword,time;

	public Knight(int r, int c, int sword, int time) {
		super();
		this.r = r;
		this.c = c;
		this.sword = sword;
		this.time = time;
	}
}

public class Main_17836_공주님을구해라 {

	static int N,M,T;
	static int[][] map;
	static boolean[][][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		visited=new boolean[2][N][M];
		bfs(0,0);
		System.out.println("Fail");
	}
	
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};

	private static void bfs(int r, int c) {
		Queue<Knight> q = new LinkedList<Knight>();
		q.add(new Knight(r,c,0,0));
		visited[0][r][c]=true;
		
		while(!q.isEmpty()) {
			Knight ck = q.poll();
			int cr = ck.r;
			int cc = ck.c;
			
			if(map[cr][cc]==2) ck.sword=1;
			if(ck.time==T) continue;
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc) || visited[ck.sword][nr][nc]) continue;
				if(nr==N-1 && nc==M-1) {
					System.out.println(ck.time+1);
					System.exit(0);
				}
				
				if(ck.sword==1 && map[nr][nc]==1) {
					visited[ck.sword][nr][nc]=true;
					q.offer(new Knight(nr,nc,ck.sword,ck.time+1));
				}
				
				if(map[nr][nc]==0 || map[nr][nc]==2) {
					visited[ck.sword][nr][nc]=true;
					q.offer(new Knight(nr,nc,ck.sword,ck.time+1));
				}
			}
		}
	}

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}

}
