package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//우선순위큐 : 메모리초과 
public class Main_1753_최단경로2 {

	static int V,E,K;
	static int[][] matrix;
	static int[] dist;
	static boolean[] visited;
	
	private static class Vertex implements Comparable<Vertex>{
		int no;
		int totalDistance;
		
		public Vertex(int no, int totalDistance) {
			super();
			this.no = no;
			this.totalDistance = totalDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.totalDistance-o.totalDistance;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		matrix = new int[V+1][V+1];
		dist=new int[V+1];
		visited=new boolean[V+1];
		
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			matrix[u][v]=w;
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		dist[K]=0;
		pq.offer(new Vertex(K, dist[K]));
		
		Vertex cur=null;
		while(!pq.isEmpty()) {
			cur=pq.poll();
			if(visited[cur.no]) continue;
			
			visited[cur.no]=true;
			if(cur.no==V) break;
			
			for(int i=1; i<=V; i++) {
				if(!visited[i] && matrix[cur.no][i]!=0 &&
						dist[i]>cur.totalDistance+matrix[cur.no][i]) {
					dist[i]=cur.totalDistance+matrix[cur.no][i];
					pq.offer(new Vertex(i, dist[i]));
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
