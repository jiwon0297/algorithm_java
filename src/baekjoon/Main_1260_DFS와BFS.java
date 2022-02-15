package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	
	static int M;
	static int N;
	static int V;
	static int[][] graph;
	static boolean[] chk;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		chk=new boolean[N+1];
		graph=new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph[x][y]=graph[y][x]=1;
		}
		
		dfs(V);
		System.out.println();
		
		chk=new boolean[N+1];
		bfs();
	}

	private static void dfs(int v) {
		chk[v]=true;
		System.out.print(v+" ");
		for(int i=1; i<=N; i++) {
			if(graph[v][i]==1 && !chk[i]) dfs(i);
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		chk[V]=true;
		q.offer(V);
		System.out.print(V+" ");
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=1; i<=N; i++) {
				if(graph[cur][i]==1 && !chk[i]) {
					chk[i]=true;
					q.offer(i);
					System.out.print(i+" ");
				}
			}
		}
	}

}
