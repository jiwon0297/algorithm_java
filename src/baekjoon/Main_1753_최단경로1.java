package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//메모리초과 
public class Main_1753_최단경로1 {

	static int V,E,K;
	static int[][] matrix;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		matrix = new int[V+1][V+1];
		
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			matrix[u][v]=w;
		}
		
		dist=new int[V+1];
		visited=new boolean[V+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K]=0;
		
		int min=0, cur=0;
		for(int i=1; i<=V; i++) {
			min=Integer.MAX_VALUE;
			for(int j=1; j<=V; j++) {
				if(!visited[j] && min>dist[j]) {
					min=dist[j];
					cur=j;
				}
			}
			
			visited[cur]=true;
			if(cur==V) break;
			
			for(int j=1; j<=V; j++) {
				if(!visited[j] && matrix[cur][j]!=0 &&
						dist[j]>min+matrix[cur][j]) {
					dist[j]=min+matrix[cur][j];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(dist[i]==Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(dist[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
