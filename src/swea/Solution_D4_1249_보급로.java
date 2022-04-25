package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_D4_1249_보급로 {
	
	static int N,min;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				String line=br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j]=line.charAt(j)-'0';
				}
			}
			visited = new boolean[N][N];
			min=Integer.MAX_VALUE;
			bfs();
			sb.append(min+"\n");
		}
		System.out.println(sb);
	}
	
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};

	private static void bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(0,0,0));
		visited[0][0]=true;
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			int cr=cur.r;
			int cc=cur.c;
			int time=cur.time;
			
			if(cr==N-1 && cc==N-1) {
				min=Math.min(min, time);
				return ;
			}
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc) || visited[nr][nc]) continue;
				
				visited[nr][nc]=true;
				pq.offer(new Point(nr,nc,time+map[nr][nc]));
			}
		}
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

	static class Point implements Comparable<Point> {
		int r, c, time;

		public Point(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Point o) {
			return this.time-o.time;
		}
	}
}
