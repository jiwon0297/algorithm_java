package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	
	static int[][] map, copy;
	static int N;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int max=Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int x=Integer.parseInt(st.nextToken());
				map[i][j]=x;
				max=Math.max(max, map[i][j]);
			}
		}
		
		int res=Integer.MIN_VALUE;
		copy=new int[N][N];
		for(int k=1; k<=max; k++) {
			copy=copyMap(k);
			visited=new boolean[N][N];
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && copy[i][j]==1) {
						cnt++;
						bfs(i,j);
					}
				}
			}
			if(cnt==0) cnt=1;
			res=Math.max(res, cnt);
		}
		
		System.out.println(res);
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		visited[r][c]=true;
		q.offer(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for(int i=0; i<4; i++) {
				int nr = cr+dr[i];
				int nc = cc+dc[i];
				
				if(!chk(nr,nc) || visited[nr][nc]) continue;
				if(copy[nr][nc]==1) {
					visited[nr][nc]=true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
		
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

	private static int[][] copyMap(int k) {
		int[][] tmp= new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]<=k) tmp[i][j]=0;
				else tmp[i][j]=1;
			}
		}
		return tmp;
	}

}
