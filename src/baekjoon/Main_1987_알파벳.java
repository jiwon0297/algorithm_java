package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	
	static char[][] board;
	static int R,C;
	static boolean[] visited;
	static int[] dr= {0,0,-1,1};
	static int[] dc= {1,-1,0,0};
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j]=str.charAt(j);
			}
		}
		
		visited=new boolean[26];		
		max=Integer.MIN_VALUE;
		dfs(0,0,0);
		System.out.println(max);
	}

	private static void dfs(int r, int c, int cnt) {
		if(visited[board[r][c]-'A']) {
			if(cnt>max) max=cnt;
			return;
		}
		
		visited[board[r][c]-'A']=true;
		for(int i=0; i<4; i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(!chk(nr,nc)) continue;
			dfs(nr,nc,cnt+1);
		}
		visited[board[r][c]-'A']=false;
	}

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}

}
