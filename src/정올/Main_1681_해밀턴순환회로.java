package 정올;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1681_해밀턴순환회로 {
	
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

	static int N;
	static int[][] map;
	static boolean[] visited;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer st=null;
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		visited=new boolean[N];
		ans=Integer.MAX_VALUE;
		visited[0]=true;
		dfs(0,0,0);
		System.out.println(ans);
	}

	private static void dfs(int cnt, int cur, int sum) {
		if(sum>ans) return;
		if(cnt==N-1) {
			if(map[cur][0]!=0 && ans>sum+map[cur][0]) {
				ans=sum+map[cur][0];
			}
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			if(map[cur][i]==0) continue;
			
			visited[i]=true;
			dfs(cnt+1, i, sum+map[cur][i]);
			visited[i]=false;
		}
	}

}
