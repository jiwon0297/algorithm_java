package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	
	static int w,h,cnt;
	static int[][] map;
	static boolean[][] visited;	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) return;
			
			map = new int[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}

			cnt=0;
			visited=new boolean[h][w];
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						cnt++;
						//bfs(i,j);
						dfs(i,j);
					}
				}
			}
			
			System.out.println(cnt);
		}
	}


	static int[] dr= {0,1,1,1,0,-1,-1,-1};
	static int[] dc= {1,1,0,-1,-1,-1,0,1};
	
	//dfs
	private static void dfs(int r, int c) {
		int cr=r;
		int cc=c;
		visited[cr][cc]=true;
		
		for(int i=0; i<8; i++) {
			int nr=cr+dr[i];
			int nc=cc+dc[i];
			
			if(!chk(nr,nc)) continue;
			if(map[nr][nc]==1 && !visited[nr][nc]) {
				visited[nr][nc]=true;
				dfs(nr,nc);
			}
		}
	}

	//bfs
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		visited[r][c]=true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			for(int i=0; i<8; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc)) continue;
				
				if(map[nr][nc]==1 && !visited[nr][nc]) {
					visited[nr][nc]=true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
	}
	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<h && nc>=0 && nc<w;
	}

}
