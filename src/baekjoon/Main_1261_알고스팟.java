package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {

	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	
	static class Point implements Comparable<Point>{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return this.cnt-o.cnt;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		
		int res = bfs(0,0);
		System.out.println(res);
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	private static int bfs(int r, int c) {	
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(r,c,0));
		visited=new boolean[N][M];
		visited[r][c]=true;
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			int cr=cur.r;
			int cc=cur.c;
			int ccnt=cur.cnt;
			
			if(cr==N-1 && cc==M-1) {
				return ccnt;
			}
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc) || visited[nr][nc]) continue;
				
				if(map[nr][nc]==0) {
					visited[nr][nc]=true;
					pq.offer(new Point(nr,nc,ccnt));
				} 
				
				if(map[nr][nc]==1) {
					visited[nr][nc]=true;
					pq.offer(new Point(nr,nc,ccnt+1));
				}
			}
		}
		
		return 0;
	}

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}

}
