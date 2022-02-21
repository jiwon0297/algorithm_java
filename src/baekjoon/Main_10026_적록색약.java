package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_적록색약 {

	static int N;
	static char[][] map;
	static boolean[][] visited1, visited2;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map=new char[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		int cnt1=0;
		int cnt2=0;
		visited1=new boolean[N][N];
		visited2=new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited1[i][j]) {
					cnt1++;
					bfs(i,j,map[i][j]);
				} 
				
				if(!visited2[i][j]) {
					cnt2++;
					bfs2(i,j,map[i][j]);
				}
			}
		}
		
		System.out.println(cnt1+" "+cnt2);

	}

	static int[] dr= {0,0,-1,1};
	static int[] dc= {1,-1,0,0};

	private static void bfs(int r, int c, char ch) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		visited1[r][c]=true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr=cur[0];
			int cc=cur[1];
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc)) continue;
				if(!visited1[nr][nc] && map[nr][nc]==ch) {
					visited1[nr][nc]=true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
	}
	
	private static void bfs2(int r, int c, char ch) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		visited2[r][c]=true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr=cur[0];
			int cc=cur[1];
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc)) continue;
				if(ch=='G' || ch=='R') {
					if(!visited2[nr][nc] && (map[nr][nc]=='G' || map[nr][nc]=='R')) {
						visited2[nr][nc]=true;
						q.offer(new int[] {nr,nc});
					}
				} else {
					if(!visited2[nr][nc] && map[nr][nc]==ch) {
						visited2[nr][nc]=true;
						q.offer(new int[] {nr,nc});
					}
				}
			}
		}
	}
	
	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

	

}
