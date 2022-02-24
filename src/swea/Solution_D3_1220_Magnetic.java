package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1220_Magnetic {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int res=0;
			for(int c=0; c<N; c++) {
				int pre=map[0][c];
				int cnt=0;
				for(int r=1; r<N; r++) {
					int cur=map[r][c];
					if(cur==0) continue;
					if(pre==1 && cur==2) cnt++;
					pre=cur;
				}
				res+=cnt;
			}
			
			System.out.println("#"+t+" "+res);
		}
	}

}
