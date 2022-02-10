package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1 {

	static int[][] lad;
	static boolean chk;
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		lad = new int[100][100];

		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());

			StringTokenizer st;
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					lad[i][j] = Integer.parseInt(st.nextToken());
					if(lad[i][j]==2) {
						find(i,j,0);
					}
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}

	private static void find(int r, int c, int d) {
		while(r!=0) {
			if(d==0) {
				r--;
				if(c-1>=0 && lad[r][c-1]==1) d=1;
				else if(c+1<100 && lad[r][c+1]==1) d=2;
			} else if(d==1) {
				c--;
				if(lad[r-1][c]==1) d=0;
			} else if(d==2) {
				c++;
				if(lad[r-1][c]==1) d=0;
			}
		}
		res=c;
	}

}
