package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//93828KB 3049ms
public class Solution_D4_5643_키순서_bfs {
	
	static int T,N,M;
	static int[][] adj;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		for(int t=1; t<=T; t++) {
			sb.append("#"+t+" ");
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adj=new int[N+1][N+1];		
			for(int i=0; i<M; i++) {
				st=new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				adj[a][b]=1;
				adj[b][a]=-1;
			}
			
			int cnt=0;
			for(int i=1; i<=N; i++) {
				int big = bfs_big(i);
				int small = bfs_small(i);
				if(big+small==N-1) cnt++;
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}

	static Queue<Integer> q;
	private static int bfs_small(int idx) {
		visited=new boolean[N+1];
		q = new LinkedList<>();
		q.offer(idx);
		visited[idx]=true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1; i<=N; i++) {
				if(adj[i][now]!=1 || visited[i]) continue;
				visited[i]=true;
				q.offer(i);
			}
		}
		
		int cnt=0;
		for(int i=1; i<=N; i++) if(visited[i]) cnt++;
		
		return cnt-1;
	}

	private static int bfs_big(int idx) {
		visited=new boolean[N+1];
		q = new LinkedList<>();
		q.offer(idx);
		visited[idx]=true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1; i<=N; i++) {
				if(adj[now][i]!=1 || visited[i]) continue;
				visited[i]=true;
				q.offer(i);
			}
		}
		
		int cnt=0;
		for(int i=1; i<=N; i++) if(visited[i]) cnt++;
		
		return cnt-1;
	}
}
