package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2667_단지번호붙이기 {

	static int N;
	static int[][] map;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	static boolean[][] visited;
	static int cnt;
	static int[] res = new int[25*25];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map=new int[N][N];
		visited=new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String st = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j]=st.charAt(j)-'0';
			}
		}
		
		cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					cnt++;
					bfs(i,j);
				}
			}
		}
		
		Arrays.sort(res);
		
		System.out.println(cnt);
		for(int i:res) {
			if(i!=0) {
				System.out.println(i);
			}
		}
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		visited[r][c]=true;
		q.offer(new int[] {r,c});
		res[cnt]++;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr=cur[0];
			int cc=cur[1];
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc)) continue;
				if(map[nr][nc]==1 && !visited[nr][nc]) {
					q.offer(new int[] {nr,nc});
					visited[nr][nc]=true;
					res[cnt]++;
				}
			}
		}
	}

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

}
