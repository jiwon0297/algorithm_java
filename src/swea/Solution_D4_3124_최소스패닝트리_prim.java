package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//232,548KB 2,961ms
public class Solution_D4_3124_최소스패닝트리_prim {
	
	static class Edge implements Comparable<Edge>{
		int to,Weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			Weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.Weight-o.Weight;
		}
	}
	
	static long res;
	static List<Edge>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			list=new ArrayList[V+1];
			for(int i=1; i<=V; i++) list[i]=new ArrayList<>();
			for(int i=0; i<E; i++) {
				st=new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				
				list[A].add(new Edge(B,C));
				list[B].add(new Edge(A,C));
			}
			
			visited=new boolean[V+1];
			res=0;
			prim(1);
			System.out.println("#"+t+" "+res);
		}
	}

	private static void prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int node = cur.to;
			int weight = cur.Weight;
			
			if(visited[node]) continue;
			
			visited[node]=true;
			res+=weight;
			
			for(Edge next:list[node]) {
				if(!visited[next.to]) pq.add(next);
			}
		}
	}
}
