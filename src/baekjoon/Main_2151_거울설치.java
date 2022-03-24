package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_2151_거울설치 {
	
	static class Mirror implements Comparable<Mirror>{
		int r,c,d,cnt;

		public Mirror(int r, int c, int d, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Mirror o) {
			return this.cnt-o.cnt;
		}
	}
	
	static int N;
	static char[][] map;
	static int sr,sc,er,ec;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		int idx=0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j]=str.charAt(j);
				if(map[i][j]=='#') {
					if(idx==0) {
						sr=i;
						sc=j;
					} else {
						er=i;
						ec=j;
					}
					idx++;
				}
			}
		}
		
		bfs();
	}

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	
	private static void bfs() {
		PriorityQueue<Mirror> pq = new PriorityQueue<>();
		boolean[][][] visited = new boolean[N][N][4];
		
		for(int i=0; i<4; i++) {
			pq.add(new Mirror(sr,sc,i,0));
		}
		
		while(!pq.isEmpty()) {
			Mirror cur = pq.poll();
			int cr = cur.r;
			int cc = cur.c;
			int dir = cur.d;
			int cnt = cur.cnt;
			
			visited[cr][cc][dir]=true;
			
			if(cr==er && cc==ec) {
				System.out.println(cnt);
				return ;
			}
			
			int nr = cr+dr[dir];
			int nc = cc+dc[dir];
			
			if(!chk(nr,nc) || visited[nr][nc][dir] || map[nr][nc]=='*') continue;
			if(map[nr][nc]=='!') {
				int ndir=(dir+3)%4;
				pq.add(new Mirror(nr,nc,ndir,cnt+1));
				
				ndir=(dir+1)%4;
				pq.add(new Mirror(nr,nc,ndir,cnt+1));
			}
			
			pq.add(new Mirror(nr,nc,dir,cnt));
		}
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
