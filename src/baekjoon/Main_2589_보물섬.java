package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {
	
	static int L,W, res, cnt;
	static char[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[L][W];
		for(int i=0; i<L; i++) {
			String str = br.readLine();
			for(int j=0; j<W; j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		res=Integer.MIN_VALUE;
		for(int i=0; i<L; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]=='L') {
					visited=new boolean[L][W];
					cnt=0;
					bfs(i,j);
					res=Math.max(res, cnt);
				}
			}
		}
		
		System.out.println(res);
	}

	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		visited[r][c]=true;
		q.offer(new int[] {r,c,0});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cr=cur[0];
			int cc=cur[1];
			int ccnt=cur[2];
			
			for(int i=0; i<4; i++) {
				int nr=cr+dr[i];
				int nc=cc+dc[i];
				
				if(!chk(nr,nc) || visited[nr][nc]) continue;
				if(map[nr][nc]=='L') {
					visited[nr][nc]=true;
					q.offer(new int[] {nr,nc, ccnt+1});
					cnt=Math.max(cnt, ccnt+1);
				}
			}
		}
	}
	private static boolean chk(int r, int c) {
		return r>=0 && r<L && c>=0 && c<W;
	}

}
