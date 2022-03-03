package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10157_자리배정 {
	
	static int R,C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		if(K>R*C) {
			System.out.println("0");
			return ;
		}
		
		int[][] map = new int[R][C];
		
		int[] dr = {1,0,-1,0};
		int[] dc = {0,1,0,-1};
		int r=0;
		int c=0;
		int d=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[r][c]=i*C+j+1;
				
				if(map[r][c]==K) {
					System.out.println((c+1)+" "+(r+1));
					return ;
				}
				
				int nr=r+dr[d];
				int nc=c+dc[d];
				
				if(!chk(nr,nc) || map[nr][nc]!=0) {
					d=(d+1)%4;
				}
				
				r=r+dr[d];
				c=c+dc[d];
			}
		}
	}

	private static boolean chk(int nr, int nc) {
		return nr>=0 && nr<R && nc>=0 && nc<C;
	}

}
