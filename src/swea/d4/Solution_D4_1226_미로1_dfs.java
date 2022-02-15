package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D4_1226_미로1_dfs {

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int sr;
	static int sc;
	static int er;
	static int ec;
	static int cango;
	static int N;
	static int[][] map;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			N=16;
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				char[] cs = br.readLine().toCharArray();
				for(int j=0; j<N; j++) {
					map[i][j]=cs[j]-'0';
					if(map[i][j]==2) {
						sr=i;
						sc=j;
					} else if(map[i][j]==3) {
						er=i;
						ec=j;
					}
				}
			}
			
			cango=0;
			dfs(sr,sc);
			System.out.println("#"+t+" "+cango);
		}
	}
	
	private static void dfs(int cr, int cc) {
		map[cr][cc]=-1;
		for(int d=0; d<4; d++) {
			int nr=cr+dr[d];
			int nc=cc+dc[d];
			
			if(!chk(nr,nc)) continue;
			
			if(er==nr && er==nc) { //base condition
				cango=1;
				return;
			}
			
			if(map[nr][nc]==0) { //방문 체크
				dfs(nr,nc);
			}
		}
	}

	private static boolean chk(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}
