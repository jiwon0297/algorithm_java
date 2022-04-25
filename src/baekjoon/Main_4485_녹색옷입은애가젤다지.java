package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지 {

	static int N, ans;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T=0;
		while(true){
			T++;
			N = Integer.parseInt(br.readLine());
			if(N==0) System.exit(0);
			map=new int[N][N];
			
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			visited=new boolean[N][N];
			ans=0;
			bfs();
			System.out.println("Problem "+T+": "+ans);
		}
	}

	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	private static void bfs() {
		PriorityQueue<Zelda> pq = new PriorityQueue<>();
		pq.offer(new Zelda(0,0,map[0][0]));
		visited[0][0]=true;
		
		while(!pq.isEmpty()) {
			Zelda cur = pq.poll();
			int r = cur.r;
			int c = cur.c;
			int rupee = cur.rupee;
			
			if(r==N-1 && c==N-1) ans=rupee;
			
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if(!chk(nr,nc) || visited[nr][nc]) continue;
				
				visited[nr][nc]=true;
				pq.offer(new Zelda(nr,nc,rupee+map[nr][nc]));
			}
		}
	}
	
	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

	static class Zelda implements Comparable<Zelda> {
		int r,c,rupee;

		public Zelda(int r, int c, int rupee) {
			super();
			this.r = r;
			this.c = c;
			this.rupee = rupee;
		}

		@Override
		public int compareTo(Zelda o) {
			return this.rupee-o.rupee;
		}
	}
}
