package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//93736KB 1968ms
public class Solution_D4_5643_키순서_플로이드와샬 {
	
	static int T,N,M;
	static boolean[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			dist=new boolean[N+1][N+1];		
			for(int i=0; i<M; i++) {
				st=new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				dist[a][b]=true;
			}
			
			for(int k=1; k<=N; k++) {
				for(int i=1; i<=N; i++) {
					if(k==i) continue;
					for(int j=1; j<=N; j++) {
						if(j==k || j==i) continue;
						if(dist[i][k] && dist[k][j]) dist[i][j]=true;
					}
				}
			}
			
			int ans=0;
			for(int i=1; i<=N; i++) {
				int cnt=0;
				for(int j=1; j<=N; j++) {
					if(i==j) continue;
					if(dist[i][j] || dist[j][i]) cnt++;
				}
				if(cnt==N-1) ans++;
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}
