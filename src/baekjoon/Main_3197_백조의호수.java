package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//208460KB 808ms
public class Main_3197_백조의호수 {
	
	static int R,C;
	static char[][] map;
	static Point[] swan;
	
	static boolean[][] visited;
	
	static Queue<int[]> swanQ;
	static Queue<int[]> waterQ;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		swanQ = new LinkedList<>();
		waterQ = new LinkedList<>();
		visited=new boolean[R][C];
		map = new char[R][C];
		swan = new Point[2];
		
		int idx=0;
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=str.charAt(j);
				
				if(map[i][j]=='L') {
					map[i][j]='.';
					swan[idx++]=new Point(i,j);
				}
				
				if(map[i][j]=='.') {
					waterQ.offer(new int[] {i,j});
				}
			}
		}
		
		swanQ.offer(new int[] {swan[0].r, swan[0].c});
		visited[swan[0].r][swan[0].c]=true;
		
		int cnt=0;
		while(true) {
			if(isMeeting()) break;
			melt();
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};

	private static boolean isMeeting() {
		Queue<int[]> q = new LinkedList<>();
		while(!swanQ.isEmpty()) {
			int[] cur = swanQ.poll();
			int cr = cur[0];
			int cc = cur[1];
			
			if(cr==swan[1].r && cc==swan[1].c) return true;
			
			for(int i=0; i<4; i++) {
				int nr = cr+dr[i];
				int nc = cc+dc[i];
				
				if(!chk(nr,nc) || visited[nr][nc]) continue;
				visited[nr][nc]=true;
				if(map[nr][nc]=='.') swanQ.offer(new int[] {nr,nc});
				else if(map[nr][nc]=='X') q.offer(new int[] {nr,nc});
			}
		}
		swanQ=q;
		return false;
	}

	private static void melt() {
		int size=waterQ.size();
		for(int i=0; i<size; i++) {
			int[] cur = waterQ.poll();
			int cr=cur[0];
			int cc=cur[1];
			
			for(int j=0; j<4; j++) {
				int nr=cr+dr[j];
				int nc=cc+dc[j];
				
				if(!chk(nr,nc) || map[nr][nc]!='X') continue;
				map[nr][nc]='.';
				waterQ.add(new int[] {nr,nc});
			}
		}	
	}
	
	private static boolean chk(int r, int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}

	static class Point {
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
