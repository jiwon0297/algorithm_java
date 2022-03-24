package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//19196KB, 328ms
public class Main_1865_웜홀 {
	
	static class Road {
		int start, end, exp;

		public Road(int start, int end, int exp) {
			this.start = start;
			this.end = end;
			this.exp = exp;
		}
	}
	
	static int N,M,W;
	static Road[] roads;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine());
		
		StringTokenizer st=null;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=Tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			roads = new Road[2*M+W];
			int idx=0;
			for(int i=0; i<M+W; i++) {
				st=new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				//도로 
				if(i<M) {
					roads[idx++]=new Road(S,E,T);
					roads[idx++]=new Road(E,S,T);
				}
				
				//웜홀
				else roads[idx++]=new Road(S,E,-T);
			}
			
			
			sb.append((bellmanFord() ? "YES" : "NO")).append("\n");
		}
		
		System.out.println(sb);
	}

	//벨만포드
	private static boolean bellmanFord() {
		dist=new int[N+1];
		dist[1]=0;
		
		for(int i=1; i<=N; i++) {
			for(Road r : roads) {
				if(dist[r.end]>dist[r.start]+r.exp) {
					if(i==N) return true;
					dist[r.end] = dist[r.start]+r.exp;
				}
			}
		}
		
		return false;
	}

}
