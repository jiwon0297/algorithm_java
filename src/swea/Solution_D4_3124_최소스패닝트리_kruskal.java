package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//119,568KB 2,095ms
public class Solution_D4_3124_최소스패닝트리_kruskal {
	
	static class Edge implements Comparable<Edge>{
		int from,to,Weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from=from;
			this.to = to;
			this.Weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.Weight-o.Weight;
		}
	}
	
	static int V;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			parents=new int[V+1];
			for(int i=1; i<=V; i++) parents[i]=i;
			
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			for(int i=0; i<E; i++) {
				st=new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				
				pq.add(new Edge(A,B,C));
			}
			
			int size=pq.size();
			long res=0;
			for(int i=0; i<size; i++) {
				Edge edge = pq.poll();
				int r = find(edge.from);
				int c = find(edge.to);
				
				if(!isSameParent(r,c)) {
					res+=edge.Weight;
					union(edge.from, edge.to);
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}

	private static int find(int x) {
		if(parents[x]==x) return x;
		return parents[x]=find(parents[x]);
	}
	
	private static void union(int x, int y) {
		x=find(x);
		y=find(y);
		
		if(x<y) parents[y]=x;
		else parents[x]=y;
	}
	
	private static boolean isSameParent(int r, int c) {
		if(r==c) return true;
		return false;
	}
}
