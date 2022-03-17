package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	
	static class Ball {
		int r,c,cnt;

		public Ball(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int N,M;
	static char[][] map;
	static boolean[][][][] visited;
	static Ball red, blue;
	static int res=-1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=str.charAt(j);
				
				if(map[i][j]=='R') red=new Ball(i,j,0);
				if(map[i][j]=='B') blue=new Ball(i,j,0);
			}
		}
		
		bfs(red, blue);
		System.out.println(res);
	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	private static void bfs(Ball red, Ball blue) {
		Queue<Ball> rq = new LinkedList<>();
		Queue<Ball> bq = new LinkedList<>();
		visited[red.r][red.c][blue.r][blue.c]=true;		
		rq.offer(red);
		bq.offer(blue);
		
		while(!rq.isEmpty() && !bq.isEmpty()) {
			Ball cred = rq.poll();
			Ball cblue = bq.poll();
			
			if(cred.cnt>10) {
				res=-1;
				return ;
			}
			
			if(map[cblue.r][cblue.c]=='O') continue;
			if(map[cred.r][cred.c]=='O') {
				res=cred.cnt;
				return ;
			}
			
			for(int i=0; i<4; i++) {
				//red
				int rr = cred.r;
				int rc = cred.c;
				
				while(true) {
					rr+=dr[i];
					rc+=dc[i];
					
					if(map[rr][rc]=='O') break;
					else if(map[rr][rc]=='#') {
						rr-=dr[i];
						rc-=dc[i];
						break;
					}
				}
				
				//blue
				int br = cblue.r;
				int bc = cblue.c;
				
				while(true) {
					br+=dr[i];
					bc+=dc[i];
					
					if(map[br][bc]=='O') break;
					else if(map[br][bc]=='#') {
						br-=dr[i];
						bc-=dc[i];
						break;
					}
				}
				
				//위치가 같은데 구멍이 아닐 때 
				if(br==rr && bc==rc && map[rr][rc]!='O') {
					int rdist = Math.abs(cred.r-rr) + Math.abs(cred.c-rc);
					int bdist = Math.abs(cblue.r-br) + Math.abs(cblue.c-bc);
					
					if(rdist>bdist) {
						rr-=dr[i];
						rc-=dc[i];
					} else {
						br-=dr[i];
						bc-=dc[i];
					}
				}
				
				if(!visited[rr][rc][br][bc]) {
					visited[rr][rc][br][bc]=true;
					rq.offer(new Ball(rr,rc,cred.cnt+1));
					bq.offer(new Ball(br,bc,cblue.cnt+1));
				}
			}
		}
	}

}
