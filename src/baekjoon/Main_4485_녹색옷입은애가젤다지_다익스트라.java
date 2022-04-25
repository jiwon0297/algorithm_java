package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_녹색옷입은애가젤다지_다익스트라 {

	static int N, ans;
	static int[][] map, dist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T=0;
		while(true){
			T++;
			N = Integer.parseInt(br.readLine());
			if(N==0) break ;
			map=new int[N][N];
			
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			sb.append("Problem ").append(T).append(": ").append(dijkstra()).append("\n");
		}
		
		System.out.println(sb);
	}

	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	private static int dijkstra() {
		dist = new int[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		PriorityQueue<Zelda> pq = new PriorityQueue<>();
		dist[0][0]=map[0][0];
		pq.offer(new Zelda(0,0,map[0][0]));
		
		while(!pq.isEmpty()) {
			Zelda cur = pq.poll();
			int r = cur.r;
			int c = cur.c;
			int rupee = cur.rupee;

			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				
				if(!chk(nr,nc) || rupee+map[nr][nc]>=dist[nr][nc]) continue;
				
				dist[nr][nc]=rupee+map[nr][nc];
				pq.offer(new Zelda(nr,nc,dist[nr][nc]));
			}
		}
		return dist[N-1][N-1];
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
