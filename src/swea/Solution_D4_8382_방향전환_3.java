package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs
public class Solution_D4_8382_방향전환_3 {

	static int x1,y1,x2,y2;
	static int min;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,-1,0,1};
	static int[][][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken())+100;
			y1 = Integer.parseInt(st.nextToken())+100;
			x2 = Integer.parseInt(st.nextToken())+100;
			y2 = Integer.parseInt(st.nextToken())+100;
			
			visited=new int[201][201][2];
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] {x1,y1,0,0}); //상하로 시작 
			q.offer(new int[] {x1,y1,0,1}); //좌우로 시작
			visited[x1][y1][0]=1; //상하방법으로 방문
			visited[x1][y1][1]=1;
			
			min=-1;
			while(!q.isEmpty()) {
				int[] cur=q.poll();
				int cx=cur[0];
				int cy=cur[1];
				int cnt=cur[2];
				int dir=cur[3];
				
				if(cx==x2 && cy==y2) {
					min=cnt;
					break;
				}
				
				for(int i=1; i<4; i+=2) {
					int s = (dir+i)%4;
					int u = (dir+i)%2;
					
					int nx=cx+dr[s];
					int ny=cy+dc[s];
					
					if(!chk(nx,ny)||visited[nx][ny][u]!=0) continue;
					
					visited[nx][ny][u]=1;
					q.offer(new int[] {nx,ny,cnt+1,u});
				}
			}
			System.out.println("#"+t+" "+min);
		}
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<=200 && c>=0 && c<=200;
	}
}
