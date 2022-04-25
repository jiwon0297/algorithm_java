package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> cheesecnt = new ArrayList<>();
	
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
		
		boolean isMelting=false;
		int t=0;
		int first = getCount();
		
		while(!isMelting) {
			t++;
			
			visited = new boolean[N][M];
			bfs(0,0);
			
			int cnt=getCount();
			if(cnt==0) isMelting=true;
			else cheesecnt.add(cnt);
		}
		
		System.out.println(t);

        if (cheesecnt.size() > 0) System.out.println(cheesecnt.get(cheesecnt.size() - 1));
        else System.out.println(first);
	}
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		visited[r][c]=true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr=cur[0];
			int cc=cur[1];
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc) || visited[nr][nc]) continue;
				
				if(map[nr][nc]==1) {
					visited[nr][nc]=true;
					map[nr][nc]=2;
				}
				
				if(map[nr][nc]==0) {
					visited[nr][nc]=true;
					q.offer(new int[] {nr,nc});
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2) map[i][j]=0;
			}
		}
		
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

	private static int getCount() {
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) cnt++;
			}
		}
		return cnt;
	}

}
