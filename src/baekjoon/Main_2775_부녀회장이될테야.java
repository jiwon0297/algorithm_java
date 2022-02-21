package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2775_부녀회장이될테야 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[k+1][n+1];
			
			for(int i=0; i<=n; i++) {
				map[0][i]=i;
			}
			
			for(int i=1; i<=k; i++) {
				for(int j=1; j<=n; j++) {
					for(int l=1; l<=j; l++) {
						map[i][j]+=map[i-1][l];
					}
				}
			}
			
			System.out.println(map[k][n]);
		}
	}

}
