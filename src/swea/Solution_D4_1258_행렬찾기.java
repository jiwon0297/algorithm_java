package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1258_행렬찾기 {

	static int N;
	static int[][] map;
	static ArrayList<Point> res;
	static boolean[][] visited;
	
	static class Point implements Comparable<Point> { 
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Point o) {
			int diff = this.r*this.c - o.r*o.c;
			return diff==0? this.r-o.r:diff ;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			res=new ArrayList<>();
			visited=new boolean[N][N];
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>0 && !visited[i][j]) {
						cnt++;
						bfs(i,j);
					}
				}
			}
			
			System.out.print("#"+t+" "+cnt);
			Collections.sort(res);
			for(int i=0; i<res.size(); i++) {
				System.out.print(" "+res.get(i).r+" "+res.get(i).c);
			}
			System.out.println();
		}
	}

	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(r,c));
		visited[r][c]=true;
		
		int sr=r;
		int sc=c;
		int er=r;
		int ec=c;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			int cr = cur.r;
			int cc = cur.c;
			er=cr;
			ec=cc;
			
			for(int i=0; i<4; i++) {
				int nr = cr+dr[i];
				int nc = cc+dc[i];
				
				if(!chk(nr,nc)) continue;
				if(map[nr][nc]>0 && !visited[nr][nc]) {
					visited[nr][nc]=true;
					q.offer(new Point(nr,nc));
				}
			}
		}
		res.add(new Point(er-sr+1, ec-sc+1));
	}

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

}
