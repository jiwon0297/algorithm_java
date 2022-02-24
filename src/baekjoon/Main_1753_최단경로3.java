package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//인접리스트+pq
public class Main_1753_최단경로3 {

	static int V,E,K;
	static ArrayList<Node>[] matrix;
	static int[] dist;
	
	static class Node implements Comparable<Node>{
		int vertex;
		int weight;
		
		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}	
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		matrix = new ArrayList[V+1];
		dist=new int[V+1];
		for(int i=1; i<=V; i++) {
			matrix[i]=new ArrayList<>();
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K]=0;
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			matrix[u].add(new Node(v,w));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(K, 0));
		
		while(!pq.isEmpty()) {
			Node cur=pq.poll();
			int v = cur.vertex;
			int w = cur.weight;
			
			if(dist[v]<w) continue;
			
			for(int i=0; i<matrix[v].size(); i++) {
				int v2=matrix[v].get(i).vertex;
				int w2=matrix[v].get(i).weight+w;
				
				if(dist[v2]>w2) {
					dist[v2]=w2;
					pq.add(new Node(v2,w2));
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
