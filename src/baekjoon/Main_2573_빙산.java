package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//129964KB 568ms
public class Main_2573_빙산 {	
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int t=1;
		while(true) {
			if(isMelting()) {
				System.out.println("0");
				break;
			}
			
			visited=new boolean[N][M];
			bfs_melting();
			
			visited=new boolean[N][M];
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]!=0 && !visited[i][j]) {
						dfs_seperate(i,j);
						cnt++;
					}
				}
			}
			
			if(cnt>=2) {
				System.out.println(t);
				break;
			}
			
			t++;
		}
	}
	
	private static void bfs_melting() {
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]!=0) {
					q.offer(new int[] {i,j});
					visited[i][j]=true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			int zerocnt=0;
			for(int i=0; i<4; i++) {
				int nr = cr+dr[i];
				int nc = cc+dc[i];
				
				if(!chk(nr,nc) || visited[nr][nc]) continue;
				
				if(map[nr][nc]==0) zerocnt++;
			}
			
			if(map[cr][cc]-zerocnt<0) map[cr][cc]=0;
			else map[cr][cc]-=zerocnt;
		}
	}

	private static void dfs_seperate(int r, int c) {
		visited[r][c]=true;
		
		for(int i=0; i<4; i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(!chk(nr,nc) || visited[nr][nc]) continue;
			
			if(map[nr][nc]!=0) dfs_seperate(nr,nc);
		}
	}
	
	private static boolean isMelting() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]!=0) return false;
			}
		}
		return true;
	}
	
	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
