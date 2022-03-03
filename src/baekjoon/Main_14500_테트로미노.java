package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {

	static boolean[][] visited;
	static int N,M;
	static int[][] map;
	static int max=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		visited=new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j]=true;
				dfs(0, map[i][j], i, j);
				visited[i][j]=false;
				tetromino(i,j); //ㅗ,ㅏ,ㅓ,ㅜ 모양 
			}
		}
		
		System.out.println(max);
	}

	static int[] dr= {0,0,1,-1};
	static int[] dc= {1,-1,0,0};
	
	private static void dfs(int cnt, int sum, int r, int c) {
		if(cnt==3) {
			max=Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(!chk(nr,nc) || visited[nr][nc]) continue;
			
			visited[nr][nc]=true;
			dfs(cnt+1, sum+map[nr][nc],nr,nc);
			visited[nr][nc]=false;	
		}
	}

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<M;
	}
	
	//ㅗ,ㅏ,ㅓ,ㅜ 모양 
	private static void tetromino(int r, int c) {
		 if (r < N - 2 && c < M - 1) max = Math.max(max, map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 1][c + 1]);
		 if (r < N - 2 && c > 0) max = Math.max(max, map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 1][c - 1]);
	     if (r < N - 1 && c < M - 2) max = Math.max(max, map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r + 1][c + 1]);
	     if (r > 0 && c < M - 2) max = Math.max(max, map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r - 1][c + 1]);
	}

}
