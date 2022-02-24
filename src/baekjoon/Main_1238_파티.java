package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238_파티 {

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
	
	static int N,M,X;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		X= Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] list = new ArrayList[N+1];
		ArrayList<Node>[] r_list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i]=new ArrayList<Node>();
			r_list[i]=new ArrayList<Node>();
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[v].add(new Node(u,w));
			r_list[u].add(new Node(v,w));
		}
		
		int[] dist=dijkstra(list);
		int[] r_dist=dijkstra(r_list);	
		
		int max=Integer.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			max=Math.max(max, dist[i]+r_dist[i]);
		}
		
		System.out.println(max);
	}

	private static int[] dijkstra(ArrayList<Node>[] list) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X]=0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(X,0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int v = cur.vertex;
			int w = cur.weight;
			
			if(dist[v]<w) continue;
			
			for(int i=0; i<list[v].size(); i++) {
				int v2=list[v].get(i).vertex;
				int w2=list[v].get(i).weight+w;
				
				if(dist[v2]>w2) {
					dist[v2]=w2;
					pq.offer(new Node(v2,w2));
				}
			}
		}
		return dist;
	}
}
