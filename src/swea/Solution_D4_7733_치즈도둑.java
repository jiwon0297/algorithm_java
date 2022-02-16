package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_7733_치즈도둑 {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int cnt;
			int max=1;

			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int day=1; day<=100; day++) {
				cnt=0;
				visit=new boolean[N][N];
				eat(day);
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(!visit[i][j] && map[i][j]!=0) {
							cnt++;
							count(i,j);
						}
					}
				}
				
				if(max<cnt) max=cnt;
			}
			
			System.out.println("#"+t+" "+max);
		}
	}

	private static void eat(int day) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==day) {
					map[i][j]=0;
					visit[i][j]=true;
				}
			}
		}
	}

	private static void count(int i, int j) {
		int r=i;
		int c=j;
		
		visit[r][c]=true;
		
		for(int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr>=0 && nr<N && nc>=0 && nc<N && !visit[nr][nc] && map[nr][nc]!=0) count(nr,nc);
		}
	}


}
