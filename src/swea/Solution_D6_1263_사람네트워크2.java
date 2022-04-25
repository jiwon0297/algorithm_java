package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D6_1263_사람네트워크2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int[][] dist = new int[N][N];	
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					dist[i][j]=Integer.parseInt(st.nextToken());
					if(i!=j && dist[i][j]==0) dist[i][j]=9999999;
				}
			}
			
			int min=Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				int sum=0;
				for(int j=0; j<N; j++) {
					if(i==j) continue;
					for(int k=0; k<N; k++) {
						if(k==i || j==k) continue;
						dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
					}
					sum+=dist[i][j];
				}
				min=Math.min(min, sum);
			}
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb);
	}
}
