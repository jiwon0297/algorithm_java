package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {

	static int N,M;
	static int[][] map;
	static boolean[][][] visited;
	static int res=-1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited=new boolean[N][M][2];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}

		bfs(0,0);
		System.out.println(res);
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c,1,0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr = cur[0];
			int cc = cur[1];
			int ccnt = cur[2];
			int cd = cur[3];
			
			if(cr==N-1 && cc==M-1) {
				res=ccnt;
				return ;
			}
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc)) continue;
				
				int ncnt=ccnt+1;
				
				if(map[nr][nc]==0) {
					if(cd==0 && !visited[nr][nc][0]) {
						q.add(new int[] {nr,nc,ncnt,0});
						visited[nr][nc][0]=true;
					} else if(cd==1 && !visited[nr][nc][1]) {
						q.add(new int[] {nr,nc,ncnt,1});
						visited[nr][nc][1]=true;
					}
					
				} else if(map[nr][nc]==1) {
					if(cd==0) {
						q.add(new int[] {nr,nc,ncnt,1});
						visited[nr][nc][1]=true;
					}
				}
			}
		}
	}

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}

}
