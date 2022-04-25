package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//34160KB 492ms
public class Main_2458_키순서_플로이드와샬 {
	
	static int N,M;
	static boolean[][] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dist=new boolean[N+1][N+1];	
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			dist[a][b]=true;
		}

		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				if(i==k) continue;
				for(int j=1; j<=N; j++) {
					if(j==i || k==i) continue;
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
		System.out.println(ans);
	}
}
