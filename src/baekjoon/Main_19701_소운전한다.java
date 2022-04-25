package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_19701_소운전한다 {
	
	static class Node2{
		int cost,eat,to;
		public Node2(int cost, int eat, int to) {
			super();
			this.cost = cost;
			this.eat = eat;
			this.to = to;
		}
	}
	
	static class Node implements Comparable<Node> {
		int cost,eat,from;
		public Node(int cost, int eat, int from) {
			super();
			this.cost = cost;
			this.eat = eat;
			this.from = from;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
	
	static int V,E;
	static int[][] dist;
	static List<Node2>[] adj;
	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[V+1];
		for(int i=0; i<=V; i++) adj[i]=new ArrayList<>();
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			adj[x].add(new Node2(time,k,y));
			adj[y].add(new Node2(time,k,x));
		}
		
		dijkstra();
		
		for(int i=2; i<=V; i++) {
			sb.append(Math.min(dist[i][0], dist[i][1])+"\n");
		}
		
		System.out.println(sb);
	}

	private static void dijkstra() {
		dist = new int[V+1][2];
		for(int i=1; i<=V; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		pq = new PriorityQueue<>();
		pq.offer(new Node(0,1,1));
		dist[1][1]=0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curX=cur.from;
			int curEat=cur.eat;
			int curCost=cur.cost;
			
			if(dist[curX][curEat]<cur.cost) continue;
			
			for(int i=0; i<adj[curX].size(); i++) {
				Node2 next = adj[curX].get(i);
				int nextX=next.to;
				int nextEat=next.eat;
				int nextCost=next.cost;
				
				//돈가스 냠냠
				if(curEat==1) {
					if(dist[nextX][0]>curCost+nextCost-nextEat) {
						dist[nextX][0]=curCost+nextCost-nextEat;
						pq.offer(new Node(dist[nextX][0],0,nextX));
					}
				}
				
				//돈가스 노냠냠
				if(dist[nextX][curEat]>curCost+nextCost) {
					dist[nextX][curEat]=curCost+nextCost;
					pq.offer(new Node(dist[nextX][curEat],curEat,nextX));
				}
			}
		}		
	}
}
