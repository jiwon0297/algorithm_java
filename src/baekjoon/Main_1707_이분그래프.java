package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1707_이분그래프 {

	static int V,E;
	static LinkedList<Integer>[] map;
	static int[] visited;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		for(int t=1; t<=K; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			map=new LinkedList[V+1];
			for(int i=1; i<=V; i++) {
				map[i]=new LinkedList<>();
			}
			for(int i=0; i<E; i++) {
				st=new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				map[u].add(v);
				map[v].add(u);
			}
			
			visited=new int[V+1];
			for(int i=1; i<=V; i++) {
				flag=true;
				if(visited[i]==0) bfs(i);
				if(!flag) {
					System.out.println("NO");
					break;
				}
			}
			
			if(flag) System.out.println("YES");
		}
	}

	private static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		visited[idx]=1;
		q.offer(idx);
		
		while(!q.isEmpty()) {
			int cur=q.poll();
			for(Integer next : map[cur]) {
				if(visited[next]==0) {
					q.offer(next);
					visited[next]=visited[cur]*-1;
				} else if(visited[cur]==visited[next]) {
					flag=false;
					return;
				}
			}
		}
	}

}
