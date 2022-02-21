package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {

	static int R,C;
	static char[][] map;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		cnt=0;
		for(int i=0; i<R; i++) {
			if(dfs(i,0)) cnt++;
		}
		
		System.out.println(cnt);
	}

	static int[] dr= {-1,0,1};
	static int[] dc= {1,1,1};
	
	private static boolean dfs(int r, int c) {
		map[r][c]='-';
		
		if(c==(C-1)) return true;
	
		for(int i=0; i<3; i++) {
			int nr=r+dr[i];
			int nc=c+dc[i];
			
			if(!chk(nr,nc)) continue;
			
			if(map[nr][nc]=='.') {
				if(dfs(nr,nc)) return true;
			} 
		}
		return false;
	}

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<(C+1);
	}

}
