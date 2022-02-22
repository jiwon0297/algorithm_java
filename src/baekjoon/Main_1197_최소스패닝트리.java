package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}

	static int V,E;
	static int[] parents, rank;
	static Edge[] edgeList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		edgeList = new Edge[E];
		parents=new int[V+1];
		rank=new int[V+1];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edgeList[i]=new Edge(a,b,c);
		}
		Arrays.sort(edgeList);
		for(int i=1; i<=V; i++) {
			parents[i]=i;
			rank[i]=1;
		}
		
		int res=0, cnt=0;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				res+=edge.weight;
				if(++cnt==V-1) break;
			}
		}
		
		System.out.println(res);
	}
	
	public static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa==pb) return false;
		if(rank[pa]<rank[pb]) {
			parents[pa]=pb;
		} else {
			parents[pa]=pb;
			if(rank[pb]==rank[pa]) {
				rank[pa]++;
			}
		}
		return true;
	}

	private static int find(int a) {
		if(a==parents[a]) return a;
		else return parents[a]=find(parents[a]);
	}

}
